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
import tg.univlome.epl.dad.boutique2.entites.ProduitAchete;
import tg.univlome.epl.dad.boutique2.service.ProduitAchatService;

/**
 *
 * @author richard
 */

@Path("/produitAchat")
@RequestScoped
public class ProduitAchatResource {
        
    @Inject
    private ProduitAchatService produitAchatService;
   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response ajouter(ProduitAchete produitAchate) {
       if (produitAchate == null) {
           return Response.status(400).entity("ProduitAchete ne peut pas \u00eatre null").build();
       }
       this.produitAchatService.ajouter(produitAchate);
       return Response.status(201).entity(produitAchate).build();
   }
   
   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response modifier(ProduitAchete produitAchate) {
       if (produitAchate == null) {
           return Response.status(400).entity("ProduitAchete ne peut pas \u00eatre null").build();
       }
       ProduitAchete existe = this.produitAchatService.trouver(produitAchate.getId());
       if (existe == null) {
           return Response.status(404).entity("ProduitAchete non trouv\u00e9").build();
       }
       this.produitAchatService.modifier(produitAchate);
       return Response.status(200).entity(produitAchate).build();
   }
   
   @Path("/{id}")
   @DELETE
   public Response supprimer(@PathParam("id") Long id) {
       ProduitAchete produitAchete = this.produitAchatService.trouver(id);
       if (produitAchete == null) {
           return Response.status(404).entity("ProduitAchete non trouv\u00e9").build();
       }
       this.produitAchatService.supprimer(id);
       return Response.status(204).build();
   }
   
   @Path("/trouver/{id}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Response trouver(@PathParam("id") Long id) {
       ProduitAchete produitAchete = this.produitAchatService.trouver(id);
       if (produitAchete == null) {
           return Response.status(404).entity("ProduitAchete non trouv\u00e9").build();
       }
       return Response.status(200).entity(produitAchete).build();
   }
   
   @Path("/lister")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<ProduitAchete> lister() {
       return this.produitAchatService.lister();
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public int compter() {
       return this.produitAchatService.compter();
   }
    
}
