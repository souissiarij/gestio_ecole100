package modelle.departement;

import java.util.ArrayList;
import java.util.List;

public abstract class Groupe {
    protected String nom;
    protected List<Membre> membres;

    public Groupe(String nom) {
        this.nom = nom;
        this.membres = new ArrayList<>();
    }

    public List<Membre> getMembres() {
        return membres;
    }

    public String getNom() {
        return nom;
    }

    public void afficherMembres() {
        for (Membre membre : membres) {
            System.out.println("- " + membre.nom() + " " + membre.prenom());
        }
    }

    public abstract void ajouterMembre(Membre membre) throws ClubException;
}
