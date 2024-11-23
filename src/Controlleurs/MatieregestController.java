/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlleurs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author souis
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MatieregestController {

    @FXML
    private void ajouterMatiere(ActionEvent event) {
        System.out.println("Ajouter une matière");
        // Implémentez la logique pour ajouter une matière ici
    }

    @FXML
    private void supprimerMatiere(ActionEvent event) {
        System.out.println("Supprimer une matière");
        // Implémentez la logique pour supprimer une matière ici
    }

    @FXML
    private void afficherMatiere(ActionEvent event) {
        System.out.println("Afficher  une matière");
        // Implémentez la logique pour afficher/modifier une matière ici
    }
    @FXML
    private void ModifierMatiere(ActionEvent event) {
        System.out.println("Modifier une matière");
        // Implémentez la logique pour afficher/modifier une matière ici
    }

    @FXML
    private void afficherListeMatieres(ActionEvent event) {
        System.out.println("Afficher la liste des matières");
        // Implémentez la logique pour afficher la liste des matières ici
    }

    @FXML
    private void ajouterProfAMatiere(ActionEvent event) {
        System.out.println("Ajouter un professeur à une matière");
        // Implémentez la logique pour ajouter un professeur à une matière ici
    }

    @FXML
    private void ajouterCoursAMatiere(ActionEvent event) {
        System.out.println("Ajouter un cours à une matière");
        // Implémentez la logique pour ajouter un cours ici
    }

    @FXML
    private void afficherMatiereCritere(ActionEvent event) {
        System.out.println("Afficher les matières selon un critère");
        // Implémentez la logique pour afficher les matières selon un critère ici
    }
}
