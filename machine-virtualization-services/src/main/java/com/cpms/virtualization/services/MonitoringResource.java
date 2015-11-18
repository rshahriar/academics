package com.cpms.virtualization.services;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by Rakib on 11/18/2015.
 */
@Path("monitoring")
public class MonitoringResource {

    @GET
    @Path("ultimaker")
    @Produces("application/json")
    public Response monitor() {
        String dummy = "{\"name\" : \"rakib\"}";
        return Response.ok(dummy).build();
    }
}
