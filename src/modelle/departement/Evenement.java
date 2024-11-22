/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.departement;

/**
 *
 * @author souis
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import modelle.personnes.Personne;

//import modelle.com.mycompany.gestion.ecole.Date;
public class Evenement {
    private String idEvenement;
    private String titre;
    private Date date;
    private String description;
    private Personne organisateur;
    private ArrayList<Personne> participants;

    // Constructeur
    public Evenement(String idEvenement, String titre, Date date, String description, Personne organisateur) {
        this.idEvenement = idEvenement;
        this.titre = titre;
        this.date = date;
        this.description = description;
        this.organisateur = organisateur;
        this.participants = new ArrayList<>();
    }

    // Getters et setters
    public String getTitre() {
        return titre;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Personne getOrganisateur() {
        return organisateur;
    }

    public ArrayList<Personne> getParticipants() {
        return participants;
    }

    public void ajouterParticipant(Personne participant) {
        participants.add(participant);
    }

    public void supprimerParticipant(Personne participant) {
        participants.remove(participant);
    }

    public void afficherDetails() {
        System.out.println("Ã‰vÃ©nement: " + titre + "\nDate: " + date + "\nDescription: " + description);
        System.out.println("Organisateur: " + organisateur.getNom() + " " + organisateur.getPrenom());
        System.out.println("Participants:");
        for (Personne participant : participants) {
            System.out.println("- " + participant.getNom() + " " + participant.getPrenom());
        }
    }}

