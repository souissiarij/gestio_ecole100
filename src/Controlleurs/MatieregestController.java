package Controlleurs;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import modelle.matiere.matiere;

public class MatieregestController {

    @FXML
    private TableView<matiere> tableMatiere;
    @FXML
    private TableColumn<matiere, Integer> idMatiereColumn;
    @FXML
    private TableColumn<matiere, String> titreMatiereColumn;
    @FXML
    private TableColumn<matiere, Integer> coursSizeColumn;

    // Liste observable pour les matières
    private ObservableList<matiere> matieresList;

    public MatieregestController() {
        // Exemple d'initialisation de la liste des matières
        matieresList = FXCollections.observableArrayList();
        matieresList.add(new matiere("Informatique"));
        matieresList.add(new matiere("Mathématiques"));
        matieresList.add(new matiere("Physique"));
    }

    @FXML
    private void ajouterMatiere(ActionEvent event) {
        // Charger l'interface d'ajout de matière
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/ajoutermatiere.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajouter une Matière");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            // Une fois la matière ajoutée, afficher la liste mise à jour
            afficherListeMatieres(null); // Rafraîchir la liste des matières
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de l'interface Ajouter Matière : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void afficherListeMatieres(ActionEvent event) {
        // Associer les colonnes aux propriétés des matières
        idMatiereColumn.setCellValueFactory(new PropertyValueFactory<>("idmatiere"));
        titreMatiereColumn.setCellValueFactory(new PropertyValueFactory<>("titre_matiere"));
        

        // Remplir la TableView avec la liste des matières
        tableMatiere.setItems(matieresList);
    }

    @FXML
    private void supprimerMatiere(ActionEvent event) {
        // Implémenter la logique pour supprimer une matière
        System.out.println("Supprimer une matière");
    }

    @FXML
    private void afficherMatiere(ActionEvent event) {
        System.out.println("Afficher une matière");
        // Implémenter la logique pour afficher une matière
    }

    @FXML
    private void modifierMatiere(ActionEvent event) {
        System.out.println("Modifier une matière");
        // Implémenter la logique pour modifier une matière
    }

    @FXML
    private void ajouterProfAMatiere(ActionEvent event) {
        System.out.println("Ajouter un professeur à une matière");
        // Implémenter la logique pour ajouter un professeur à une matière
    }

    @FXML
    private void ajouterCoursAMatiere(ActionEvent event) {
        System.out.println("Ajouter un cours à une matière");
        // Implémenter la logique pour ajouter un cours
    }

    @FXML
    private void afficherMatiereCritere(ActionEvent event) {
        System.out.println("Afficher les matières selon un critère");
        // Implémenter la logique pour afficher les matières selon un critère
    }

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
}
