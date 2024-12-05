package Controlleurs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import javafx.beans.property.SimpleStringProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelle.evaluation.examen;
import modelle.matiere.cours;
import modelle.personnes.administrateur;

public class ExamenController {
    // Référence à l'administrateur principal
    administrateur administrateurprincipal = administrateur.getInstance();

    @FXML
    private TableView<examen> certificatTable;

    @FXML
    private TableColumn<examen, Integer> idColumn;

    @FXML
    private TableColumn<examen, String> matiereColumn;

    @FXML
    private TableColumn<examen, Float> coefficientColumn;

    @FXML
    private TableColumn<examen, String> dateEvaluationColumn;

    // Liste observable pour les examens
    private ObservableList<examen> examensList;
@FXML
private void initialize() {
    idColumn.setCellValueFactory(new PropertyValueFactory<>("idEvaluation"));
    matiereColumn.setCellValueFactory(new PropertyValueFactory<>("matiereEvaluation"));

   coefficientColumn.setCellValueFactory(new PropertyValueFactory<>("coefficient"));
   
    dateEvaluationColumn.setCellValueFactory(cellData -> {
        Date date = cellData.getValue().getDateEvaluation();
        return new SimpleStringProperty(new SimpleDateFormat("dd/MM/yyyy").format(date));
    });

    
}

    @FXML
private void afficherListeExamen(ActionEvent event) {
    // Afficher le tableau lorsqu'on clique sur le bouton
    certificatTable.setVisible(true);

    // Charger la liste des examens dans le tableau
    examensList = FXCollections.observableArrayList(administrateurprincipal.getListExamen());

    // Trier les examens par coefficient décroissant
    examensList.sort((ex1, ex2) -> Float.compare(ex2.getCoefficient(), ex1.getCoefficient()));

    // Appliquer les données triées au tableau
    certificatTable.setItems(examensList);
}


    @FXML
    private void ajouterExamen(ActionEvent event) {
        // Afficher une boîte de dialogue pour obtenir les informations de l'examen
        Dialog<examen> dialog = new Dialog<>();
        dialog.setTitle("Ajouter un Examen");
        dialog.setHeaderText("Entrez les détails de l'examen");

        // Champs d'entrée
        TextField idField = new TextField();
        idField.setPromptText("ID");

        TextField matiereField = new TextField();
        matiereField.setPromptText("Matière");

        TextField coefficientField = new TextField();
        coefficientField.setPromptText("Coefficient");

        TextField dateField = new TextField();
        dateField.setPromptText("Date (dd/MM/yyyy)");

        // Ajouter les champs au dialog
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(new Label("ID:"), 0, 0);
        grid.add(idField, 1, 0);
        grid.add(new Label("Matière:"), 0, 1);
        grid.add(matiereField, 1, 1);
        grid.add(new Label("Coefficient:"), 0, 2);
        grid.add(coefficientField, 1, 2);
        grid.add(new Label("Date:"), 0, 3);
        grid.add(dateField, 1, 3);

        dialog.getDialogPane().setContent(grid);

        // Boutons OK/Annuler
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        // Récupérer les données saisies
        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String matiere = matiereField.getText();
                    float coefficient = Float.parseFloat(coefficientField.getText());
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText());

                    // Créer l'examen
                    examen nouvelExamen = new examen(id, date, matiere, coefficient, null);
                    return nouvelExamen;
                } catch (Exception e) {
                    // Afficher une alerte en cas d'erreur
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

        Optional<examen> result = dialog.showAndWait();
        result.ifPresent(nouvelExamen -> {
            administrateurprincipal.getListExamen ().add(nouvelExamen);
           
        });
    }

    @FXML
    private void supprimerExamen(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Supprimer un Examen");
        dialog.setHeaderText("Entrez l'identifiant de l'examen à supprimer :");
        dialog.setContentText("ID :");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            int id = Integer.parseInt(result.get().trim());
            examen examenASupprimer = administrateurprincipal.getListExamen()
                    .stream()
                    .filter(ex -> ex.getIdEvaluation() == id)
                    .findFirst()
                    .orElse(null);

            if (examenASupprimer != null) {
                administrateurprincipal.getListExamen ().remove(examenASupprimer);
                afficherListeExamen(null); // Rafraîchir la liste
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succès");
                alert.setHeaderText(null);
                alert.setContentText("Examen supprimé avec succès !");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Aucun examen trouvé avec cet ID !");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void handleRetourMenuevaluation(ActionEvent event) {
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
    @FXML
private void modifierExamen(ActionEvent event) {
    examen examenSelectionne = certificatTable.getSelectionModel().getSelectedItem();

    if (examenSelectionne == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Avertissement");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un examen à modifier !");
        alert.showAndWait();
        return;
    }

    Dialog<examen> dialog = new Dialog<>();
    dialog.setTitle("Modifier un Examen");
    dialog.setHeaderText("Modifiez les détails de l'examen");

    // Champs d'entrée avec valeurs existantes
    TextField idField = new TextField(String.valueOf(examenSelectionne.getIdEvaluation()));
    idField.setDisable(true); // ID non modifiable

    TextField matiereField = new TextField(examenSelectionne.getMatiereEvaluation() != null ? examenSelectionne.getMatiereEvaluation() : "");
    TextField coefficientField = new TextField(String.valueOf(examenSelectionne.getCoefficient()));
    TextField dateField = new TextField(new SimpleDateFormat("dd/MM/yyyy").format(examenSelectionne.getDateEvaluation()));

    // Ajouter les champs au dialog
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.add(new Label("ID:"), 0, 0);
    grid.add(idField, 1, 0);
    grid.add(new Label("Matière:"), 0, 1);
    grid.add(matiereField, 1, 1);
    grid.add(new Label("Coefficient:"), 0, 2);
    grid.add(coefficientField, 1, 2);
    grid.add(new Label("Date:"), 0, 3);
    grid.add(dateField, 1, 3);

    dialog.getDialogPane().setContent(grid);
    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

    dialog.setResultConverter(buttonType -> {
        if (buttonType == ButtonType.OK) {
            try {
                String matiere = matiereField.getText();
                float coefficient = Float.parseFloat(coefficientField.getText());
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText());

                // Mettre à jour l'examen
                examenSelectionne.setCoefficient((int) coefficient);
                examenSelectionne.setDateEvaluation(date);
                // Si vous avez un objet `matiere`, mettez à jour ici
                return examenSelectionne;
            } catch (Exception e) {
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

    Optional<examen> result = dialog.showAndWait();
    result.ifPresent(updatedExamen -> {
        certificatTable.refresh(); // Rafraîchir la table pour afficher les nouvelles valeurs
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("Examen modifié avec succès !");
        alert.showAndWait();
    });
}

    }

