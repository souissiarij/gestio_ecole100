package controlleurs;

import java.awt.Image;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.scene.image.ImageView;

public class LoginController {

       @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox rememberMeCheckbox;

    // Preferences for storing user login data
    private Preferences preferences = Preferences.userNodeForPackage(LoginController.class);

    @FXML
    private void initialize() {
        // Load saved credentials if "Remember Me" was previously selected
        String savedUsername = preferences.get("savedUsername", "");
        String savedPassword = preferences.get("savedPassword", "");
        boolean rememberMe = preferences.getBoolean("rememberMe", false);

        if (rememberMe) {
            usernameField.setText(savedUsername);
            passwordField.setText(savedPassword);
            rememberMeCheckbox.setSelected(true);
        }
    
     
        
    }


    @FXML
    private void handleLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Vérification simple des informations de connexion
        if ("admin".equals(username) && "password".equals(password)) {
            // Save credentials if "Remember Me" is selected
            if (rememberMeCheckbox.isSelected()) {
                preferences.put("savedUsername", username);
                preferences.put("savedPassword", password);
                preferences.putBoolean("rememberMe", true);
            } else {
                preferences.remove("savedUsername");
                preferences.remove("savedPassword");
                preferences.putBoolean("rememberMe", false);
            }

            // Redirection vers la page de bienvenue
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/welcome.fxml"));
            Parent welcomeRoot = loader.load();
            Stage stage = (Stage) usernameField.getScene().getWindow();
            // Preserve the size of the stage (same size as the login window)
            double currentWidth = stage.getWidth();
            double currentHeight = stage.getHeight();
        
            // Set the size of the stage based on the previous size
            stage.setWidth(currentWidth);
            stage.setHeight(currentHeight);
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

    @FXML
    private void handleForgotPassword() {
        
        // Display a placeholder alert for "Forgot Password"
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Réinitialisation du mot de passe");
        alert.setHeaderText(null);
        alert.setContentText("La fonctionnalité de réinitialisation du mot de passe sera disponible prochainement.");
        alert.showAndWait();
    }
}
