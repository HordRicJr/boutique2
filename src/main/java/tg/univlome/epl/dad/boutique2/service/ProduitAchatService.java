/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.dad.boutique2.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import tg.univlome.epl.dad.boutique2.entites.ProduitAchete;

/**
 *
 * @author hordric
 */
@ApplicationScoped
public class ProduitAchatService {
    private final List<ProduitAchete> produitAchetes;
    private int nextId = 1;
    
    public ProduitAchatService(){
        produitAchetes = new ArrayList<>();
    }
    
    public void ajouter(ProduitAchete produitAchete){
        produitAchete.setId(nextId++);
        produitAchetes.add(produitAchete);
        System.out.println("Produit acheter ajouter avec success " +produitAchete);
    }    
    
    public void supprimer(Long id) {
        ProduitAchete produitAchete = trouver(id);
        if (produitAchete != null) {
            produitAchetes.remove(produitAchete);
            System.out.println("ProduitAchete supprimé: " + produitAchete);
        } else {
            System.out.println("Impossible de supprimer le produit acheté : introuvable avec id " + id);
        }
    }
    
    public List<ProduitAchete> lister(){
      return produitAchetes;
    }
    public int compter(){
        return produitAchetes.size();
    }
    
    public void modifier(ProduitAchete nouveau) {
       int i = 0 ;
       for(ProduitAchete produitAchat : produitAchetes) {
           if(produitAchat.getId() == nouveau.getId()) {
               produitAchetes.set(i, nouveau);
               break;
           }
           i++;
       }
    }
    
    public ProduitAchete trouver(Long id){
        for(ProduitAchete e : produitAchetes){
            if(e.getId() == id){
                return e;
            }
        }
        System.out.println("Aucun id trouver avec : " +id);
        return null;
    }
    
}
