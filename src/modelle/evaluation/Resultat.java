/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.evaluation;

/**
 *
 * @author souis
 */
import modelle.evaluation.evaluation;
import modelle.evaluation.examen;
import modelle.evaluation.test;
import java.util.*;

public class Resultat {

    
    private List<evaluation> evaluations; // Liste des évaluations
    private double moyenne;               // Moyenne pondérée
    private EtatEtudiant etat;           // État de l'étudiant

    // Constructeur
    public Resultat() {
        this.evaluations = new ArrayList<>();
        this.moyenne = 0.0;
        this.etat = EtatEtudiant.REDOUBLANT;
    }

    // Ajouter une évaluation (examen ou test)
    public void ajouterEvaluation(evaluation eval) {
        evaluations.add(eval);
        calculerMoyenneEtEtat();
    }

    // Calculer la moyenne pondérée et définir l'état de l'étudiant
    private void calculerMoyenneEtEtat() {
        double sommePonderee = 0.0;
        double sommeCoefficients = 0.0;

        for (evaluation eval : evaluations) {
            double coefficient = 0.0;
            if (eval instanceof examen) {
                coefficient = ((examen) eval).getCoefficient(); // Coefficient de l'examen
            } else if (eval instanceof test) {
                coefficient = 0.25; // Coefficient fixe pour un test
            }

            sommePonderee += eval.getIdEvaluation() * coefficient;
            sommeCoefficients += coefficient;
        }

        // Calcul de la moyenne pondérée
        this.moyenne = sommeCoefficients == 0 ? 0 : sommePonderee / sommeCoefficients;

        // Déterminer l'état de l'étudiant
        if (moyenne >= 10) {
            this.etat = EtatEtudiant.ADMIS;
        } else if (moyenne >= 8) {
            this.etat = EtatEtudiant.RATTRAPAGE;
        } else {
            this.etat = EtatEtudiant.REDOUBLANT;
        }
    }

    // Afficher les résultats
    public void afficherResultats() {
        System.out.println("Évaluations :");
        for (evaluation eval : evaluations) {
            System.out.println(eval.toString());
        }
        System.out.println("Moyenne pondérée : " + moyenne);
        System.out.println("État : " + etat);
    }}