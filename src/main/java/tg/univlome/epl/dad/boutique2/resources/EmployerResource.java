/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.dad.boutique2.resources;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import tg.univlome.epl.dad.boutique2.entites.Employe;
import tg.univlome.epl.dad.boutique2.service.EmployerService;

/**
 *
 * @author hordric
 */

@Path("/employee")
@RequestScoped  
public class EmployerResource {
    
    @Inject
    private EmployerService employerService;
   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   public Response ajouter(Employe employe) {
       if (employe == null) {
           return Response.status(400).entity("Employe ne peut pas \u00eatre null").build();
       }
       this.employerService.ajouter(employe);
       return Response.status(201).entity(employe).build();
   }
   
   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   public Response modifier(Employe employe) {
       if (employe == null) {
           return Response.status(400).entity("Employe ne peut pas \u00eatre null").build();
       }
       Employe existe = this.employerService.trouver(employe.getId());
       if (existe == null) {
           return Response.status(404).entity("Employe non trouv\u00e9").build();
       }
       this.employerService.modifier(employe);
       return Response.status(200).entity(employe).build();
   }
   
   @Path("/{id}")
   @DELETE
   public Response supprimer(@PathParam("id") Long id) {
       Employe employe = this.employerService.trouver(id);
       if (employe == null) {
           return Response.status(404).entity("Employe non trouv\u00e9").build();
       }
       this.employerService.supprimer(id);
       return Response.status(204).build();
   }
   
   @Path("/trouver/{id}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Response trouver(@PathParam("id") Long id) {
       Employe employe = this.employerService.trouver(id);
       if (employe == null) {
           return Response.status(404).entity("Employe non trouv\u00e9").build();
       }
       return Response.status(200).entity(employe).build();
   }
   
   @Path("/lister")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Employe> lister() {
       return this.employerService.lister();
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public int compter() {
       return this.employerService.compter();
   }
    
}
