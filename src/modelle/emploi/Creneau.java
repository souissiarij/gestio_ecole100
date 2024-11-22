/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.emploi;
import modelle.matiere.cours ;

/**
 *
 * @author user
 */
    public class Creneau {
    private String jour; // Jour de la semaine (exemple : "Lundi")
    private String heureDebut; // Heure de début (format : "HH:mm")
    private String heureFin; // Heure de fin (format : "HH:mm")
    private cours course; // Cours associé au créneau

    // Constructeur
    public Creneau(String jour, String heureDebut, String heureFin, cours course) {
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.course = course;
    }

    // Getters et setters
    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public cours getCours() {
        return course;
    }

    public void setCours(cours cours) {
        this.course = cours;
    }

    @Override
    public String toString() {
        return "Creneau {" +
                "jour='" + jour + '\'' +
                ", heureDebut='" + heureDebut + '\'' +
                ", heureFin='" + heureFin + '\'' +
                ", cours=" + course +
                '}';
    }
}
