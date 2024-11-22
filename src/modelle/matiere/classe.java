/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

        /**
 *
 * @author souis
 */


package modelle.matiere;

import modelle.personnes.Etudiant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class classe {
    private int idClasse;
    private String nomClasse;
    private List<Etudiant> listeEtudiants;

    // Constructeur
    public classe(int idClasse, String nomClasse) {
        this.idClasse = idClasse;
        this.nomClasse = nomClasse;
        this.listeEtudiants = new ArrayList<>();
    }

    // Méthode pour ajouter un étudiant à la liste
    public void ajouterEtudiant(Etudiant etudiant) {
        listeEtudiants.add(etudiant);
    }

    // Getters et Setters
    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public List<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }

    // Méthode pour filtrer les étudiants par un critère (par exemple, le nom)
    public List<Etudiant> filtrerEtudiantsParNom(String nom) {
        return listeEtudiants.stream()
                             .filter(etudiant -> etudiant.getNom().contains(nom))
                             .collect(Collectors.toList());
    }

    // Méthode pour trier les étudiants par nom
    public List<Etudiant> trierEtudiantsParNom() {
        return listeEtudiants.stream()
                             .sorted((e1, e2) -> e1.getNom().compareTo(e2.getNom()))
                             .collect(Collectors.toList());
    }

   
    @Override
    public String toString() {
        return "Classe " + nomClasse + " (ID: " + idClasse + "), Nombre d'étudiants: " + listeEtudiants.size();
    }
}