/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlleurs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author souis
 */
public class EvaluationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
    public void handlexamen (ActionEvent event){
    try {
        // Charger le fichier FXML de Matieregest
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Examen.fxml"));
        Parent matiereView = loader.load();
        
        // Obtenir la scène actuelle
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage stage = (Stage) currentScene.getWindow();
        
        // Mettre à jour la scène avec la nouvelle vue
        stage.setScene(new Scene(matiereView));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        afficherMessage("Erreur : Impossible de charger l'interface examen");}}
    
    
    
    
    
    
    
        @FXML
    public void handltest (ActionEvent event){
    try {
        // Charger le fichier FXML de Matieregest
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Test.fxml"));
        Parent matiereView = loader.load();
        
        // Obtenir la scène actuelle
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage stage = (Stage) currentScene.getWindow();
        
        // Mettre à jour la scène avec la nouvelle vue
        stage.setScene(new Scene(matiereView));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        afficherMessage("Erreur : Impossible de charger l'interface test");}}
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    private void handleRetourMenuPrincipal(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/admin.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu Principal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Pour déboguer en cas d'erreur
        }
    }
    private void afficherMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez cliqué sur : " + message);
        alert.showAndWait();
    }
    
    @FXML
    private void handleCertificat(ActionEvent event) {
         try {
        // Charger le fichier FXML de Matieregest
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Cerificatgest.fxml"));
        Parent matiereView = loader.load();
        
        // Obtenir la scène actuelle
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage stage = (Stage) currentScene.getWindow();
        
        // Mettre à jour la scène avec la nouvelle vue
        stage.setScene(new Scene(matiereView));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        afficherMessage("Erreur : Impossible de charger l'interface Cerificatgestt.");
    }
    }
}
