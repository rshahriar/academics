package com.cpms.virtualization.services;

import com.cpms.virtualization.models.Characteristics;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Rakib on 11/29/2015.
 */

@Path("status")
public class MachineStatusResource {

    @GET
    @Path("ultimaker")
    @Produces(MediaType.APPLICATION_JSON)
    public Response monitor() {
        String status = new ConnectionManager().getMachineStatus();
        return Response.ok().entity(status).header("Access-Control-Allow-Origin", "*").build();
    }

}
