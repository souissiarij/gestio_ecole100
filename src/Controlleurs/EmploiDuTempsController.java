/*package Controlleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmploiDuTempsController {

    @FXML
    public void ajouterEmploi(ActionEvent event) {
        try {
            // Charger la vue pour ajouter un emploi du temps
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/AjouterEmploi.fxml"));
            Parent ajouterEmploiView = loader.load();
            
            // Obtenir la scène actuelle
            Scene currentScene = ((Node) event.getSource()).getScene();
            Stage stage = (Stage) currentScene.getWindow();
            
            // Mettre à jour la scène avec la nouvelle vue
            stage.setScene(new Scene(ajouterEmploiView));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            afficherMessage("Erreur : Impossible de charger l'ajout de l'emploi du temps.");
        }
    }

   

    private void afficherMessage(String message) {
        System.out.println(message); // Afficher un message dans la console pour le debug
    }
}
*/
package Controlleurs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelle.emploi.EmploiDuTemps ;
public class EmploiDuTempsController {

    @FXML
    private TextField idField;
    @FXML
    private TextField niveauScolaireField;
    @FXML
    private TextField jourField;
    @FXML
    private TextField heureDebutField;
    @FXML
    private TextField heureFinField;
    @FXML
    private TextField matiereField;
    @FXML
    private TextField enseignantField;

    @FXML
    private TableView<EmploiDuTemps> tableView;
    @FXML
    private TableColumn<EmploiDuTemps, String> idColumn;
    @FXML
    private TableColumn<EmploiDuTemps, String> niveauScolaireColumn;
    @FXML
    private TableColumn<EmploiDuTemps, String> jourColumn;
    @FXML
    private TableColumn<EmploiDuTemps, String> heureDebutColumn;
    @FXML
    private TableColumn<EmploiDuTemps, String> heureFinColumn;
    @FXML
    private TableColumn<EmploiDuTemps, String> matiereColumn;
    @FXML
    private TableColumn<EmploiDuTemps, String> enseignantColumn;

    private ObservableList<EmploiDuTemps> emplois = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurer les colonnes pour correspondre aux attributs de l'objet EmploiDuTemps
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        niveauScolaireColumn.setCellValueFactory(new PropertyValueFactory<>("niveauScolaire"));
        jourColumn.setCellValueFactory(new PropertyValueFactory<>("jour"));
        heureDebutColumn.setCellValueFactory(new PropertyValueFactory<>("heureDebut"));
        heureFinColumn.setCellValueFactory(new PropertyValueFactory<>("heureFin"));
        matiereColumn.setCellValueFactory(new PropertyValueFactory<>("matiere"));
        enseignantColumn.setCellValueFactory(new PropertyValueFactory<>("enseignant"));

        // Lier la liste des emplois du temps à la TableView
        tableView.setItems(emplois);
    }

    @FXML
    public void ajouterEmploi(ActionEvent event) {
        try {
            // Récupérer les données des champs
            String id = idField.getText().trim();
            String niveauScolaire = niveauScolaireField.getText().trim();
            String jour = jourField.getText().trim();
            String heureDebut = heureDebutField.getText().trim();
            String heureFin = heureFinField.getText().trim();
            String matiere = matiereField.getText().trim();
            String enseignant = enseignantField.getText().trim();

            if (id.isEmpty() || niveauScolaire.isEmpty() || jour.isEmpty() ||
                heureDebut.isEmpty() || heureFin.isEmpty() || matiere.isEmpty() || enseignant.isEmpty()) {
                afficherMessage("Veuillez remplir tous les champs.");
                return;
            }

            // Créer un nouvel emploi du temps et l'ajouter à la liste
            EmploiDuTemps emploi = new EmploiDuTemps(id, niveauScolaire, jour, heureDebut, heureFin, matiere, enseignant);
            emplois.add(emploi);

            // Réinitialiser les champs après ajout
            idField.clear();
            niveauScolaireField.clear();
            jourField.clear();
            heureDebutField.clear();
            heureFinField.clear();
            matiereField.clear();
            enseignantField.clear();
        } catch (Exception e) {
            afficherMessage("Erreur lors de l'ajout de l'emploi du temps : " + e.getMessage());
        }
    }

  /*  @FXML
public void afficherEmploi() {
    if (emplois.isEmpty()) {
        afficherMessage("Aucun emploi du temps n'est enregistré.");
        return;
    }

    // Afficher dans la console
    System.out.println("Liste des emplois du temps :");
    for (EmploiDuTemps emploi : emplois) {
        System.out.println(emploi); // Affiche les données dans la console
    }
}*/
    
    @FXML
public void afficherEmploi() {
    if (emplois.isEmpty()) {
        afficherMessage("Aucun emploi du temps n'est enregistré.");
        return;
    }

    // Rendre la table visible et afficher les données
    tableView.setVisible(true);
    tableView.setItems(emplois);
}


    private void afficherMessage(String message) {
        System.out.println(message); // Afficher un message dans la console
    }
@FXML
public void masquerEmploi() {
    tableView.setVisible(false); // Masque la TableView
}

}
