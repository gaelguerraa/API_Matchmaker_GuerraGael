/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import dtos.ProfileDTO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.MediaType;
import java.util.GregorianCalendar;

/**
 * REST Web Service
 *
 * @author gael_
 */
@Path("perfiles")
@RequestScoped
public class PerfilesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PerfilesResource
     */
    public PerfilesResource() {
    }

    /**
     * Retrieves representation of an instance of api.PerfilesResource
     * @return an instance of dtos.ProfileDTO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProfileDTO getJson() {
           return new ProfileDTO("Alexander", "Gaskarth", "William", new GregorianCalendar(1987, 12, 14),
            "https://res.cloudinary.com/dyrin57yj/image/upload/v1764622666/alex_izes31.jpg",
            "alex.gw@mail.com", "Male", "GB",
            "(513)472-0970", "(513)472-0980", "3153 Westheimer Rd", 37);
    }

    /**
     * PUT method for updating or creating an instance of PerfilesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(ProfileDTO content) {
    }
}
