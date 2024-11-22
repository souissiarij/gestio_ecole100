/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.emploi;

import java.util.ArrayList;

public class EmploiDuTemps {
    private String id; // Identifiant unique de l'emploi du temps
    private String niveauScolaire; // Niveau scolaire associé à l'emploi du temps
    private ArrayList<Creneau> listeCreneaux; // Liste des créneaux horaires

    // Constructeur
    public EmploiDuTemps(String id, String niveauScolaire) {
        this.id = id;
        this.niveauScolaire = niveauScolaire;
        this.listeCreneaux = new ArrayList<>(); // Initialisation de la liste des créneaux
    }

    // Getters et setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNiveauScolaire() {
        return niveauScolaire;
    }

    public void setNiveauScolaire(String niveauScolaire) {
        this.niveauScolaire = niveauScolaire;
    }

    public ArrayList<Creneau> getListeCreneaux() {
        return listeCreneaux;
    }

    // Méthodes pour gérer les créneaux
    public void ajouterCreneau(Creneau creneau) {
        listeCreneaux.add(creneau);
    }

    public void supprimerCreneau(Creneau creneau) {
        listeCreneaux.remove(creneau);
    }

    public void afficherEmploiDuTemps() {
        System.out.println("Emploi du temps pour le niveau : " + niveauScolaire);
        for (Creneau creneau : listeCreneaux) {
            System.out.println(creneau);
        }
    }

    @Override
    public String toString() {
        return "EmploiDuTemps {" +
                "id='" + id + '\'' +
                ", niveauScolaire='" + niveauScolaire + '\'' +
                ", listeCreneaux=" + listeCreneaux +
                '}';
    }
}
