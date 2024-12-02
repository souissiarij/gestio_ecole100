package Controlleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modelle.matiere.matiere;
import modelle.personnes.Enseignant;

import java.util.ArrayList;

public class AjouterMatiereController {

    @FXML
    private TextField titreMatiereField; // Champ pour le titre de la matière
    @FXML
    private TextField enseignantNomField; // Champ pour le nom de l'enseignant
    @FXML
    private TextField enseignantSpecialiteField; // Champ pour la spécialité de l'enseignant
    @FXML
    private TextField coursTitreField; // Champ pour le titre du cours

    private matiere matiereEnCours; // Objet temporaire pour la matière en cours d'ajout
    private ArrayList<Enseignant> enseignants = new ArrayList<>();
    private ArrayList<String> cours = new ArrayList<>();

    @FXML
    public void initialize() {
        matiereEnCours = new matiere(""); // Initialiser avec un titre temporaire
    }

    @FXML
    private void ajouterEnseignant(ActionEvent event) {
        String nom = enseignantNomField.getText();
        String specialite = enseignantSpecialiteField.getText();

        // Vérification que les champs ne sont pas vides
        if (!nom.isEmpty() && !specialite.isEmpty()) {
            Enseignant enseignant = new Enseignant("E" + enseignants.size(), nom, "", "", specialite);
            enseignants.add(enseignant);
            matiereEnCours.ajouterEnseignant(enseignant);

            System.out.println("Enseignant ajouté : " + enseignant);
        } else {
            System.err.println("Veuillez remplir tous les champs pour l'enseignant !");
        }
    }

    @FXML
    private void ajouterCours(ActionEvent event) {
        String titreCours = coursTitreField.getText();

        if (!titreCours.isEmpty()) {
            cours.add(titreCours); // Ajout du cours
            System.out.println("Cours ajouté : " + titreCours);
        } else {
            System.err.println("Veuillez entrer un titre pour le cours !");
        }
    }

    @FXML
    private void enregistrerMatiere(ActionEvent event) {
        String titre = titreMatiereField.getText();

        if (!titre.isEmpty() && !enseignants.isEmpty() && !cours.isEmpty()) {
            matiereEnCours.setTitreMatiere(titre);
            System.out.println("Matière enregistrée : " + matiereEnCours);

            // Logique d'enregistrement de la matière (en base de données ou autre)
        } else {
            System.err.println("Veuillez remplir tous les champs avant d'enregistrer !");
        }
    }
}
