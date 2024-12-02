package controlleurs;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Vérification simple des informations de connexion
        if ("admin".equals(username) && "password".equals(password)) {
            // Redirection vers la page de bienvenue
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/welcome.fxml"));
            Parent welcomeRoot = loader.load();
            Stage stage = (Stage) usernameField.getScene().getWindow();
            Scene scene = new Scene(welcomeRoot);
            stage.setScene(scene);
            stage.show();
        } else {
            // Message d'erreur en cas de mauvais identifiants
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de connexion");
            alert.setHeaderText(null);
            alert.setContentText("Nom d'utilisateur ou mot de passe incorrect.");
            alert.showAndWait();
        }
    }
}
