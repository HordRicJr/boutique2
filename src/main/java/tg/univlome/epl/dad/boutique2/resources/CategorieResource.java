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
import tg.univlome.epl.dad.boutique2.entites.Categorie;
import tg.univlome.epl.dad.boutique2.service.CategorieService;

/**
 *
 * @author hordric
 */
@Path("/categorie")
@RequestScoped 
public class CategorieResource {

    @Inject
    private CategorieService categorieService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ajouter(Categorie categorie) {
        if (categorie == null) {
            return Response.status(400).entity("Categorie ne peut pas \u00eatre null").build();
        }
        this.categorieService.ajouter(categorie);
        return Response.status(201).entity(categorie).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifier(Categorie categorie) {
        if (categorie == null) {
            return Response.status(400).entity("Categorie ne peut pas \u00eatre null").build();
        }
        Categorie existe = this.categorieService.trouver(categorie.getId());
        if (existe == null) {
            return Response.status(404).entity("Categorie non trouv\u00e9e").build();
        }
        this.categorieService.modifier(categorie);
        return Response.status(200).entity(categorie).build();
    }

    @Path("/{id}")
    @DELETE
    public Response supprimer(@PathParam("id") Long id) {
        Categorie categorie = this.categorieService.trouver(id);
        if (categorie == null) {
            return Response.status(404).entity("Categorie non trouv\u00e9e").build();
        }
        this.categorieService.supprimer(id);
        return Response.status(204).build();
    }

    @Path("/trouver/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Response trouver(@PathParam("id") Long id) {
        Categorie categorie = this.categorieService.trouver(id);
        if (categorie == null) {
            return Response.status(404).entity("Categorie non trouv\u00e9e").build();
        }
        return Response.status(200).entity(categorie).build();
    }

    @Path("/lister")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorie> lister() {
        return this.categorieService.lister();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public int compter() {
        return this.categorieService.compter();
    }

}
