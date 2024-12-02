package modelle.emploi;

public class Creneau {
    private String jour;
    private String heureDebut;
    private String heureFin;
    private String matiere;
    private String enseignant;

    public Creneau(String jour, String heureDebut, String heureFin, String matiere, String enseignant) {
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.matiere = matiere;
        this.enseignant = enseignant;
    }

    // Getters
    public String getJour() {
        return jour;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public String getMatiere() {
        return matiere;
    }

    public String getEnseignant() {
        return enseignant;
    }
}
