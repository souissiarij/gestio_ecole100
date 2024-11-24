package modelle.departement;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Club extends Groupe {
    private TypeClub typeClub;

    // Constructeur
    public Club(String nom, TypeClub typeClub) {
        super(nom);
        this.typeClub = typeClub;
    }

    public String getNom() {
        return nom;
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
    System.out.println("Club: " + getNom() + " (" + typeClub + ")");
    for (Membre membre : getMembres()) {
        System.out.println("- " + membre.nom() + " " + membre.prenom());
    }
}


    public TypeClub getTypeClub() {
        return typeClub;
    }
}
