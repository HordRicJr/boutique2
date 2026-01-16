/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.dad.boutique2.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import tg.univlome.epl.dad.boutique2.entites.Produit;

/**
 *
 * @author hordric
 */
@ApplicationScoped
public class ProduitService {
    private final List<Produit> produits;
    private int nextId = 1;
    
    public ProduitService(){
        produits = new ArrayList<>();
    }
    
    public void ajouter(Produit produit){
        produit.setId(nextId++);
        produits.add(produit);
        System.out.println("Produit ajouter avec success " +produit);
    }    
    
  
    public void supprimer(Long id) {
        Produit produit = trouver(id);
        if (produit != null) {
            produits.remove(produit);
            System.out.println("Produit supprimé: " + produit);
        } else {
            System.out.println("Impossible de supprimer le produit : introuvable avec id " + id);
        }
    }
    
    public List<Produit> lister(){
      return this.produits;
    }
    public int compter(){
        return produits.size();
    }
    
    public void modifier(Produit nouveau) {
        int i =0;
        for(Produit p : produits) {
            if(p.getId() == nouveau.getId()) {
                produits.set(i, nouveau);
                break;
            }
            i++;
        }
        
    }
    
    public Produit trouver(Long id){
        for(Produit e : produits){
            if(e.getId() == id){
                return e;
            }
        }
        System.out.println("Aucun id trouver avec : " +id);
        return null;
    }
    
    
}
