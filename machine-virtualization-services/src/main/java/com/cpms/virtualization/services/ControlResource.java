package com.cpms.virtualization.services;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import org.apache.http.HttpStatus;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Rakib on 11/22/2015.
 */
@Path("control")
public class ControlResource {

    @POST
    @Path("ultimaker")
    @Consumes(value={MediaType.APPLICATION_JSON,MediaType.MULTIPART_FORM_DATA})
    @Produces(value={"text/html"})
    public Response controlMachine(@FormDataParam("file") InputStream uploadedInputStream,
                                   @FormDataParam("file") FormDataContentDisposition fileDetail) {
        String result = "Failure";
        try {
            result = new ConnectionManager().printFile(uploadedInputStream);
            return Response.ok().entity(result).build();
        } catch (IOException e) {
            return Response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)/*.header("Access-Control-Allow-Origin", "*")*/
                    .entity(result).build();
        }
    }
}
