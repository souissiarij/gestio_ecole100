/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlleurs;

import java.io.IOException;


/**
 * FXML Controller class
 *
 * @author souis
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MatieregestController {

    @FXML
   
private void ajouterMatiere(ActionEvent event) {
    try {
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/ajoutermatiere.fxml"));
        Parent root = loader.load();

        // Obtenir la scène actuelle et la remplacer par la nouvelle interface
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Facultatif : mettre à jour le titre de la fenêtre
        stage.setTitle("Ajouter une Matière");

        // Afficher la nouvelle interface
        stage.show();
    } catch (IOException e) {
        System.err.println("Erreur lors du chargement de l'interface Ajouter Matière : " + e.getMessage());
        e.printStackTrace();
    }}


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
    @FXML
private void handleRetourMenuPrincipal(ActionEvent event) {
    try {
        // Charger le fichier FXML du menu principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/admin.fxml"));
        Parent root = loader.load();

        // Obtenir la scène actuelle et définir le nouveau contenu
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));

        // Optionnel : définir le titre de la fenêtre
        stage.setTitle("Menu Principal");

        // Afficher la scène
        stage.show();
    } catch (IOException e) {
        e.printStackTrace(); // Pour déboguer en cas d'erreur
    }
}

    
}

