/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.dad.boutique2.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import tg.univlome.epl.dad.boutique2.entites.Employe;

/**
 *
 * @author hordric
 */
@ApplicationScoped
public class EmployerService {
    private final List<Employe> employees;
    private int nextId = 1;
    
    public EmployerService(){
        employees = new ArrayList<>();
    }
    
    public void ajouter(Employe employe){
        employe.setId(nextId++);
        employees.add(employe);
        System.out.println("Employer ajouter avec success " +employe);
    }    
    
     public void supprimer(Long id) {
        Employe employe = trouver(id);
        if (employe != null) {
            employees.remove(employe);
            System.out.println("Employe supprimé: " + employe);
        } else {
            System.out.println("Impossible de supprimer l'employe : introuvable avec id " + id);
        }
    }
    
    public List<Employe> lister(){
       return this.employees;
      
    }
    public int compter(){
        return employees.size();
    }
    
    public void modifier(Employe nouveau) {
        int i = 0;
        for(Employe e : employees){
            if(e.getId() == nouveau.getId()){
                employees.set(i, nouveau);
                break;
            }
            i++;
        }
    }
    
    public Employe trouver(Long id){
        for(Employe e : employees){
            if(e.getId() == id){
                return e;
            }
        }
        System.out.println("Aucun id trouver avec : " +id);
        return null;
    }
    
}
