/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.dad.boutique2.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import tg.univlome.epl.dad.boutique2.entites.Client;

/**
 *
 * @author hordric
 */
@ApplicationScoped
public class ClientService {
    private final List<Client> clients;
    private int nextId = 1;
    
    public ClientService(){
        clients = new ArrayList<>();
    }
    
    public void ajouter(Client client){
        client.setId(nextId++);
        clients.add(client);
        System.out.println("Client ajouter avec success " +client);
    }    
    
    
    public void supprimer(Long id) {
        Client client = trouver(id);
        if (client != null) {
            clients.remove(client);
            System.out.println("Client supprimé: " + client);
        } else {
            System.out.println("Impossible de supprimer le client : introuvable avec id " + id);
        }
    }
    
    public List<Client> lister(){
       return clients;
      
    }
    public int compter(){
        return clients.size();
    }
    
    public void modifier(Client nouveau) {
        int i = 0;
        for(Client c : clients) {
            if(c.getId() == nouveau.getId()) {
                clients.set(i, nouveau);
                break;
            }
            i++;
        }
    }
    
    public Client trouver(Long id){
        for(Client e : clients){
            if(e.getId() == id){
                return e;
            }
        }
        System.out.println("Aucun id trouver avec : " +id);
        return null;
    }
    
    
}
