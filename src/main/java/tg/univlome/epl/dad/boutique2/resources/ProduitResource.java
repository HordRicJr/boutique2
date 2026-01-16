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
import tg.univlome.epl.dad.boutique2.entites.Produit;
import tg.univlome.epl.dad.boutique2.service.ProduitService;

/**
 *
 * @author hordric
 */
@Path("/produit")
@RequestScoped  
public class ProduitResource {
    
    @Inject
    private ProduitService service;
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response ajouter(Produit p) {
        if (p == null) {
            return Response.status(400).entity("Produit ne peut pas \u00eatre null").build();
        }
        this.service.ajouter(p);
        return Response.status(200).entity(p).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifier(Produit p) {
        if (p == null) {
            return Response.status(400).entity("Produit ne peut pas \u00eatre null").build();
        }
        Produit existe = this.service.trouver(p.getId());
        if (existe == null) {
            return Response.status(404).entity("Produit non trouv\u00e9").build();
        }
        this.service.modifier(p);
        return Response.status(200).entity(p).build();
    }
    
    @Path("/trouver/{id}")
    @GET
    public Response trouver(@PathParam("id") Long id) {
        Produit produit = this.service.trouver(id);
        if (produit == null) {
            return Response.status(404).entity("Produit non trouv\u00e9").build();
        }
        return Response.status(200).entity(produit).build();
    }
    
    @Path("/{id}")
    @DELETE
    public Response supprimer(@PathParam("id") Long id) {
        Produit produit = this.service.trouver(id);
        if (produit == null) {
            return Response.status(404).entity("Produit non trouv\u00e9").build();
        }
        this.service.supprimer(id);
        return Response.status(204).build();
    }
    
    @Path("/lister")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produit> lister() {
       return this.service.lister();
    }
    
    @Path("/compter")
    @GET

    public int compter() {
        return this.service.compter();
    }
}
