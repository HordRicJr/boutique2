package tg.univlome.epl.dad.boutique2.entites;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import jakarta.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hordric
 */
@XmlRootElement
public class Achat {
    private long id ;
    
    private LocalDate dateAchat;
    
    private double remise;
  
    private Employe employe;
   
    private Client client;
    private List<ProduitAchete> produitAchetes = new ArrayList<>();;
    
    
    public Achat() {
    }
    
    

    public Achat(long id, LocalDate dateAchat, double remise, Employe employe, Client client, List<ProduitAchete> produitAchetes) {
        this.id = id;
        this.dateAchat = dateAchat;
        this.remise = remise;
        this.employe = employe;
        this.client = client;
        this.produitAchetes = produitAchetes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    
    public Client getClient(){
        return client;
    }
    
    public void setClient(Client client){
        this.client = client;
    }

    public List<ProduitAchete> getProduitAchetes() {
        return produitAchetes;
    }

    public void setProduitAchetes(List<ProduitAchete> produitAchetes) {
        this.produitAchetes = produitAchetes;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Achat other = (Achat) obj;
        return this.id == other.id;
    }
    
    public double getRemiseTotal(){
        double totalRemise = 0.0;
        for(ProduitAchete p : produitAchetes){
            totalRemise += p.getRemise();
        }
        return totalRemise + this.remise;
    }
    
    public double getTotalPayer(){
        double total = 0.0;
        for(ProduitAchete p : produitAchetes){
            Produit produit = p.getProduit();
            if ( produit != null){
                total += produit.getPrixUnitaire() - p.getRemise();
            }
        }
        return total - this.remise;
    }

    @Override
    public String toString() {
        return "Achat{" 
                + "id=" + id + ","
                + " dateAchat=" + dateAchat + ", "
                + "remise=" + remise + ","
                + " employeId=" + (employe != null ? employe.getId() : null) + ", "
                + "clientId=" + (client != null ? client.getId() : null) + 
                '}';
    }   
}
