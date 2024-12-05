/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.matiere;
import modelle.personnes.Enseignant;


/**
 *
 * @author souis
 */

    import java.util.ArrayList;
import java.util.List;
public class matiere {
    private static int compteurId = 0;  // Compteur pour générer les IDs
    private int idMatiere;              // ID unique pour chaque matière
    private String titreMatiere;        // Titre de la matière
    private List<cours> cours;          // Liste des cours pour cette matière

    // Constructeur
    public matiere(String titreMatiere) {
        this.idMatiere = ++compteurId;       // ID auto-incrémenté
        this.titreMatiere = titreMatiere;
       
        this.cours = new ArrayList<>();
    }
   public matiere()
   {this.idMatiere = ++compteurId; 
   this.titreMatiere="";
     
   this.cours= new ArrayList<>();}
    // Getters et Setters
    public int getIdMatiere() {
        return idMatiere;
    }

    /**
     *
     * @return
     */
    public List<cours> getcours()
    {return cours;}
    public int getCoursSize()
    { return cours.size();
    }
        
    public String getTitreMatiere() {
        return titreMatiere;
    }

    public void setTitreMatiere(String titreMatiere) {
        this.titreMatiere = titreMatiere;
    }

   

    public List<cours> getCours() {
        return cours;
    }

    

    // Méthode pour ajouter un cours à la liste des cours
    public void ajouterCours(cours cours) {
        this.cours.add(cours);
    }

    // Méthode pour appliquer une action sur tous les cours avec une lambda
    public void appliquerActionSurCours(ActionCours action) {
        for (cours c : this.cours) {
            action.appliquer(c); // Appliquer l'action passée en paramètre
        }
    }

    // Exemple d'utilisation interne de lambda
    public void exempleUsage() {
        System.out.println("Affichage des titres de cours :");
        appliquerActionSurCours(c -> System.out.println("Titre du cours : " + c.getTitreCours()));

        System.out.println("\nAjout d'un préfixe 'Module - ' aux titres de cours :");
        appliquerActionSurCours(c -> c.setTitreCours("Module - " + c.getTitreCours()));

        System.out.println("\nCours après modification :");
        appliquerActionSurCours(c -> System.out.println("Titre modifié : " + c.getTitreCours()));
    }

    @Override
    public String toString() {
        return "Matière ID: " + idMatiere + "\n" +
               "Titre de la matière: " + titreMatiere + "\n" +

               "Cours: " + cours;
    }

    public void setListeCours(ArrayList<cours> listeCours) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}