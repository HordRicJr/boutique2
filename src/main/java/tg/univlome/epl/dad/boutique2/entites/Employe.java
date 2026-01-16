/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.dad.boutique2.entites;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hordric
 */
@XmlRootElement
public class Employe extends Personne{
    private LocalDate dateNaissance;
    
    private List<Achat> achats;

    public Employe() {
       
    }

    public Employe( String nom, String prenom ,LocalDate dateNaissance, List<Achat> achats) {
        super(nom, prenom);
        this.dateNaissance = dateNaissance;
        this.achats = achats;
    }

    public List<Achat> getAchats() {
        return achats;
    }

    public void setAchats(List<Achat> achats) {
        this.achats = achats;
    }
    
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return "Employe{"
                + "id=" +getId()+ ","
                + "nom=" +getNom()+ ","
                + "prenom" +getPrenom()+ ","
                + "dateNaissance=" + dateNaissance +
                '}';
    }
    
    
}
