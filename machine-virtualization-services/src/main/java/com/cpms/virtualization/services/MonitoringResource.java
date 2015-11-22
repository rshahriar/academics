package com.cpms.virtualization.services;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Rakib on 11/18/2015.
 */
@Path("monitoring")
public class MonitoringResource {

    @GET
    @Path("ultimaker")
    @Produces("application/json")
    public Response monitor() {
        // host ip of raspberry pi
        String hostName = "130.184.104.182";
        // port number of raspberry pi
        int portNumber = Integer.parseInt("12345");

        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out =
                        new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in =
                        new BufferedReader(
                                new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn =
                        new BufferedReader(
                                new InputStreamReader(System.in))
        ) {
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String dummy = "{\"name\" : \"rakib\"}";
        return Response.ok(dummy).build();
    }
}
