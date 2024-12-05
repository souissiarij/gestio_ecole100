/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.evaluation;
import modelle.matiere.matiere;

/**
 *
 * @author souis
 */
import java.util.Date;

public abstract class evaluation {
    protected int idEvaluation;           // Identifiant unique pour chaque évaluation
    protected  Date dateEvaluation;        // Date de l'évaluation
    protected String matiereEvaluation;  // Matière de l'évaluation

    // Constructeur
    public evaluation(int idEvaluation, Date dateEvaluation, String matiereEvaluation) {
        this.idEvaluation = idEvaluation;
        this.dateEvaluation = dateEvaluation;
        this.matiereEvaluation = matiereEvaluation;
    }
    public evaluation ( int idEvaluation , String matiereevaluation )
            
    {this.idEvaluation= idEvaluation ; 
    this.dateEvaluation= null;
    this.matiereEvaluation=matiereevaluation; }

    // Getters et Setters
    public int getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(int idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Date getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(Date dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    public String getMatiereEvaluation() {
        return matiereEvaluation;
    }

    public void setMatiereEvaluation(String matiereEvaluation) {
        this.matiereEvaluation = matiereEvaluation;
    }

    // Méthode toString pour afficher une description de l'évaluation
    @Override
    public String toString() {
        return "ID de l'évaluation: " + idEvaluation + "\n" +
               "Date de l'évaluation: " + dateEvaluation + "\n" +
               "Matière de l'évaluation: " + matiereEvaluation;
    }
    
    // Méthode abstraite (à implémenter dans les classes dérivées)
    public abstract void afficherTypeEvaluation();
}

