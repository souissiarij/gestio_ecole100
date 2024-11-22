package controlleurs;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class WelcomeController {

    @FXML
    private Button btnEnter; // Lien avec le bouton Entrer dans le fichier FXML

    @FXML
    private void goToAdmin() throws IOException {
        // Charger le fichier FXML de l'interface Admin
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/admin.fxml"));
        Parent adminRoot = loader.load();

        // Récupérer la scène actuelle et la remplacer par la scène Admin
        Stage stage = (Stage) btnEnter.getScene().getWindow(); // Récupérer la fenêtre actuelle
        Scene scene = new Scene(adminRoot); // Créer une nouvelle scène
        stage.setScene(scene); // Appliquer la nouvelle scène
        stage.show(); // Afficher la fenêtre
    }
}
