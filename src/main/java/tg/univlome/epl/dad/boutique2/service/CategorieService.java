/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.dad.boutique2.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import tg.univlome.epl.dad.boutique2.entites.Categorie;

/**
 *
 * @author hordric
 */
@ApplicationScoped
public class CategorieService {
    private final List<Categorie> categories;
    private int nextId = 1;
    
    public CategorieService(){
        categories = new ArrayList<>();
    }
    
    public void ajouter(Categorie categorie){
        categorie.setId(nextId++);
        categories.add(categorie);
        System.out.println("Categorie ajouter avec success " +categorie);
    }    
    
    public void supprimer(Long id) {
        Categorie categorie = trouver(id);
        if (categorie != null) {
            categories.remove(categorie);
            System.out.println("Categorie supprimée: " + categorie);
        } else {
            System.out.println("Impossible de supprimer la catégorie : introuvable avec id " + id);
        }
    }
    
    public List<Categorie> lister(){
        return categories;
      
    }
    public int compter(){
        return categories.size();
    }
    
    public void modifier(Categorie nouveau) {
       int i = 0;
       for(Categorie  categorie : categories) {
           if(categorie.getId() == nouveau.getId()) {
               categories.set(i, nouveau);
               break;
           }
           i++;
       }
    }
    
    public Categorie trouver(Long id){
        for(Categorie e : categories){
            if(e.getId() == id){
                return e;
            }
        }
        System.out.println("Aucun id trouver avec : " +id);
        return null;
    }
    
    
}
