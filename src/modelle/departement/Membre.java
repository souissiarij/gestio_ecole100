package modelle.departement;

public record Membre(String nom, String prenom) {
    public String afficherNomComplet() {
        return nom + " " + prenom;
    }

  
}
