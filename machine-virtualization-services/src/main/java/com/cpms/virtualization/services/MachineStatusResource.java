package com.cpms.virtualization.services;

import com.cpms.virtualization.models.Characteristics;
import org.apache.http.HttpStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by Rakib on 11/29/2015.
 */

@Path("status")
public class MachineStatusResource {

    @GET
    @Path("ultimaker")
    public Response monitor() {
        String status;
        try {
            status = new ConnectionManager().getMachineStatus();
            return Response.ok().entity(status).build();
        } catch (IOException e) {
            status = "Machine Not Available";
            return Response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)/*.header("Access-Control-Allow-Origin", "*")*/
                    .entity(status).build();
        }
    }
}
