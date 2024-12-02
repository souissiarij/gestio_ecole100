package controlleurs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class WelcomeController {

    @FXML
    private Button btnEnter;

    @FXML
    private void goToAdmin() throws IOException {
        // Charger l'interface Admin
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/admin.fxml"));
        Parent adminRoot = loader.load();
        Stage stage = (Stage) btnEnter.getScene().getWindow();
        Scene scene = new Scene(adminRoot);
        stage.setScene(scene);
        stage.show();
    }
}
