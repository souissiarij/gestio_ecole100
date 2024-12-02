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

public class CantineController {
    @FXML   
     private Cantine cantineCree;

    public Cantine getcantineCree() {
        return cantineCree;
    }
       @FXML
    private TextField idField, nomField, prenomField, emailField, niveauEtudesField, platSelectionField;
    @FXML
    private ListView<String> menuListView;
  




      
    
    

    private administrateur administrateurprincipal; // Référence à l'administrateur

    public void setAdministrateur(administrateur admin) {
        this.administrateurprincipal = admin;
    }
    
    // Ajoutez la logique pour sauvegarder le `Cantine` dans l'administrateur
    @FXML
    public void enregistreretudiant() {
        String id = idField.getText().trim();
        String nom = nomField.getText().trim();
        String prenom = prenomField.getText().trim();
        String email = emailField.getText().trim();
        String niveau = niveauEtudesField.getText().trim();
        String plat = platSelectionField.getText().trim();

        if (id.isEmpty() || nom.isEmpty() || plat.isEmpty()) {
            System.out.println("Tous les champs sont obligatoires.");
            return;
        }

        Cantine cantine = new Cantine(id, nom, prenom, email, niveau, plat);
        administrateurprincipal.associerEtudiantCantine(cantine);
        System.out.println("Étudiant enregistré dans la cantine.");
    }

    public void retour(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Vues/Etudiant.fxml"));
            Stage stage = (Stage) idField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




      
}
    
    
    