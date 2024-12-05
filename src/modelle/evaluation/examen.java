/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.evaluation;
import java.util.ArrayList;
import modelle.matiere.cours;
import modelle.matiere.matiere;
import java.util.Date;

/**
 *
 * @author souis
 */
import java.util.List;

public class examen extends evaluation {
    private float coefficient;
    private List<cours> listeDesChapitres;

    // Constructeur
    public examen(int idEvaluation, Date dateEvaluation, String matiereEvaluation, float coefficient, List<cours> listeDesChapitres) {
        super(idEvaluation, dateEvaluation, matiereEvaluation);
        this.coefficient = coefficient;
        this.listeDesChapitres = listeDesChapitres;
    }


    // Getters et Setters
    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public List<cours> getListeDesChapitres() {
        return listeDesChapitres;
    }

    public void setListeDesChapitres(List<cours> listeDesChapitres) {
        this.listeDesChapitres = listeDesChapitres;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Coefficient: " + coefficient + "\n" +
               "Liste des chapitres: " + listeDesChapitres;
    }
    @Override 
      public void afficherTypeEvaluation() {
        System.out.println("Type d'évaluation : Examen");
    }
}

