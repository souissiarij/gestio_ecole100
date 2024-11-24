package modelle.emploi;
/*
public class EmploiDuTemps {
    private String id;
    private String niveauScolaire;
    private Creneau creneau;

    public EmploiDuTemps(String id, String niveauScolaire) {
        this.id = id;
        this.niveauScolaire = niveauScolaire;
    }

    public void ajouterCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNiveauScolaire() {
        return niveauScolaire;
    }

    public String getJour() {
        return creneau != null ? creneau.getJour() : "";
    }

    public String getHeureDebut() {
        return creneau != null ? creneau.getHeureDebut() : "";
    }

    public String getHeureFin() {
        return creneau != null ? creneau.getHeureFin() : "";
    }

    public String getMatiere() {
        return creneau != null ? creneau.getMatiere() : "";
    }

    public String getEnseignant() {
        return creneau != null ? creneau.getEnseignant() : "";
    }
}
*/
public class EmploiDuTemps {
    private String id;
    private String niveauScolaire;
    private String jour;
    private String heureDebut;
    private String heureFin;
    private String matiere;
    private String enseignant;

    public EmploiDuTemps(String id, String niveauScolaire, String jour, String heureDebut, String heureFin, String matiere, String enseignant) {
        this.id = id;
        this.niveauScolaire = niveauScolaire;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.matiere = matiere;
        this.enseignant = enseignant;
    }

    public String getId() { return id; }
    public String getNiveauScolaire() { return niveauScolaire; }
    public String getJour() { return jour; }
    public String getHeureDebut() { return heureDebut; }
    public String getHeureFin() { return heureFin; }
    public String getMatiere() { return matiere; }
    public String getEnseignant() { return enseignant; }
}
