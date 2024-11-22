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
public class video extends cours {
    private String urlVideo;
    private double dureeVideo;
    private double taille;

    // Constructeur
    public video(String titreCours, Enseignant enseignant, String urlVideo, double dureeVideo, double taille) {
        super(titreCours, enseignant);
        this.urlVideo = urlVideo;
        this.dureeVideo = dureeVideo;
        this.taille = taille;
    }

    // Getters et Setters
    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public double getDureeVideo() {
        return dureeVideo;
    }

    public void setDureeVideo(double dureeVideo) {
        this.dureeVideo = dureeVideo;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "URL de la vidéo: " + urlVideo + "\n" +
               "Durée de la vidéo: " + dureeVideo + " minutes\n" +
               "Taille de la vidéo: " + taille + " MB";
    }
}