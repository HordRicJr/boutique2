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
import tg.univlome.epl.dad.boutique2.entites.Client;
import tg.univlome.epl.dad.boutique2.service.ClientService;

/**
 *
 * @author hordric
 */

@Path("/client")
@RequestScoped  
public class ClientResource {
     @Inject
     private ClientService clientService;
   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response ajouter(Client client) {
       if (client == null) {
           return Response.status(400).entity("Client ne peut pas \u00eatre null").build();
       }
       this.clientService.ajouter(client);
       return Response.status(201).entity(client).build();
   }
   
   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response modifier(Client client) {
       if (client == null) {
           return Response.status(400).entity("Client ne peut pas \u00eatre null").build();
       }
       Client existe = this.clientService.trouver(client.getId());
       if (existe == null) {
           return Response.status(404).entity("Client non trouv\u00e9").build();
       }
       this.clientService.modifier(client);
       return Response.status(200).entity(client).build();
   }
   
   @Path("/{id}")
   @DELETE
   public Response supprimer(@PathParam("id") Long id) {
       Client client = this.clientService.trouver(id);
       if (client == null) {
           return Response.status(404).entity("Client non trouv\u00e9").build();
       }
       this.clientService.supprimer(id);
       return Response.status(204).build();
   }
   
   @Path("/trouver/{id}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Response trouver(@PathParam("id") Long id) {
       Client client = this.clientService.trouver(id);
       if (client == null) {
           return Response.status(404).entity("Client non trouv\u00e9").build();
       }
       return Response.status(200).entity(client).build();
   }
   
   @Path("/lister")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Client> lister() {
       return this.clientService.lister();
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public int compter() {
       return this.clientService.compter();
   }
    
}
