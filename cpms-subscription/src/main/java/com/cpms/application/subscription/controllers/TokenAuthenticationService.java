//package com.cpms.application.subscription.controllers;
//
//import com.cpms.application.subscription.bean.AuthenticationUser;
//import com.cpms.application.subscription.bean.UserAuthentication;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.xml.bind.DatatypeConverter;
//
///**
// * Created by Rakib on 12/6/2015.
// */
//@Service
//public class TokenAuthenticationService {
//
//    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";
//    private static final long TEN_DAYS = 1000 * 60 * 60 * 24 * 10;
//
//    private final TokenHandler tokenHandler;
//
//    @Autowired
//    public TokenAuthenticationService(@Value("${token.secret}") String secret) {
//        tokenHandler = new TokenHandler(DatatypeConverter.parseBase64Binary(secret));
//    }
//
//    public void addAuthentication(HttpServletResponse response, UserAuthentication authentication) throws JsonProcessingException {
//        final AuthenticationUser user = authentication.getDetails();
//        user.setExpires(System.currentTimeMillis() + TEN_DAYS);
//        response.addHeader(AUTH_HEADER_NAME, tokenHandler.createTokenForUser(user));
//    }
//
//    public UserAuthentication getAuthentication(HttpServletRequest request) {
//        final String token = request.getHeader(AUTH_HEADER_NAME);
//        if (token != null) {
//            final AuthenticationUser user = tokenHandler.parseUserFromToken(token);
//            if (user != null) {
//                return new UserAuthentication(user);
//            }
//        }
//        return null;
//    }
//}