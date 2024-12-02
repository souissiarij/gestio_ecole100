package modelle.departement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelle.personnes.Etudiant;

import java.util.ArrayList;
public class Cantine {
     private String id;
    private String nomm;
    private String prenom;
    private String email;
        private String niveauEtudes;

    private String plat ; 

    public Cantine(String id, String nomm, String prenom, String email, String niveauEtudes, String plat) {
        this.id = id;
        this.nomm = nomm;
        this.prenom = prenom;
        this.email = email;
        this.niveauEtudes = niveauEtudes;
        this.plat = plat;
    }

    public String getId() {
        return id;
    }

    public String getNomm() {
        return nomm;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getNiveauEtudes() {
        return niveauEtudes;
    }

    public String getPlat() {
        return plat;
    }
    

  


    


    /*
        public void associerEtudiantCantine(Etudiant etudiant) {
        if (etudiant != null) {
            if (!etudiantsInscrits.contains(etudiant)) {
                etudiantsInscrits.add(etudiant);
                System.out.println("Étudiant " + etudiant.getNom() + " associé à la cantine " + this.getNom());
            } else {
                System.out.println("L'étudiant " + etudiant.getNom() + " est déjà inscrit à cette cantine.");
            }
        } else {
            System.out.println("Étudiant invalide, l'association a échoué.");
        }
    }
*/
    public String getNom() {
        return nomm;
    }

}