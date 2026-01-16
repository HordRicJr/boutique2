/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.dad.boutique2.entites;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

/**
 *
 * @author hordric
 */
@XmlRootElement
public class Produit {
    private long id;
    
    private String libelle;
    
    private double prixUnitaire;
    
    private LocalDate datePerention;
    

    private Categorie categorie;

    public Produit() {
        
    }

    public Produit(long id, String libelle, double prixUnitaire, LocalDate datePerention, Categorie categorie) {
        this.id = id;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.datePerention = datePerention;
        this.categorie = categorie;
    }

    public Produit(long id, String libelle, double prixUnitaire, LocalDate datePerention) {
        this.id = id;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.datePerention = datePerention;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public LocalDate getDatePerention() {
        return datePerention;
    }

    public void setDatePerention(LocalDate datePerention) {
        this.datePerention = datePerention;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Produit other = (Produit) obj;
        return this.id == other.id;
    }
    
    
    public boolean estPerimer(){
        LocalDate perimer = LocalDate.now(); 
        return datePerention.isBefore(perimer);  
    }
    
    public boolean estPerimer(LocalDate dateReference){
        return datePerention.isBefore(dateReference);
    }

    @Override
    public String toString() {
        return "Produit{" 
                + "id=" + id + ","
                + " libelle=" + libelle + ","
                + " prixUnitaire=" + prixUnitaire + ","
                + " datePerention=" + datePerention + ","
                + " categorieId=" + (categorie != null ? categorie.getId() : null) + 
                '}';
    }
    
    
    
}
