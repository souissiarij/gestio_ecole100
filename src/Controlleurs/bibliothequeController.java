package Controlleurs;
import javafx.fxml.FXMLLoader; 
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modelle.departement.Cantine;
import modelle.personnes.Etudiant;
import javafx.scene.Scene; // Pour définir et manipuler une scène dans JavaFX
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Parent; // Pour représenter la racine de la hiérarchie d'une scène
import javafx.stage.Stage; 
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modelle.personnes.administrateur;
import modelle.Bibliotheque.Bibliotheque;
import java.util.ArrayList;
import java.util.List ;
import java.util.Arrays ;
/**
 *
 * @author user
 */
public class bibliothequeController {
    @FXML   
     private Bibliotheque bibCree;

    public Bibliotheque getcantineCree() {
        return bibCree;
    }
      @FXML
      private TextField idbField, idEField, livresDisponiblesField, empruntsField;

  private administrateur administrateurPrincipal; // Référence à l'administrateur

    public void setAdministrateur(administrateur admin) {
        this.administrateurPrincipal = admin;
    }
    
    
    @FXML
public void enregistreretudiant() {
    String idb = idbField.getText().trim();
    String idE = idEField.getText().trim();
    String livresText = livresDisponiblesField.getText().trim();
    String empruntsText = empruntsField.getText().trim();

    if (idb.isEmpty() || idE.isEmpty() || livresText.isEmpty() || empruntsText.isEmpty()) {
        System.out.println("Tous les champs sont obligatoires.");
        return;
    }

    System.out.println("ID Bibliothèque : " + idb);
    System.out.println("ID Étudiant : " + idE);

    ArrayList<String> livresDisponibles = new ArrayList<>(Arrays.asList(livresText.split(",\\s*")));
    ArrayList<String> emprunts = new ArrayList<>(Arrays.asList(empruntsText.split(",\\s*")));

    Bibliotheque bib = new Bibliotheque(idb, livresDisponibles, idE, emprunts);

    if (administrateurPrincipal != null) {
        administrateurPrincipal.associerEtudiantBibliotheque(bib);
        System.out.println("Étudiant enregistré dans la bibliothèque.");
    } else {
        System.out.println("Administrateur principal non initialisé.");
    }
    idbField.clear();
        idEField.clear();   
    livresDisponiblesField.clear();   
    empruntsField.clear();   

}

    public void retour(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Vues/Etudiant.fxml"));
            Stage stage = (Stage) idbField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
} 