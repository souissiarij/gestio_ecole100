/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.personnes;
import modelle.matiere.cours;
import modelle.matiere.matiere;
import modelle.matiere.certificat ;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *
 * @author souis
 * 
 */
import java.util.ArrayList;

public class Etudiant extends Personne {
    private String niveauEtudes;
    private ArrayList<cours> listeCoursInscrits;
    private ArrayList<certificat> listeCertificats;
    private ArrayList<Absence> listeAbssences ;
    private String nbabsence ;

    public Etudiant(String id, String nom, String prenom, String email, String niveauEtudes) {
        super(id, nom, prenom, email); // Appel au constructeur de Personne
        this.niveauEtudes = niveauEtudes;
        this.listeCoursInscrits = new ArrayList<>(); // Initialisation des listes
        this.listeCertificats = new ArrayList<>();
        this.listeAbssences=new ArrayList();
    }

    public void setNbabsence(String nbabsence) {
        this.nbabsence = nbabsence;
    }

    public String getNbabsence() {
        return nbabsence;
    }

   
   public Etudiant(String id, String nom, String prenom, String email, String niveauEtudes,String nbabsence) {
        super(id, nom, prenom, email); // Appel au constructeur de Personne
        this.niveauEtudes = niveauEtudes;
        this.listeCoursInscrits = new ArrayList<>(); // Initialisation des listes
        this.listeCertificats = new ArrayList<>();
        this.listeAbssences=new ArrayList();
    }

     public StringProperty nomProperty() {
        return new SimpleStringProperty(getNom());
    }

    public StringProperty prenomProperty() {
        return new SimpleStringProperty(getPrenom());
    }

    public StringProperty emailProperty() {
        return new SimpleStringProperty(getEmail());
    }

    public StringProperty niveauEtudesProperty() {
return new SimpleStringProperty(getNiveauEtudes()) ;   }

    public String getNiveauEtudes() {
        return niveauEtudes;//gg
    }
    public ArrayList<Absence> getabsences(){return listeAbssences;}

    public void inscrireCours(cours c) {
        listeCoursInscrits.add(c);
    }

   /* public void ajouterCertificat(certificat ce) {
        listeCertificats.add(ce);
    }*/
public void ajouterAbsence(Absence a){
    listeAbssences.add(a) ;
}
    public void afficherCoursInscrits() {
        System.out.println("Cours inscrits : " + listeCoursInscrits);
    }

    public void afficherCertificats() {
        System.out.println("Certificats : " + listeCertificats);
    }
    public void afficherAbsences() {
        System.out.println("les Absences : " + listeAbssences);
    }
     @Override
    public String toString() {
        return "Etudiant {" +
                "id='" + getId() + '\'' +
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", niveauEtudes='" + niveauEtudes + '\'' +
                ", listeCoursInscrits=" + listeCoursInscrits +
                ", listeCertificats=" + listeCertificats +
                ", listeAbsences=" + listeAbssences +
                '}';
    }


}

