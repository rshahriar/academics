package com.cpms.virtualization.filters;

import com.google.common.base.Strings;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakib on 12/11/2015.
 */
public class AuthFilter implements ContainerRequestFilter {

    private static final String authorizationUrl = "http://130.184.104.151:8084/cpms-subscription/validate";
    // Exception thrown if user is unauthorized.
    private final static WebApplicationException unauthorized =
            new WebApplicationException(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .status(HttpStatus.SC_UNAUTHORIZED)
                            .entity("Access Denied : Authorization Fails").build());

    @Override
    public ContainerRequest filter(ContainerRequest containerRequest)
            throws WebApplicationException {

        if(containerRequest.getMethod().equals("OPTIONS")) {
            return containerRequest;
        }

        // FIXME: HackAlert
        if (containerRequest.getMethod().equals("POST")) {
            return containerRequest;
        }

        // Get the authentication passed in HTTP headers parameters
        String authToken = containerRequest.getHeaderValue("Authorization");
        if (Strings.isNullOrEmpty(authToken)) {
            throw unauthorized;
        }

        HttpClient client = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(client.getParams(), 5000);
        HttpPost post = new HttpPost(authorizationUrl);
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("token", authToken));
        try {
            post.setEntity(new UrlEncodedFormEntity(nvps));
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw unauthorized;
            }
        } catch (java.io.IOException e) {
            throw unauthorized;
        }
        return containerRequest;
    }
}