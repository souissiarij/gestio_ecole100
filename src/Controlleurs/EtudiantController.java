

package Controlleurs;

import java.io.IOException;
import java.util.ArrayList;
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
import modelle.Bibliotheque.Bibliotheque;
import modelle.departement.Cantine;


public class EtudiantController {

    @FXML
    private TableView<Cantine> tableViewCantine;
    @FXML
    private TableColumn<Cantine, String> colId;
    @FXML
    private TableColumn<Cantine, String> colNom;
    @FXML
    private TableColumn<Cantine, String> colPrenom;
    @FXML
    private TableColumn<Cantine, String> colEmail;
    @FXML
    private TableColumn<Cantine, String> colNiv;
    @FXML
    private TableColumn<Cantine, String> colPlat;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNiveau;
     @FXML
    private TextField txtPlat;
    @FXML
    private Button btnAjouterCant;

    private ObservableList<Cantine> listeCantines;
    @FXML
    private Button btnAjouterBiblio;

    @FXML
    private Button btnAfficher;
    
    @FXML 
    private TableView<Bibliotheque> tableViewBib;
    @FXML private TableColumn<Bibliotheque, Integer> colIdBib;
    @FXML private TableColumn<Bibliotheque, String> colIDEtud;
    @FXML private TableColumn<Bibliotheque, String> colLivreDispo;
    @FXML private TableColumn<Bibliotheque, String> colLivreEmpr;

    @FXML private TextField txtIDBiblio;
    @FXML private TextField txtIDEtud;
    @FXML private TextField txtLivDispo;
    @FXML private TextField txtLivEmpru;

    private ObservableList<Bibliotheque> listeBib ;

    // Méthode pour ajouter un cours
    @FXML
    public void ajouterCantine() {
        
        String idCantine = txtId.getText();
        String NomEtud = txtNom.getText();
        String PrenomEtud = txtPrenom.getText();
        String EmailEtud = txtEmail.getText();
        String NiveauEtud = txtNiveau.getText();
        String PlatSelec = txtPlat.getText();

        if (idCantine.isEmpty() || NomEtud.isEmpty() || PrenomEtud.isEmpty() || EmailEtud.isEmpty() || NiveauEtud.isEmpty() || PlatSelec.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs.");
            return;
        }
        
        Cantine cantine= new Cantine (idCantine, NomEtud, PrenomEtud, EmailEtud, NiveauEtud, PlatSelec);
        listeCantines.add(cantine);
        
        
        txtId.clear();
        txtNom.clear();
        txtPrenom.clear();
        txtEmail.clear();
        txtNiveau.clear();
        txtPlat.clear();
        

        
    }
    
     public void ajouterBib() {
        String idbib = txtIDBiblio.getText();
    String idetud = txtIDEtud.getText();
    String livreDispoText = txtLivDispo.getText();
    String livreEmprunText = txtLivEmpru.getText();
        if (idbib.isEmpty() || idetud.isEmpty() || livreDispoText.isEmpty() || livreEmprunText.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs.");
            return;
        }
 ArrayList<String> livredispo = new ArrayList<>();
    livredispo.add(livreDispoText);

    ArrayList<String> livreemprun = new ArrayList<>();
    livreemprun.add(livreEmprunText);
        Bibliotheque Bibliotheque = new Bibliotheque(idbib, livredispo,idetud,  livreemprun);
        listeBib.add(Bibliotheque);
System.out.println("Nouvelle bibliothèque ajoutée : " + Bibliotheque.getIdb());
System.out.println("Taille de listeBib : " + listeBib.size());
        // Réinitialisation des champs de texte après l'ajout
        txtIDBiblio.clear();
        txtIDEtud.clear();
        txtLivDispo.clear();
        txtLivEmpru.clear();
    }
    @FXML
    public void afficherCantine() {
        // Rendre la TableView visible
        tableViewCantine.setVisible(true);
    }
    
    public void initialize() {
    // Initialisation des colonnes de la table des enseignants
    colId.setCellValueFactory(new PropertyValueFactory<>("id"));
    colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    colNiv.setCellValueFactory(new PropertyValueFactory<>("niveauEtudes"));
    colPlat.setCellValueFactory(new PropertyValueFactory<>("plat"));


    // Initialisation de la liste d'enseignants
    listeCantines = FXCollections.observableArrayList();
    tableViewCantine.setItems(listeCantines);

    // Action sur le bouton "Ajouter" pour les enseignants
    btnAjouterCant.setOnAction(event -> ajouterCantine());

    // Initialisation des colonnes de la table des cours
   colIdBib.setCellValueFactory(new PropertyValueFactory<>("idb"));
colIDEtud.setCellValueFactory(new PropertyValueFactory<>("idE"));
colLivreDispo.setCellValueFactory(new PropertyValueFactory<>("livresDisponibles"));
colLivreEmpr.setCellValueFactory(new PropertyValueFactory<>("emprunts"));


    // Initialisation de la liste de cours
    listeBib = FXCollections.observableArrayList();
    tableViewBib.setItems(listeBib);

    // Action sur le bouton "Ajouter Cours"
    btnAjouterBiblio.setOnAction(event -> ajouterBib());
}


   
       @FXML
    
public void afficherBib() {
  tableViewBib.setVisible(true);

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
