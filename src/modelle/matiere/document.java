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
public class document extends cours {
    private String format;
    private int nbPages;
    private long taille;

    // Constructeur
    public document(String titreCours, Enseignant enseignant, String format, int nbPages, long taille) {
        super(titreCours, enseignant);
        this.format = format;
        this.nbPages = nbPages;
        this.taille = taille;
    }

    // Getters et Setters
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public long getTaille() {
        return taille;
    }

    public void setTaille(long taille) {
        this.taille = taille;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Format du document: " + format + "\n" +
               "Nombre de pages: " + nbPages + "\n" +
               "Taille du document: " + taille + " KB";
    }
    
}
