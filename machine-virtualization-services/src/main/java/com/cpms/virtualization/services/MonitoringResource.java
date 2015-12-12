package com.cpms.virtualization.services;

import com.cpms.virtualization.models.Monitor;
import org.apache.http.HttpStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by Rakib on 11/18/2015.
 */
@Path("monitoring")
public class MonitoringResource {

    @GET
    @Path("ultimaker")
    @Produces(MediaType.APPLICATION_JSON)
    public Response monitor() {
        Monitor monitor = new Monitor();
        try {
            monitor = new ConnectionManager().getMonitorData();
            return Response.ok().entity(monitor).build();
        } catch (IOException e) {
            return Response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)/*.header("Access-Control-Allow-Origin", "*")*/
                    .entity(monitor).build();
        }
    }
}
