package com.cpms.application.subscription.controllers;

import com.cpms.application.subscription.bean.AuthenticationUser;
import com.cpms.application.subscription.dao.AbstractDAO;
import com.cpms.application.subscription.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.management.openmbean.InvalidKeyException;
import javax.security.sasl.AuthenticationException;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by Rakib on 12/6/2015.
 */
public class TokenHandler {

    private static final String HMAC_ALGO = "HmacSHA256";
    private static final String SECRET = "cpms_security";
    private static final String SEPARATOR = ".";

    private AbstractDAO<User> subscriptionDAO;

    private Mac hmac;

    public TokenHandler(AbstractDAO<User> subscriptionDAO) {
        this.subscriptionDAO = subscriptionDAO;
        try {
            hmac = Mac.getInstance(HMAC_ALGO);
            byte[] secretKey = DatatypeConverter.parseBase64Binary(SECRET);
            hmac.init(new SecretKeySpec(secretKey, HMAC_ALGO));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new IllegalStateException(
                    "failed to initialize HMAC: " + e.getMessage(), e);
        } catch (java.security.InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public String createTokenForUser(AuthenticationUser user) throws JsonProcessingException {
        byte[] userBytes = toJSON(user);
        byte[] hash = createHmac(userBytes);
        final StringBuilder sb = new StringBuilder(170);

        //String string = new String(Base64.encodeBase64(userBytes));
        sb.append(new String(Base64.encodeBase64(userBytes)));
        sb.append(SEPARATOR);
        sb.append(new String(Base64.encodeBase64(hash)));
        return sb.toString();
    }

    public AuthenticationUser parseUserFromToken(String token) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(token, SEPARATOR);
        if (stringTokenizer.countTokens() == 2) {
            final byte[] userBytes = Base64.decodeBase64(stringTokenizer.nextToken().getBytes());
            final byte[] hash = Base64.decodeBase64(stringTokenizer.nextToken());

            boolean validHash = Arrays.equals(createHmac(userBytes), hash);
            if (validHash) {
                final AuthenticationUser userFromWeb = fromJSON(userBytes);
                if (subscriptionDAO != null) {
                    User userFromDb = subscriptionDAO.getByEmail(userFromWeb.getUserEmail());
                    if (!userFromWeb.getPassword().equals(userFromDb.getUser_password())) {
                        throw new AuthenticationException("Authentication didn't match");
                    }
                }
                // Check expiry date of token
                if (new Date().getTime() < userFromWeb.getExpires()) {
                    return userFromWeb;
                } else {
                    throw new AuthenticationException("Authentication Expired");
                }
            } else {
                throw new AuthenticationException("Hash didn't match");
            }
        } else {
            throw new AuthenticationException("Bad Token");
        }
    }

    private byte[] toJSON(AuthenticationUser user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(user);
        return jsonInString.getBytes();
    }

    private AuthenticationUser fromJSON(byte[] userBytes) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new String(userBytes), AuthenticationUser.class);
    }

    // synchronized to guard internal hmac object
    private synchronized byte[] createHmac(byte[] content) {
        return hmac.doFinal(content);
    }
}
