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
import tg.univlome.epl.dad.boutique2.entites.Achat;
import tg.univlome.epl.dad.boutique2.service.AchatService;

/**
 *
 * @author hordric
 */

@Path("/achat")
@RequestScoped  
public class AchatResource {
    
   @Inject
   private AchatService achatService;
   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response ajouter(Achat achat) {
       if (achat == null) {
           return Response.status(400).entity("Achat ne peut pas \u00eatre null").build();
       }
       this.achatService.ajouter(achat);
       return Response.status(201).entity(achat).build();
   }
   
   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response modifier(Achat achat) {
       if (achat == null) {
           return Response.status(400).entity("Achat ne peut pas \u00eatre null").build();
       }
       Achat existe = this.achatService.trouver(achat.getId());
       if (existe == null) {
           return Response.status(404).entity("Achat non trouv\u00e9").build();
       }
       this.achatService.modifier(achat);
       return Response.status(200).entity(achat).build();
   }
   
   @Path("/{id}")
   @DELETE
   public Response supprimer(@PathParam("id") Long id) {
       Achat achat = this.achatService.trouver(id);
       if (achat == null) {
           return Response.status(404).entity("Achat non trouv\u00e9").build();
       }
       this.achatService.supprimer(id);
       return Response.status(204).build();
   }
   
   @Path("/trouver/{id}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Response trouver(@PathParam("id") Long id) {
       Achat achat = this.achatService.trouver(id);
       if (achat == null) {
           return Response.status(404).entity("Achat non trouv\u00e9").build();
       }
       return Response.status(200).entity(achat).build();
   }
   
   @Path("/lister")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Achat> lister() {
       return this.achatService.lister();
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public int compter() {
       return this.achatService.compter();
   }
    
}
