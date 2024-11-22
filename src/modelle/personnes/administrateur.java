/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.personnes;
import modelle.matiere.matiere;
import modelle.matiere.cours; 
import modelle.matiere.certificat; 
import modelle.personnes.Absence;
import modelle.evaluation.EtatEtudiant;

/**
 *
 * @author souis
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class administrateur {
    private ArrayList<Etudiant> listeEtudiants;
    private ArrayList<Enseignant> listeProfesseurs;
    private ArrayList<matiere> listeMatieres;
    private Map <Etudiant, EtatEtudiant > resultatetudiants ; 

    private ArrayList<certificat> listeCertificats;

    // Constructeur
    public administrateur() {
        this.listeEtudiants = new ArrayList<>();
        this.listeProfesseurs = new ArrayList<>();
        this.listeMatieres = new ArrayList<>();
        this.resultatetudiants = new HashMap <>();
     
        this.listeCertificats = new ArrayList<>();
    }

    // Getters et Setters
    public ArrayList<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }

    public void setListeEtudiants(ArrayList<Etudiant> listeEtudiants) {
        this.listeEtudiants = listeEtudiants;
    }

    public ArrayList<Enseignant> getListeProfesseurs() {
        return listeProfesseurs;
    }

    public void setListeProfesseurs(ArrayList<Enseignant> listeProfesseurs) {
        this.listeProfesseurs = listeProfesseurs;
    }

    public ArrayList<matiere> getListeMatieres() {
        return listeMatieres;
    }

    public void setListeMatieres(ArrayList<matiere> listeMatieres) {
        this.listeMatieres = listeMatieres;
    }

    

   

    public ArrayList<certificat> getListeCertificats() {
        return listeCertificats;
    }

    public void setListeCertificats(ArrayList<certificat> listeCertificats) {
        this.listeCertificats = listeCertificats;
    }

    // Méthodes pour gérer les données
    public void ajouterEtudiant(Etudiant etudiant) {
        this.listeEtudiants.add(etudiant);
    }

    public void ajouterProfesseur(Enseignant professeur) {
        this.listeProfesseurs.add(professeur);
    }

    public void ajouterMatiere(matiere matiere) {
        this.listeMatieres.add(matiere);
    }

   

    public void ajouterCertificat(certificat certificat) {
        this.listeCertificats.add(certificat);
    }

     public void afficherProfsParMatiere(int idMatiere) {
    // Vérifier si la liste des professeurs est vide
    if (this.listeProfesseurs.isEmpty()) {
        System.out.println("Aucun professeur enregistré.");
        return;
    }

    boolean profTrouve = false;

    // Parcourir la liste des professeurs
    for (Enseignant enseignant : this.listeProfesseurs) {
        // Parcourir la liste des matières de chaque professeur
        for (matiere mat : enseignant.getlistematiere()) {
            if (mat.getIdMatiere() == idMatiere) { // Comparer les IDs des matières
                System.out.println("Professeur : " + enseignant.getNom());
                profTrouve = true;
                break; // Passer au prochain enseignant
            }
        }
    }

    if (!profTrouve) {
        System.out.println("Aucun professeur n'enseigne cette matière.");
    }
}
public void afficherEtudiantsAvecAbsences(int n) {
        ArrayList<Absence> s = new ArrayList <Absence>();
    // Vérifier si la liste des étudiants est vide
    if (this.listeEtudiants.isEmpty()) {
        System.out.println("Aucun étudiant enregistré.");
        return;
    }
     

    boolean etudiantTrouve = false;

    // Parcourir la liste des étudiants
    for (Etudiant etudiant : this.listeEtudiants) {
        s= etudiant.getabsences();
        
        
        if (s.size() > n) {
            System.out.println("Nom : " + etudiant.getNom() + ", Prénom : " + etudiant.getPrenom());
            etudiantTrouve = true;
        }
    }

    if (!etudiantTrouve) {
        System.out.println("Aucun étudiant n'a plus de " + n + " absences.");
    }
}
}