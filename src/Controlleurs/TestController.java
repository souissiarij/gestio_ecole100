package Controlleurs;

import java.awt.Insets;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelle.evaluation.examen;
import modelle.evaluation.test;
import modelle.personnes.administrateur;

// Classe du contrôleur
public class TestController {
    administrateur administrateurprincipal = administrateur.getInstance();

    // Références aux éléments FXML
    @FXML
    private TableView<test> testTable;

    @FXML
    private TableColumn<test, Integer> idEvaluation;

    @FXML
    private TableColumn<test, String> typeColumn;

    @FXML
    private TableColumn<test, Integer> niveauDifficulteColumn;

    @FXML
    private TableColumn<test, String> coursColumn;

    private ObservableList<test> testList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configuration des colonnes du tableau
        idEvaluation.setCellValueFactory(new PropertyValueFactory<>("idEvaluation"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("typeTest"));
        niveauDifficulteColumn.setCellValueFactory(new PropertyValueFactory<>("niveauDifficulte"));
        coursColumn.setCellValueFactory(new PropertyValueFactory<>("coursDeTest"));

        // Charger des données initiales (si nécessaire)
       // loadTestData();
        testTable.setItems(testList);
    }

    // Méthode pour ajouter un test
  @FXML
public void ajouterTest() {
    // Création d'une boîte de dialogue pour l'ajout de test
    Dialog<test> dialog = new Dialog<>();
    dialog.setTitle("Ajouter un Test");
    dialog.setHeaderText("Saisissez les informations du test");

    // Configuration des boutons
    ButtonType ajouterButtonType = new ButtonType("Ajouter", ButtonBar.ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(ajouterButtonType, ButtonType.CANCEL);

    // Création des champs de saisie
    TextField idField = new TextField();
    idField.setPromptText("id de Test ");
    
    TextField typeField = new TextField();
    typeField.setPromptText("Type de Test (ex : QCM)");
    
    TextField niveauField = new TextField();
    niveauField.setPromptText("Niveau de difficulté (1-5)");
    
    TextField coursField = new TextField();
    coursField.setPromptText("Cours associé (ex : Mathématiques)");

    // Organisation des champs dans une grille
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    //grid.setPadding(new Insets(20, 150, 10, 10));
    grid.add(new Label("id du test :"), 0, 0);
    grid.add(idField, 1, 0);
    
    
    
    grid.add(new Label("Type de Test :"), 0, 1);
    grid.add(typeField, 1, 1);
    
    
    
    grid.add(new Label("Niveau de Difficulté :"), 0, 2);
    grid.add(niveauField, 1, 2);
    
    
    
    grid.add(new Label("Cours :"), 0, 3);
    grid.add(coursField, 1, 3);

    dialog.getDialogPane().setContent(grid);

    // Conversion des résultats de la boîte de dialogue
    dialog.setResultConverter(dialogButton -> {
        if (dialogButton == ajouterButtonType) {
            try {
                int id =Integer.parseInt(idField.getText());
                String type = typeField.getText();
                int niveau = Integer.parseInt(niveauField.getText());
                String cours = coursField.getText();
                return new test(id,null,"", type, niveau, cours);
            } catch (NumberFormatException e) {
                // Gérer les erreurs si l'utilisateur entre des données non valides
                showAlert("Erreur", "Veuillez entrer un niveau de difficulté valide (nombre entier).");
                return null;
            }
        }
        return null;
        
    });

    // Affichage de la boîte de dialogue et récupération du résultat
    test newTest = dialog.showAndWait().orElse(null);
   /* if (newTest != null) {
        testList.add(newTest);
        System.out.println("Test ajouté : " + newTest);
    }*/
    Optional<test> result = dialog.showAndWait();
        result.ifPresent(newTeste -> {
            administrateurprincipal.ajouterteste(newTest);
           
        });
}

// Méthode pour afficher une alerte d'erreur
private void showAlert(String title, String content) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}

    // Méthode pour supprimer un test sélectionné
    @FXML
    public void supprimerTest() {
        test selectedTest = testTable.getSelectionModel().getSelectedItem();
        if (selectedTest != null) {
            testList.remove(selectedTest);
            System.out.println("Test supprimé : " + selectedTest);
        } else {
            System.out.println("Aucun test sélectionné.");
        }
    }

    // Méthode pour modifier un test sélectionné
    
@FXML
public void modifierTest(ActionEvent event) {
    // Récupérer le test sélectionné dans le tableau
    test testSelectionne = testTable.getSelectionModel().getSelectedItem();

    if (testSelectionne == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Avertissement");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un test à modifier !");
        alert.showAndWait();
        return;
    }

    // Création d'une boîte de dialogue pour la modification
    Dialog<test> dialog = new Dialog<>();
    dialog.setTitle("Modifier un Test");
    dialog.setHeaderText("Modifiez les détails du test");

    // Champs d'entrée avec valeurs existantes
    TextField idField = new TextField(String.valueOf(testSelectionne.getIdEvaluation()));
    idField.setDisable(true); // ID non modifiable

    TextField typeField = new TextField(testSelectionne.getTypeTest() != null ? testSelectionne.getTypeTest() : "");
    TextField niveauField = new TextField(String.valueOf(testSelectionne.getNiveauDifficulte()));
    TextField coursField = new TextField(testSelectionne.getCoursDeTest() != null ? testSelectionne.getCoursDeTest() : "");

    // Ajouter les champs au dialog
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.add(new Label("ID:"), 0, 0);
    grid.add(idField, 1, 0);
    grid.add(new Label("Type de Test:"), 0, 1);
    grid.add(typeField, 1, 1);
    grid.add(new Label("Niveau de Difficulté:"), 0, 2);
    grid.add(niveauField, 1, 2);
    grid.add(new Label("Cours:"), 0, 3);
    grid.add(coursField, 1, 3);

    dialog.getDialogPane().setContent(grid);
    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

    // Convertir les résultats du dialogue
    dialog.setResultConverter(buttonType -> {
        if (buttonType == ButtonType.OK) {
            try {
                String type = typeField.getText();
                int niveau = Integer.parseInt(niveauField.getText());
                String cours = coursField.getText();

                // Mise à jour du test sélectionné
                testSelectionne.setTypeTest(type);
                testSelectionne.setNiveauDifficulte(niveau);
                testSelectionne.setCoursDeTest(cours);

                return testSelectionne;
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez entrer des informations valides.");
                alert.showAndWait();
                return null;
            }
        }
        return null;
    });

    // Afficher la boîte de dialogue et appliquer les modifications
    Optional<test> result = dialog.showAndWait();
    result.ifPresent(updatedTest -> {
        testTable.refresh(); // Rafraîchir la table pour afficher les nouvelles valeurs
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("Test modifié avec succès !");
        alert.showAndWait();
    });
}

    // Méthode pour afficher la liste des tests
    @FXML
    public void afficherListeTest() {
        testTable.setVisible(true);
        /*System.out.println("Liste des tests affichée.");*/
         testList = FXCollections.observableArrayList(administrateurprincipal.getlistetest());
         testTable.setItems(testList);
    }
    // Charger des données initiales dans la liste des tests
    /*private void loadTestData() {
        List<Test> initialTests = new ArrayList<>();
        initialTests.add(new Test(1, "QCM", 2, "Physique"));
        initialTests.add(new Test(2, "Essai", 4, "Chimie"));
        initialTests.add(new Test(3, "QCM", 3, "Informatique"));
        testList.addAll(initialTests);*/
   
    
    
    
    
    
    
    public void handleRetourMenuevaluhation(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/evaluation.fxml"));
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

