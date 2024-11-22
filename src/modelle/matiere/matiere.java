/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.matiere;
import modelle.personnes.Enseignant;


/**
 *
 * @author souis
 */

    import java.util.ArrayList;
import java.util.List;

public class matiere {
    private static int compteurId = 0;  // Compteur pour générer les IDs
    private int idMatiere;              // ID unique pour chaque matière
    private String titreMatiere;        // Titre de la matière
    private List<Enseignant> enseignants; // Liste des enseignants pour cette matière
    private List<cours> cours;          // Liste des cours pour cette matière

    // Constructeur
    public matiere(String titreMatiere) {
        this.idMatiere = ++compteurId;       // ID auto-incrémenté
        this.titreMatiere = titreMatiere;
        this.enseignants = new ArrayList<>(); // Initialisation des listes vides
        this.cours = new ArrayList<>();
    }

    public matiere(String mathématiques, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters et Setters
    public int getIdMatiere() {
        return idMatiere;
    }

    public String getTitreMatiere() {
        return titreMatiere;
    }

    public void setTitreMatiere(String titreMatiere) {
        this.titreMatiere = titreMatiere;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public List<cours> getCours() {
        return cours;
    }

    // Méthode pour ajouter un enseignant à la liste des enseignants
    public void ajouterEnseignant(Enseignant enseignant) {
        enseignants.add(enseignant);
    }

    // Méthode pour ajouter un cours à la liste des cours
    public void ajouterCours(cours cours) {
        this.cours.add(cours);
    }

    // Méthode toString pour un affichage lisible des informations
    @Override
    public String toString() {
        return "Matière ID: " + idMatiere + "\n" +
               "Titre de la matière: " + titreMatiere + "\n" +
               "Enseignants: " + enseignants + "\n" +
               "Cours: " + cours;
    }
}


