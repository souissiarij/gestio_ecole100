package Controlleurs;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import modelle.departement.Cantine;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelle.personnes.Etudiant;
import modelle.personnes.administrateur;
import modelle.Bibliotheque.Bibliotheque;

public class EtudiantController {
private Button button; // Assurez-vous que le nom correspond à l'ID dans le fichier FXML
 @FXML
    private TableView<Cantine> cantineTable;
    @FXML
    private TableColumn<Cantine, String> idColumn;
    @FXML
    private TableColumn<Cantine, String> nomColumn;
    @FXML
    private TableColumn<Cantine, String> prenomColumn;
    @FXML
    private TableColumn<Cantine, String> emailColumn;
    @FXML
    private TableColumn<Cantine, String> niveauColumn;
    @FXML
    private TableColumn<Cantine, String> platColumn;

    private administrateur administrateurprincipal = new administrateur();
private Button associerCantineButton;

    public void associerEtudiantCantine(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Cantine.fxml"));
            Parent root = loader.load();

            CantineController controller = loader.getController();
            controller.setAdministrateur(administrateurprincipal);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage.showAndWait();
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de Cantine.fxml : " + e.getMessage());
        }
    }
    
    
  
    
    
     @FXML
    private TableView<Bibliotheque> bibTable;
    @FXML
    private TableColumn<Bibliotheque, String> idbColumn;
    @FXML
    private TableColumn<Bibliotheque, String> ideColumn;
    @FXML
    private TableColumn<Bibliotheque, ArrayList> livresDisponiblesColumn;
    @FXML
    private TableColumn<Bibliotheque, ArrayList> empruntsColumn;
  
    private administrateur administrateurprincipall = new administrateur();
private Button associerbibButton;
    
    public void associerEtudiantbibliotheque(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/bibliotheque.fxml"));
            Parent root = loader.load();

            bibliothequeController controller = loader.getController();
            controller.setAdministrateur(administrateurprincipall);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage.showAndWait();
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de bibliotheque.fxml : " + e.getMessage());
        }
    }

@FXML
public void initialize() {
    // Initialisation des colonnes sans afficher les données
    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
    prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
    niveauColumn.setCellValueFactory(new PropertyValueFactory<>("niveauEtudes"));
    platColumn.setCellValueFactory(new PropertyValueFactory<>("plat"));

    // La table n'est pas visible au départ
    cantineTable.setVisible(false);
    
       idbColumn.setCellValueFactory(new PropertyValueFactory<>("idbibliotheque"));
    ideColumn.setCellValueFactory(new PropertyValueFactory<>("ideetudiant"));
    livresDisponiblesColumn.setCellValueFactory(new PropertyValueFactory<>("livredisponible"));
    empruntsColumn.setCellValueFactory(new PropertyValueFactory<>("livre emrunté"));
   
       bibTable.setVisible(false);

}





    private void chargerScene(ActionEvent event, String cheminFichierFXML) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(cheminFichierFXML));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
       public void afficherListebibliotheque(ActionEvent event) {
            bibTable.setVisible(true);

       idbColumn.setCellValueFactory(new PropertyValueFactory<>("idb"));
    ideColumn.setCellValueFactory(new PropertyValueFactory<>("idE"));
    livresDisponiblesColumn.setCellValueFactory(new PropertyValueFactory<>("livresDisponibles"));
    empruntsColumn.setCellValueFactory(new PropertyValueFactory<>("emprunts"));
   
        ObservableList<Bibliotheque> bib = FXCollections.observableArrayList(administrateurprincipall.getListeb());
        bibTable.setItems(bib);
    }
    
    
   
    public void afficherListecantine(ActionEvent event) {
                cantineTable.setVisible(true);

  idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        niveauColumn.setCellValueFactory(new PropertyValueFactory<>("niveauEtudes"));
        platColumn.setCellValueFactory(new PropertyValueFactory<>("plat"));

        ObservableList<Cantine> cantines = FXCollections.observableArrayList(administrateurprincipal.getListeCan());
        cantineTable.setItems(cantines);
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
  