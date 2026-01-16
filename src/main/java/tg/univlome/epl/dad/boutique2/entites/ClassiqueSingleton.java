/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.dad.boutique2.entites;

/**
 *
 * @author Hordric
 */
public class ClassiqueSingleton {
    private static ClassiqueSingleton objet;
    
    private ClassiqueSingleton(){
        
       
    }
    
    public static ClassiqueSingleton getIntance(){
        if ( objet == null){
            objet = new ClassiqueSingleton();
        }
        return objet;
    }
    public void afficherSingleton(){
        System.out.println("Cesi est la seule classe de singleton");
    }
    
}
