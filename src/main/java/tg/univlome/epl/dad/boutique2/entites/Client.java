/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.dad.boutique2.entites;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 * @author hordric
 */
@XmlRootElement
public class Client extends Personne{

    private List<Achat> achats;

    public Client() {
    }

    public Client(String nom, String prenom, List<Achat> achats) {
        super(nom, prenom);
        this.achats = achats;
    }

    public List<Achat> getAchats() {
        return achats;
    }

    public void setAchats(List<Achat> achats) {
        this.achats = achats;
    }

    @Override
    public String toString() {
        return "Client{"
                + "id=" +getId()+ ","
                + "nom=" +getNom()+ ","
                + "prenom" +getPrenom()+ '}';
    }
    
    
    
}
