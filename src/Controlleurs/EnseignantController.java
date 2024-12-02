package Controlleurs;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import modelle.personnes.Enseignant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelle.matiere.cours ;

public class EnseignantController {

    @FXML
    private TableView<Enseignant> tableViewEnseignants;
    @FXML
    private TableColumn<Enseignant, String> colId;
    @FXML
    private TableColumn<Enseignant, String> colNom;
    @FXML
    private TableColumn<Enseignant, String> colPrenom;
    @FXML
    private TableColumn<Enseignant, String> colEmail;
    @FXML
    private TableColumn<Enseignant, String> colSpecialite;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSpecialite;
    @FXML
    private Button btnAjouter;

    private ObservableList<Enseignant> listeEnseignants;
@FXML
private Button btnAjouterCours;

    
    @FXML
    private Button btnAfficher;
    @FXML private TableView<cours> tableViewCours;
    @FXML private TableColumn<cours, Integer> colIdCours;
    @FXML private TableColumn<cours, String> colTitreCours;
    @FXML private TableColumn<cours, String> colEnseignant;
    @FXML private TextField txtidCours;

    @FXML private TextField txtTitreCours;
    @FXML private TextField txtEnseignant;

    private ObservableList<cours> listeCours = FXCollections.observableArrayList();

    // Méthode pour ajouter un cours
    @FXML
    public void ajouterCours() {
        
        String titreCours = txtTitreCours.getText();
        String nomEnseignant = txtEnseignant.getText();

        // Recherche de l'enseignant par nom (à améliorer avec une recherche plus robuste)
        Enseignant enseignant = null;
        for (Enseignant e : tableViewEnseignants.getItems()) {
            if (e.getNom().equalsIgnoreCase(nomEnseignant)) {
                enseignant = e;
                break;
            }
        }

        if (enseignant != null && !titreCours.isEmpty()) {
            cours nouveauCours = new cours(titreCours, enseignant);
            listeCours.add(nouveauCours);
            tableViewCours.setItems(listeCours);
            txtTitreCours.clear();
            txtEnseignant.clear();
        } else {
            // Message d'erreur si l'enseignant n'est pas trouvé ou si le titre est vide
            System.out.println("Erreur : Enseignant introuvable ou titre du cours vide.");
        }
    }
    @FXML
    public void afficherTable() {
        // Rendre la TableView visible
        tableViewEnseignants.setVisible(true);
    }
public void initialize() {
    // Initialisation des colonnes de la table des enseignants
    colId.setCellValueFactory(new PropertyValueFactory<>("id"));
    colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    colSpecialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));

    // Initialisation de la liste d'enseignants
    listeEnseignants = FXCollections.observableArrayList();
    tableViewEnseignants.setItems(listeEnseignants);

    // Action sur le bouton "Ajouter" pour les enseignants
    btnAjouter.setOnAction(event -> ajouterEnseignant());

    // Initialisation des colonnes de la table des cours
    colIdCours.setCellValueFactory(new PropertyValueFactory<>("idCours"));
    colTitreCours.setCellValueFactory(new PropertyValueFactory<>("titreCours"));
    colEnseignant.setCellValueFactory(cellData -> {
        // Pour afficher le nom de l'enseignant dans la colonne "Enseignant"
        return new SimpleStringProperty(cellData.getValue().getEnseignant().getNom());
    });

    // Initialisation de la liste de cours
    listeCours = FXCollections.observableArrayList();
    tableViewCours.setItems(listeCours);

    // Action sur le bouton "Ajouter Cours"
    btnAjouterCours.setOnAction(event -> ajouterCours());
}


    private void ajouterEnseignant() {
        String id = txtId.getText();
        String nom = txtNom.getText();
        String prenom = txtPrenom.getText();
        String email = txtEmail.getText();
        String specialite = txtSpecialite.getText();

        if (id.isEmpty() || nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || specialite.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs.");
            return;
        }

        Enseignant enseignant = new Enseignant(id, nom, prenom, email, specialite);
        listeEnseignants.add(enseignant);

        // Réinitialisation des champs de texte après l'ajout
        txtId.clear();
        txtNom.clear();
        txtPrenom.clear();
        txtEmail.clear();
        txtSpecialite.clear();
    }
       @FXML
    public void afficherCours() {
        tableViewCours.setVisible(true);
    }
    
        public void retourr(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Vues/admin.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
