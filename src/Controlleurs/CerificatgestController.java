/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlleurs;

import java.io.IOException;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelle.matiere.certificat;
import modelle.personnes.administrateur;

public class CerificatgestController {
  administrateur administrateurprincipal = administrateur.getInstance();
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
         // Afficher une boîte de dialogue pour demander l'ID du certificat à supprimer
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Supprimer un certificat");
    dialog.setHeaderText("Entrez l'identifiant du certificat à supprimer :");
    dialog.setContentText("ID :");

    // Récupérer l'input utilisateur
    Optional<String> result = dialog.showAndWait();
    if (result.isPresent()) {
        String idCertificat = result.get();

        // Rechercher le certificat avec cet ID
        certificat certificatASupprimer = administrateurprincipal
                .getListeCertificats()
                .stream()
                .filter(cert -> cert.getIdCertificat().equals(idCertificat))
                .findFirst()
                .orElse(null);

        if (certificatASupprimer != null) {
            // Supprimer le certificat de la liste
            administrateurprincipal.getListeCertificats().remove(certificatASupprimer);

            // Mettre à jour le tableau
            certificatTable.setItems(FXCollections.observableArrayList(administrateurprincipal.getListeCertificats()));

            // Message de confirmation
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Certificat supprimé avec succès !");
            alert.showAndWait();
        } else {
            // Message d'erreur si l'ID est introuvable
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucun certificat trouvé avec l'ID fourni !");
            alert.showAndWait();
        }
    }
    }

    @FXML
    private void ModifierCertificat(ActionEvent event) {
            // Afficher une boîte de dialogue pour demander l'ID du certificat à modifier
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Modifier un certificat");
    dialog.setHeaderText("Entrez l'identifiant du certificat à modifier :");
    dialog.setContentText("ID :");

    // Récupérer l'input utilisateur
    Optional<String> result = dialog.showAndWait();
    if (result.isPresent()) {
        String idCertificat = result.get();

        // Rechercher le certificat avec cet ID
        certificat certificatAModifier = administrateurprincipal
                .getListeCertificats()
                .stream()
                .filter(cert -> cert.getIdCertificat().equals(idCertificat))
                .findFirst()
                .orElse(null);

        if (certificatAModifier != null) {
            try {
                // Charger le formulaire de modification
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/CertificatForm.fxml"));
                Parent root = loader.load();

                // Récupérer le contrôleur du formulaire
                CertificatFormController controller = loader.getController();

                // Préremplir le formulaire avec les données actuelles
                controller.setCertificat(certificatAModifier);

                // Afficher le formulaire dans une nouvelle fenêtre
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Modifier un certificat");
                stage.showAndWait();

                // Récupérer le certificat modifié depuis le formulaire
                certificat certificatModifie = controller.getCertificatCree();

                if (certificatModifie != null) {
                    // Mettre à jour les informations du certificat dans la liste
                    int index = administrateurprincipal.getListeCertificats().indexOf(certificatAModifier);
                    administrateurprincipal.getListeCertificats().set(index, certificatModifie);

                    // Mettre à jour le tableau
                    certificatTable.setItems(FXCollections.observableArrayList(administrateurprincipal.getListeCertificats()));

                    // Message de confirmation
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Succès");
                    alert.setHeaderText(null);
                    alert.setContentText("Certificat modifié avec succès !");
                    alert.showAndWait();
                }
            } catch (IOException e) {
                System.err.println("Erreur lors du chargement du formulaire : " + e.getMessage());
            }
        } else {
            // Message d'erreur si l'ID est introuvable
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucun certificat trouvé avec l'ID fourni !");
            alert.showAndWait();
        }
    }

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
       // Rendre le tableau visible
        certificatTable.setVisible(true);

        // Configurer les colonnes
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idCertificat"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nomCertificat"));
        dateEmissionColumn.setCellValueFactory(new PropertyValueFactory<>("dateEmission"));
        dateExpirationColumn.setCellValueFactory(new PropertyValueFactory<>("dateExpiration"));

        // Charger les données dans la TableView
        ObservableList<certificat> certificats = FXCollections.observableArrayList(administrateurprincipal.getListeCertificatsTriee());
        certificatTable.setItems(certificats);
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
    @FXML
    private void aller_a_examen (ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/examen.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu Principal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Pour déboguer en cas d'erreur
        }
         
        }
    @FXML
     private void aller_a_test (ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/test.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu Principal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Pour déboguer en cas d'erreur
        }
        }
}

    

