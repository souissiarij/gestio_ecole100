/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.personnes;

import modelle.matiere.cours;
import java.util.Date;

/**
 *
 * @author souis
 */
public class Absence {
  private String idAbsence ;
    private String motif;
private Date date;
 private cours cours;
 
 
 public Absence(String idAbsence) {
    this.idAbsence = idAbsence;
    this.motif = null; // Initialisation par défaut
    this.date = null;  // Initialisation par défaut
    this.cours = null; // Initialisation par défaut
}

    public Absence(String idAbsence, Date  date, String motif, cours cours) {
        this.idAbsence = idAbsence;
        this.date = date;
        this.cours = cours;
    }

    public Date getDate() {
        return date;
    }

    

    public cours getCours() {
        return cours;
    }

    @Override
    public String toString() {
        return "Absence le " + date + " pour le cours " + cours.getTitreCours() + " - Motif : " + motif;
    }
}

