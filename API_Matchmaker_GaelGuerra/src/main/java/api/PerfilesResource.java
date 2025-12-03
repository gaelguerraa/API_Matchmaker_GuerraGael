/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import dominio.Perfil;
import dtos.ProfileBO;
import dtos.ProfileDAO;
import dtos.ProfileDTO;
import dtos.ProfileMapper;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * REST Web Service
 *
 * @author gael_
 */
@Path("perfiles")
@RequestScoped
public class PerfilesResource {

    private static final Logger logger = Logger.getLogger(PerfilesResource.class.getName());
    

    private ProfileDAO perfilDAO;
    private ProfileBO profileBO;


    /**
     * Creates a new instance of PerfilesResource
     */
    public PerfilesResource() {
        this.perfilDAO = new ProfileDAO();
        this.profileBO = new ProfileBO(this.perfilDAO);
    }

    /**
     * Retrieves representation of an instance of api.PerfilesResource
     * @return an instance of dtos.ProfileDTO
     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public ProfileDTO getJson(@QueryParam("edad") int edad) {
//        logger.info("edad" + edad);
//           return new ProfileDTO("Alexander", "Gaskarth", "United States");
//    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProfileDTO getProfile(@QueryParam("genero") String genero, 
        @QueryParam("pais") String pais, 
        @QueryParam("edad") int edad) {

        logger.log(Level.INFO, "Buscando match - Genero: {0}, Pais: {1}, Edad: {2}", new Object[]{genero, pais, edad});
        
        try {
             ProfileDTO match = profileBO.encontrarMatch(genero, pais, edad);
            
            if (match != null) {
                return match;
            } else {

                return null;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al buscar perfiles.", e);
            return null;
        }
    
    }


    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postProfile(ProfileDTO dto){
        logger.log(Level.INFO, "Recibida petición POST para agregar perfil: {0}", dto.getNombre());
        
        try {
            Perfil nuevoPerfil = ProfileMapper.mapToEntity(dto);
            perfilDAO.agregarPerfil(nuevoPerfil);
            
            logger.log(Level.INFO, "Petición exitosa POST para agregar perfil: {0}", dto.getNombre());
            
        } catch (RuntimeException e) {
            logger.log(Level.SEVERE, "Error al procesar y guardar el perfil.", e);

        }
    
    }
}
