package Controlleurs;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelle.matiere.*;
import modelle.personnes.Enseignant;

public class AjoutermatierecoursController {

    private matiere matiereCourante;

    @FXML private ComboBox<String> typeCoursComboBox;
    @FXML private TextField coursTitreField;
    @FXML private TextField enseignantNomField;
    @FXML private TextField urlVideoField;
    @FXML private TextField dureeVideoField;
    @FXML private TextField tailleVideoField;
    @FXML private TextField formatDocumentField;
    @FXML private TextField pagesDocumentField;
    @FXML private TextField tailleDocumentField;

    @FXML private HBox videoSection;
    @FXML private HBox documentSection;

    public void setMatiere(matiere matiere) {
        this.matiereCourante = matiere;
    }

    @FXML
    public void initialize() {
        ObservableList<String> types = FXCollections.observableArrayList("Vidéo", "Document");
        typeCoursComboBox.setItems(types);

        videoSection.setVisible(false);
        documentSection.setVisible(false);

        typeCoursComboBox.setOnAction(this::handleTypeCoursChange);
    }

    private void handleTypeCoursChange(ActionEvent event) {
        String typeCours = typeCoursComboBox.getValue();
        if ("Vidéo".equals(typeCours)) {
            videoSection.setVisible(true);
            documentSection.setVisible(false);
        } else if ("Document".equals(typeCours)) {
            videoSection.setVisible(false);
            documentSection.setVisible(true);
        }
    }

    @FXML
    private void ajouterCours(ActionEvent event) {
        String typeCours = typeCoursComboBox.getValue();
        String titreCours = coursTitreField.getText();
        String nomEnseignant = enseignantNomField.getText();

        if (typeCours == null || titreCours.isEmpty() || nomEnseignant.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs obligatoires !");
            alert.showAndWait();
            return;
        }

        try {
            Enseignant enseignant = new Enseignant("2", nomEnseignant, "2", "2", "2");
            cours cours;

            if ("Vidéo".equals(typeCours)) {
                String url = urlVideoField.getText();
                double duree = Double.parseDouble(dureeVideoField.getText());
                double taille = Double.parseDouble(tailleVideoField.getText());
                cours = new video(titreCours, enseignant, url, duree, taille);
            } else {
                String format = formatDocumentField.getText();
                int nbPages = Integer.parseInt(pagesDocumentField.getText());
                long taille = Long.parseLong(tailleDocumentField.getText());
                cours = new document(titreCours, enseignant, format, nbPages, taille);
            }

            matiereCourante.ajouterCours(cours);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Cours ajouté avec succès !");
            alert.showAndWait();

            ((Stage) typeCoursComboBox.getScene().getWindow()).close(); // Fermer la fenêtre
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrer des valeurs valides pour les champs numériques !");
            alert.showAndWait();
        }
    }
}
