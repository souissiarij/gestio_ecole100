/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package gestioEcole100;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author souis
 */
public class GestioEcole100 extends Application {
    

    @Override
    public void start(Stage primaryStage) {
        try {
            // Charger le fichier FXML de la connexion
            Parent root = FXMLLoader.load(getClass().getResource("/Vues/login.fxml"));
            
            // Créer une scène et appliquer des dimensions à la fenêtre principale
            Scene scene = new Scene(root, 400, 300);
            
            // Configurer la fenêtre principale
            primaryStage.setTitle("Connexion Administrateur");
            primaryStage.setScene(scene);
            primaryStage.show(); // Afficher la fenêtre
        } catch (Exception e) {
            e.printStackTrace(); // Afficher l'erreur en cas de problème
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
