/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.personnes;
import modelle.matiere.matiere;
import modelle.matiere.cours;
import modelle.matiere.certificat;
import modelle.personnes.Absence;
import modelle.evaluation.EtatEtudiant;

/**
 *
 * @author souis
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import modelle.departement.Cantine;
import modelle.Bibliotheque.Bibliotheque;
import modelle.evaluation.examen;
import modelle.evaluation.test;

public class administrateur {
     private static administrateur instance; // Instance unique

    private ArrayList<Etudiant> listeEtudiants;
    private ArrayList<Enseignant> listeProfesseurs;
    private ArrayList<examen> ListeExamen;
    private ArrayList<test> Listeteste;
    private ArrayList<matiere> listeMatieres;
    private Map <Etudiant, EtatEtudiant > resultatetudiants ;
 private ArrayList<Cantine> listeCan;
        private ArrayList<Bibliotheque> listeb;
    private ArrayList<certificat> listeCertificats;

    // Constructeur
    public administrateur() {
        this.listeEtudiants = new ArrayList<>();
        this.listeProfesseurs = new ArrayList<>();
        this.listeMatieres = new ArrayList<>();
        this.resultatetudiants = new HashMap <>();
         this.ListeExamen=new ArrayList<>();
         this.Listeteste= new ArrayList<>();
        this.listeCertificats = new ArrayList<>();
         this.listeCan = new ArrayList<>();
              this.listeb = new ArrayList<>();
    }
// Méthode pour obtenir l'instance unique
    public static administrateur getInstance() {
        if (instance == null) {
            instance = new administrateur();
        }
        return instance;
    }
    // Getters et Setters
    public ArrayList<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }
     public  ArrayList<examen> getListExamen ()
     {return ListeExamen;}
    public void setListeEtudiants(ArrayList<Etudiant> listeEtudiants) {
        this.listeEtudiants = listeEtudiants;
    }

    public ArrayList<Enseignant> getListeProfesseurs() {
        return listeProfesseurs;
    }
public ArrayList<test> getlistetest()
{ return Listeteste;}
public void ajouterteste(test teste)
{this.Listeteste.add(teste);}
    public void setListeProfesseurs(ArrayList<Enseignant> listeProfesseurs) {
        this.listeProfesseurs = listeProfesseurs;
    }

    public ArrayList<matiere> getListeMatieres() {
        return listeMatieres;
    }

    public void setListeMatieres(ArrayList<matiere> listeMatieres) {
        this.listeMatieres = listeMatieres;
    }
   
    public ArrayList<certificat> getListeCertificats() {
        return listeCertificats;
    }

    public void setListeCertificats(ArrayList<certificat> listeCertificats) {
        this.listeCertificats = listeCertificats;
    }

    // Méthodes pour gérer les données
    public void ajouterEtudiant(Etudiant etudiant) {
        this.listeEtudiants.add(etudiant);
    }

    public void ajouterProfesseur(Enseignant professeur) {
        this.listeProfesseurs.add(professeur);
    }

    public void ajouterMatiere(matiere matiere) {
        this.listeMatieres.add(matiere);
    }

   

    public void ajouterCertificat(certificat certificat) {
        this.listeCertificats.add(certificat);
    }
       public void mettreAJourMatiere(matiere matiereToModify) {
        // Chercher la matière dans la liste
        for (int i = 0; i < listeMatieres.size(); i++) {
            if (listeMatieres.get(i).getIdMatiere() == matiereToModify.getIdMatiere()) {
                // Remplacer l'ancienne matière par la nouvelle (modifiée)
                listeMatieres.set(i, matiereToModify);
                System.out.println("Matière mise à jour : " + matiereToModify.getTitreMatiere());
                return;
            }
        }
        // Si la matière n'a pas été trouvée
        System.out.println("Matière non trouvée pour mise à jour.");
    }

     public void afficherProfsParMatiere(int idMatiere) {
        try {
            // Vérifier si la liste des professeurs est vide
            if (this.listeProfesseurs.isEmpty()) {
                throw new MatiereNonTrouveeException("La liste des professeurs est vide. Impossible de chercher des matières.");
            }

            boolean profTrouve = false;

            // Parcourir la liste des professeurs
            for (Enseignant enseignant : this.listeProfesseurs) {
                // Parcourir la liste des matières de chaque professeur
                for (matiere mat : enseignant.getlistematiere()) {
                    if (mat.getIdMatiere() == idMatiere) { // Comparer les IDs des matières
                        System.out.println("Professeur : " + enseignant.getNom());
                        profTrouve = true;
                        break; // Passer au prochain enseignant
                    }
                }
            }

            // Si aucun professeur n'enseigne cette matière, lever une exception
            if (!profTrouve) {
                throw new MatiereNonTrouveeException("Aucun professeur n'enseigne la matière avec l'ID " + idMatiere + ".");
            }
        } catch (MatiereNonTrouveeException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

public void afficherEtudiantsAvecAbsences(int n) {
        ArrayList<Absence> s = new ArrayList <Absence>();
    // Vérifier si la liste des étudiants est vide
    if (this.listeEtudiants.isEmpty()) {
        System.out.println("Aucun étudiant enregistré.");
        return;
    }
     

    boolean etudiantTrouve = false;

    // Parcourir la liste des étudiants
    for (Etudiant etudiant : this.listeEtudiants) {
        s= etudiant.getabsences();
       
       
        if (s.size() > n) {
            System.out.println("Nom : " + etudiant.getNom() + ", Prénom : " + etudiant.getPrenom());
            etudiantTrouve = true;
        }
    }

    if (!etudiantTrouve) {
        System.out.println("Aucun étudiant n'a plus de " + n + " absences.");
    }
}
/*public void afficherMatieresAvecPlusDeNProfs(int n) {
    // Vérifier si la liste des matières est vide
    if (this.listeMatieres.isEmpty()) {
        System.out.println("Aucune matière enregistrée.");
        return;
    }

    boolean matiereTrouvee = false;

    // Parcourir la liste des matières
    for (matiere mat : this.listeMatieres) {
        // Vérifier le nombre de professeurs associés à la matière
        if (mat.getEnseignants().size() > n) {
            System.out.println("Matière : " + mat.getTitreMatiere() + " (Professeurs : " + mat.getEnseignants().size() + ")");
            matiereTrouvee = true;
        }
    }

    if (!matiereTrouvee) {
        System.out.println("Aucune matière n'est enseignée par plus de " + n + " professeurs.");
    }
}*/
public ArrayList<certificat> getListeCertificatsTriee() {
    // Créer une copie de la liste pour éviter de modifier l'originale
    ArrayList<certificat> listeTriee = new ArrayList<>(this.listeCertificats);

    // Trier la liste par date d'expiration
    Collections.sort(listeTriee, new Comparator<certificat>() {
        @Override
        public int compare(certificat c1, certificat c2) {
            return c1.getDateExpiration().compareTo(c2.getDateExpiration());
        }
    });

    return listeTriee;
}
   public ArrayList<Cantine> getListeCan() {
        return listeCan;
    }

    public ArrayList<Bibliotheque> getListeb() {
        return listeb;
    }
 
   public void associerEtudiantCantine(Cantine c) {
        this.listeCan.add(c);
    }
   
    public void associerEtudiantBibliotheque(Bibliotheque b) {
        this.listeb.add(b);
    }
}
