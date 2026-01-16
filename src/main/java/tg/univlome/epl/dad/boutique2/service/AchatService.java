/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.dad.boutique2.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import tg.univlome.epl.dad.boutique2.entites.Achat;

/**
 *
 * @author hordric
 */
@ApplicationScoped
public class AchatService {
    private final List<Achat> achats;
    private int nextId = 1;
    
    public AchatService(){
        achats = new ArrayList<>();
    }
    
    public void ajouter(Achat achat){
        achat.setId(nextId++);
        achats.add(achat);
        System.out.println("Achat ajouter avec success " +achat);
    }    
    
   /* public void supprimer (Achat achat){
        if(achat != null && achats.contains(achat) ){
            achats.remove(achat);
            System.out.println("Achat supprimer " +achat);
        }else{
            System.out.println("Impossible de supprimer l'achat : introuvable");
        }
    }*/
    
    public void supprimer(Long id) {
        Achat achat = trouver(id);
        if (achat != null) {
            achats.remove(achat);
            System.out.println("Achat supprimé: " + achat);
        } else {
            System.out.println("Impossible de supprimer l'achat : introuvable avec id " + id);
        }
    }
    
    public List<Achat> lister(){
        return achats;
    }
    
    public int compter(){
        return achats.size();
    }
    
    public void modifier(Achat nouveau) {
        int i = 0;
        for(Achat achat : achats) {
            if(achat.getId() == nouveau.getId()) {
                achats.set(i, nouveau);
                break;
            }
            i++;
        }
    }
    
    public Achat trouver(Long id){
        for(Achat e : achats){
            if(e.getId() == id){
                return e;
            }
        }
        System.out.println("Aucun id trouver avec : " +id);
        return null;
    }
    
    
}
