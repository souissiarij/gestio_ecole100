package modelle.Bibliotheque;

import modelle.personnes.Etudiant;
import java.util.ArrayList;

public class Bibliotheque {

    private String idb;
    private ArrayList<String> livresDisponibles;
    private String idE ;
    private ArrayList<String> emprunts;  // Liste des emprunts sous forme de chaîne

    // Constructeur

    public Bibliotheque(String idb, ArrayList<String> livresDisponibles, String idE, ArrayList<String> emprunts) {
        this.idb = idb;
        this.livresDisponibles = livresDisponibles;
        this.idE = idE;
        this.emprunts = emprunts;
    }
 

    // Ajouter un livre à la bibliothèque
    public void ajouterLivre(String livre) {
        livresDisponibles.add(livre);
    }

    // Retirer un livre de la bibliothèque
    public void retirerLivre(String livre) {
        livresDisponibles.remove(livre);
    }

    
    // Permet à un étudiant d'emprunter un livre
  public void emprunterLivre(String livre) {
        if (livresDisponibles.contains(livre)) {
            livresDisponibles.remove(livre);
            emprunts.add(livre);
        }
  }

    // Afficher les livres disponibles dans la bibliothèque
    public void afficherLivresDisponibles() {
        System.out.println("Livres disponibles à " + idb + ":");
        for (String livre : livresDisponibles) {
            System.out.println("- " + livre);
        }
    }

    // Afficher tous les emprunts effectués
    public void afficherEmprunts() {
        System.out.println("Emprunts effectués :");
        for (String emprunt : emprunts) {
            System.out.println(emprunt);
        }
    }

    // Afficher les étudiants inscrits à la bibliothèque
 

    // Getter pour la liste des livres disponibles
    public ArrayList<String> getLivresDisponibles() {
        return livresDisponibles;
    }

    public String getIdb() {
        return idb;
    }

    public String getIdE() {
        return idE;
    }

    public ArrayList<String> getEmprunts() {
        return emprunts;
    }
    
    public void retournerLivre(String livre) {
        if (emprunts.contains(livre)) {
            emprunts.remove(livre);
            livresDisponibles.add(livre);
        }
    }

    public void setIdb(String idb) {
        this.idb = idb;
    }

    public void setLivresDisponibles(ArrayList<String> livresDisponibles) {
        this.livresDisponibles = livresDisponibles;
    }

    public void setIdE(String idE) {
        this.idE = idE;
    }

    public void setEmprunts(ArrayList<String> emprunts) {
        this.emprunts = emprunts;
    }
    
    
}
