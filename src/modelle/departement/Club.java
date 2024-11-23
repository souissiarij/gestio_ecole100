package modelle.departement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import modelle.personnes.Personne;
import modelle.personnes.Etudiant;
import modelle.departement.Groupe;
import java.util.function.Consumer;


/**
 *
 * @author souis
 */
import java.util.ArrayList;
record Membre(String nom, String prenom) {}

enum TypeClub {
    SPORTIF, CULTUREL, SCIENTIFIQUE, ARTISTIQUE;
}

public class Club extends Groupe {
    private TypeClub typeClub;

    // Constructeur
    public Club(String nom, TypeClub typeClub) {
        super(nom);
        this.typeClub = typeClub;
    }

    // Implémentation de la méthode abstraite
    @Override
    public void ajouterMembre(Membre membre) throws ClubException {
        if (membres.contains(membre)) {
            throw new ClubException("Ce membre est déjà dans le club !");
        }
        membres.add(membre);
    }

    // Méthode avec une lambda pour appliquer une opération sur les membres
    public void appliquerSurMembres(Consumer<Membre> operation) {
        for (Membre membre : membres) {
            operation.accept(membre);
        }
    }

    // Afficher les détails du club
    public void afficherDetailsClub() {
        System.out.println("Club: " + nom + " (" + typeClub + ")");
        afficherMembres();
    }
    
    public void exempleClub() {
    try {
        Club club = new Club("Astronomie", TypeClub.SCIENTIFIQUE);

        // Ajouter des membres
        club.ajouterMembre(new Membre("Ali", "Ben Ahmed"));
        club.ajouterMembre(new Membre("Leila", "Slimani"));

        // Utiliser une lambda pour afficher les membres
        club.appliquerSurMembres(m -> System.out.println("Bienvenue " + m.nom() + " " + m.prenom() + " !"));

        // Afficher les détails du club
        club.afficherDetailsClub();

    } catch (ClubException e) {
        System.out.println("Erreur : " + e.getMessage());
    }
}

}