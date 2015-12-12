package com.cpms.virtualization.services;

import com.cpms.virtualization.models.Characteristics;
import com.cpms.virtualization.models.Monitor;
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

@Path("characteristics")
public class CharacteristicsResource {

    @GET
    @Path("ultimaker")
    @Produces(MediaType.APPLICATION_JSON)
    public Response monitor() {
        Characteristics characteristics = new Characteristics();
        try {
            characteristics = new ConnectionManager().getCharacteristicsData();
            return Response.ok().entity(characteristics).build();
        } catch (IOException e) {
            return Response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).entity(characteristics).build();
        }
    }

}
