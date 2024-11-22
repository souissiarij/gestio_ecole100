package modelle.departement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import modelle.personnes.Personne;
import modelle.personnes.Etudiant;

/**
 *
 * @author souis
 */
import java.util.ArrayList;

public class Club {
    private String idClub;
    private String nomClub;
    private Personne responsableClub;
    private ArrayList<Etudiant> membres;
    private ArrayList<Personne> bureau;

    // Constructeur
    public Club(String idClub, String nomClub, Personne responsableClub) {
        this.idClub = idClub;
        this.nomClub = nomClub;
        this.responsableClub = responsableClub;
        this.membres = new ArrayList<>();
        this.bureau = new ArrayList<>();
    }

    // Getters et setters
    public String getNomClub() {
        return nomClub;
    }

    public Personne getResponsableClub() {
        return responsableClub;
    }

    public ArrayList<Etudiant> getMembres() {
        return membres;
    }

    public ArrayList<Personne> getBureau() {
        return bureau;
    }

    public void ajouterMembre(Etudiant etudiant) {
        membres.add(etudiant);
    }

    public void supprimerMembre(Etudiant etudiant) {
        membres.remove(etudiant);
    }

    public void ajouterBureau(Personne membreBureau) {
        bureau.add(membreBureau);
    }

    public void supprimerBureau(Personne membreBureau) {
        bureau.remove(membreBureau);
    }

    public void afficherDetailsClub() {
        System.out.println("Club: " + nomClub + "\nResponsable: " + responsableClub.getNom() + " " + responsableClub.getPrenom());
        System.out.println("Membres:");
        for (Etudiant membre : membres) {
            System.out.println("- " + membre.getNom() + " " + membre.getPrenom());
        }
        System.out.println("Bureau:");
        for (Personne membreBureau : bureau) {
            System.out.println("- " + membreBureau.getNom() + " " + membreBureau.getPrenom());
        }
    }
}
