package modelle.departement;

import java.util.ArrayList;
import java.util.List;

// Classe abstraite Groupe
public abstract class Groupe {
    protected String nom;
    protected List<Membre> membres;

    // Constructeur
    public Groupe(String nom) {
        this.nom = nom;
        this.membres = new ArrayList<>();
    }

    // Méthode abstraite pour ajouter un membre
    public abstract void ajouterMembre(Membre membre) throws ClubException;

    // Afficher les membres
    public void afficherMembres() {
        System.out.println("Membres du groupe " + nom + " :");
        for (Membre membre : membres) {
            System.out.println("- " + membre.nom() + " " + membre.prenom());
        }
    }
}
