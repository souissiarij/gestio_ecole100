/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.Bibliotheque;

/**
 *
 * @author user
 */

import modelle.personnes.Etudiant;
import java.util.ArrayList;

public class Bibliotheque {

    private String nomBibliotheque;
    private ArrayList<String> livresDisponibles;
    private ArrayList<Etudiant> etudiantsInscrits;

    // Constructeur
    public Bibliotheque(String nomBibliotheque) {
        this.nomBibliotheque = nomBibliotheque;
        this.livresDisponibles = new ArrayList<>();
        this.etudiantsInscrits = new ArrayList<>();
    }

    // Ajouter un livre à la bibliothèque
    public void ajouterLivre(String livre) {
        livresDisponibles.add(livre);
    }

    // Retirer un livre de la bibliothèque
    public void retirerLivre(String livre) {
        livresDisponibles.remove(livre);
    }

    // Ajouter un étudiant à la bibliothèque
    public void inscrireEtudiant(Etudiant etudiant) {
        etudiantsInscrits.add(etudiant);
    }

    // Permet à un étudiant d'emprunter un livre
    public void emprunterLivre(String livre, Etudiant etudiant) {
        if (livresDisponibles.contains(livre)) {
            System.out.println(etudiant.getNom() + " a emprunté le livre : " + livre);
            livresDisponibles.remove(livre);  // Le livre est retiré après l'emprunt
        } else {
            System.out.println("Le livre " + livre + " n'est pas disponible.");
        }
    }

    // Afficher les livres disponibles dans la bibliothèque
    public void afficherLivres() {
        System.out.println("Livres disponibles à " + nomBibliotheque + ":");
        for (String livre : livresDisponibles) {
            System.out.println("- " + livre);
        }
    }

    // Afficher les étudiants inscrits à la bibliothèque
    public void afficherEtudiants() {
        System.out.println("Étudiants inscrits à la bibliothèque:");
        for (Etudiant etudiant : etudiantsInscrits) {
            System.out.println("- " + etudiant.getNom() + " " + etudiant.getPrenom());
        }
    }


}
