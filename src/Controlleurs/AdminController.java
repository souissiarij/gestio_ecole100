/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlleurs;


import modelle.personnes.administrateur;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class AdminController {
     
   
    administrateur administrateurprincipal = administrateur.getInstance();

    @FXML
  private void ouvrirEtudiant(ActionEvent event) {
    try {
        // Charger le fichier FXML de Matieregest
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Etudiant.fxml"));
        Parent matiereView = loader.load();
        
        // Obtenir la scène actuelle
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage stage = (Stage) currentScene.getWindow();
        
        // Mettre à jour la scène avec la nouvelle vue
        stage.setScene(new Scene(matiereView));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        afficherMessage("Erreur : Impossible de charger l'interface Matieregest.");
    }
}

    @FXML
    private void ouvrirInterfaceEnseignant(ActionEvent event) {
  try {
        // Charger le fichier FXML de Matieregest
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/enseignant.fxml"));
        Parent matiereView = loader.load();
        
        // Obtenir la scène actuelle
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage stage = (Stage) currentScene.getWindow();
        
        // Mettre à jour la scène avec la nouvelle vue
        stage.setScene(new Scene(matiereView));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        afficherMessage("Erreur : Impossible de charger l'interface Matieregest.");
    }    }

   @FXML
private void handleMatiere(ActionEvent event) {
    try {
        // Charger le fichier FXML de Matieregest
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Matieregest.fxml"));
        Parent matiereView = loader.load();
        
        // Obtenir la scène actuelle
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage stage = (Stage) currentScene.getWindow();
        
        // Mettre à jour la scène avec la nouvelle vue
        stage.setScene(new Scene(matiereView));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        afficherMessage("Erreur : Impossible de charger l'interface Matieregest.");
    }
}



    @FXML
    private void handleEvaluation(ActionEvent event) {
       try {
        // Charger le fichier FXML de Matieregest
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Evaluation.fxml"));
        Parent matiereView = loader.load();
        
        // Obtenir la scène actuelle
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage stage = (Stage) currentScene.getWindow();
        
        // Mettre à jour la scène avec la nouvelle vue
        stage.setScene(new Scene(matiereView));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        afficherMessage("Erreur : Impossible de charger l'interface Evaluation.");
    }     
    }

    @FXML
    private void handleEmploi(ActionEvent event) {
     try {
        // Charger le fichier FXML de Matieregest
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Emploi.fxml"));
        Parent matiereView = loader.load();
        
        // Obtenir la scène actuelle
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage stage = (Stage) currentScene.getWindow();
        
        // Mettre à jour la scène avec la nouvelle vue
        stage.setScene(new Scene(matiereView));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        afficherMessage("Erreur : Impossible de charger l'interface Emploi.");
    }    }

    @FXML
    private void handleClub(ActionEvent event) {
             try {
        // Charger le fichier FXML de Matieregest
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/club.fxml"));
        Parent matiereView = loader.load();
        
        // Obtenir la scène actuelle
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage stage = (Stage) currentScene.getWindow();
        
        // Mettre à jour la scène avec la nouvelle vue
        stage.setScene(new Scene(matiereView));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        afficherMessage("Erreur : Impossible de charger l'interface club.");
    }  
    }

    private void afficherMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez cliqué sur : " + message);
        alert.showAndWait();
    }
}
