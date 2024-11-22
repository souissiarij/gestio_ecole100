/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.matiere;
import modelle.personnes.Enseignant;
/**
 *
 * @author souis
 * testtestetstestets git
 */
public class cours {
    private static int compteurId = 0;  // Compteur pour générer les IDs
    private int idCours;  // ID unique pour chaque instance de cours
    private String titreCours;
    private Enseignant enseignant;

    // Constructeur
    public cours(String titreCours, Enseignant enseignant) {
        this.idCours = ++compteurId;  // Incrémentation et affectation de l'ID
        this.titreCours = titreCours;
        this.enseignant = enseignant;
    }

    public cours(String chapitre_1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters et Setters
    public int getIdCours() {
        return idCours;
    }

    public String getTitreCours() {
        return titreCours;
    }

    public void setTitreCours(String titreCours) {
        this.titreCours = titreCours;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    // Méthode toString pour retourner une chaîne descriptive
    @Override
    public String toString() {
        return "Cours ID: " + idCours + "\n" +
               "Titre du cours: " + titreCours + "\n" +
               "Enseignant: " + enseignant;
    }
}
//