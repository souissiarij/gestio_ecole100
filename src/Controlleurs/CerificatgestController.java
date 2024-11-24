/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlleurs;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelle.matiere.certificat;
import modelle.personnes.administrateur;

public class CerificatgestController {
  administrateur administrateurprincipal = new administrateur();
    @FXML
   

private void ajouterCertificat(ActionEvent event) {
    try {
        // Charger le formulaire de saisie des informations du certificat
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/CertificatForm.fxml"));
        Parent root = loader.load();

        // Récupérer le contrôleur du formulaire pour passer des données si nécessaire
        CertificatFormController controller = loader.getController();

        // Afficher le formulaire dans une nouvelle fenêtre
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Ajouter un certificat");
        stage.showAndWait();

        // Récupérer le certificat créé depuis le formulaire
        certificat nouveauCertificat = controller.getCertificatCree();

        if (nouveauCertificat != null) {
            // Ajouter le certificat à la liste
             // Remplacez par une instance réelle
           administrateurprincipal.ajouterCertificat(nouveauCertificat);

            System.out.println("Certificat ajouté : " + nouveauCertificat);
        }
    } catch (IOException e) {
        System.err.println("Erreur lors du chargement du formulaire : " + e.getMessage());
    }
}



    @FXML
    private void supprimerCertificat(ActionEvent event) {
        System.out.println("Supprimer certificat");
        // Implémentez la logique pour supprimer une matière ici
    }

    @FXML
    private void ModifierCertificat(ActionEvent event) {
        System.out.println("Modifier une certificat");
        // Implémentez la logique pour afficher/modifier une matière ici
    }

  /*  @FXML
    private void afficherListeCertifiact(ActionEvent event) {
      // Supposons que vous avez une instance de l'administrateur
     // Remplacez par une instance réelle

    // Vérifiez si la liste est vide
    if (administrateurprincipal.getListeCertificats().isEmpty()) {
        System.out.println("Aucun certificat n'est disponible.");
        return;
    }

    // Parcourez et affichez les certificats
    System.out.println("Liste des certificats :");
    for (certificat cert : administrateurprincipal.getListeCertificats()) {
        System.out.println(cert);
    }
}
    */

    @FXML
    private void afficherListeCertifiacttriee(ActionEvent event) {
        System.out.println("Afficher la liste des certif triee ");
        // Implémentez la logique pour ajouter un professeur à une matière ici
    }
     @FXML
    private TableView<certificat> certificatTable;

    @FXML
    private TableColumn<certificat, String> idColumn;

    @FXML
    private TableColumn<certificat, String> nomColumn;

    @FXML
    private TableColumn<certificat, String> dateEmissionColumn;

    @FXML
    private TableColumn<certificat, String> dateExpirationColumn;

   

    @FXML
    private void afficherListeCertifiact(ActionEvent event) {
        // Rendre le tableau visible
        certificatTable.setVisible(true);

        // Configurer les colonnes
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idCertificat"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nomCertificat"));
        dateEmissionColumn.setCellValueFactory(new PropertyValueFactory<>("dateEmission"));
        dateExpirationColumn.setCellValueFactory(new PropertyValueFactory<>("dateExpiration"));

        // Charger les données dans la TableView
        ObservableList<certificat> certificats = FXCollections.observableArrayList(administrateurprincipal.getListeCertificats());
        certificatTable.setItems(certificats);
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

    

