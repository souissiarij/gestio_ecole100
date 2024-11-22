/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.departement;
import modelle.personnes.Etudiant ;
import java.util.ArrayList ;

/**
 *
 * @author user
 */
public class Cantine {
     private String idCantine;
    private String nom;
    private ArrayList<String> menu; // Liste des plats disponibles
    private ArrayList<Etudiant> listeEtudiantsInscrits;

    // Constructeur
    public Cantine(String idCantine, String nom) {
        this.idCantine = idCantine;
        this.nom = nom;
        this.menu = new ArrayList<>();
        this.listeEtudiantsInscrits = new ArrayList<>();
    }

    // Méthodes
    public void ajouterPlat(String plat) {
        menu.add(plat);
    }

    public void retirerPlat(String plat) {
        menu.remove(plat);
    }

    public void inscrireEtudiant(Etudiant etudiant) {
        listeEtudiantsInscrits.add(etudiant);
    }

    public void desinscrireEtudiant(Etudiant etudiant) {
        listeEtudiantsInscrits.remove(etudiant);
    }

    public void afficherMenu() {
        System.out.println("Menu de la cantine " + nom + " : " + menu);
    }

    public void afficherEtudiantsInscrits() {
        System.out.println("Étudiants inscrits à la cantine : ");
        for (Etudiant e : listeEtudiantsInscrits) {
            System.out.println(e.getNom() + " " + e.getPrenom());
        }
    }

    // toString
    @Override
    public String toString() {
        return "Cantine {" +
                "idCantine='" + idCantine + '\'' +
                ", nom='" + nom + '\'' +
                ", menu=" + menu +
                ", listeEtudiantsInscrits=" + listeEtudiantsInscrits +
                '}';
    }
}
