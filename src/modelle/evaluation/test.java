/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.evaluation;
import java.util.Date;
import modelle.matiere.cours; 
import modelle.matiere.matiere;

/**
 *
 * @author souis
 */
public class test extends evaluation {
    private String typeTest;
    private int niveauDifficulte;
    private String coursDeTest;

    // Constructeur
    public test(int idEvaluation, Date dateEvaluation,String matiereEvaluation, String typeTest, int niveauDifficulte, String coursDeTest) {
        super(idEvaluation, dateEvaluation, matiereEvaluation);
        this.typeTest = typeTest;
        this.niveauDifficulte = niveauDifficulte;
        this.coursDeTest = coursDeTest;
    }

    // Getters et Setters
    public String getTypeTest() {
        return typeTest;
    }

    public void setTypeTest(String typeTest) {
        this.typeTest = typeTest;
    }

    public int getNiveauDifficulte() {
        return niveauDifficulte;
    }

    public void setNiveauDifficulte(int niveauDifficulte) {
        this.niveauDifficulte = niveauDifficulte;
    }

    public String getCoursDeTest() {
        return coursDeTest;
    }

    public void setCoursDeTest(String coursDeTest) {
        this.coursDeTest = coursDeTest;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Type de test: " + typeTest + "\n" +
               "Niveau de difficulté: " + niveauDifficulte + "\n" +
               "Cours de test: " + coursDeTest;
    }
    @Override 
     public void afficherTypeEvaluation() {
        System.out.println("Type d'évaluation : Test");
    }

}
