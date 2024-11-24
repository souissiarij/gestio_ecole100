/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.personnes;
import modelle.matiere.matiere;

/**
 *
 * @author souis
 */
import java.util.ArrayList;

import java.util.ArrayList;

public class Enseignant extends Personne {
    private String specialite;
    private ArrayList<matiere> listeMatieresEnseignes; // Supposons que `Matiere` est une classe définie

    // Constructeur
    public Enseignant(String id, String nom, String prenom, String email, String specialite) {
        super(id, nom, prenom, email); // Appel au constructeur de la classe parente `Personne`
        this.specialite = specialite;
        this.listeMatieresEnseignes = new ArrayList<>(); // Initialisation de la liste
    }

 
    

    // Getter et setter pour la spécialité
    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    public ArrayList<matiere>  getlistematiere ()
    { return listeMatieresEnseignes;}

    // Méthode pour ajouter une matière enseignée
    public void ajouterMatiere(matiere m) {
        listeMatieresEnseignes.add(m);
    }
    
    // Méthode pour afficher la liste des matières enseignées
    public void afficherMatiereEnseignes() {
        System.out.println("Matières enseignées par " + getNom() + " " + getPrenom() + " : " + listeMatieresEnseignes);
    }

    // Méthode toString pour afficher toutes les informations de l'enseignant
    @Override
    public String toString() {
        return "Enseignant{" +
               "ID='" + getId() + '\'' +
               ", Nom='" + getNom() + '\'' +
               ", Prénom='" + getPrenom() + '\'' +
               ", Email='" + getEmail() + '\'' +
               ", Spécialité='" + specialite + '\'' +
               ", Matières enseignées=" + listeMatieresEnseignes +
               '}';
    }
}

 