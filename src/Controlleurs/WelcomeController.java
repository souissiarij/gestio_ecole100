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
        // Load the Admin interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/admin.fxml"));
        Parent adminRoot = loader.load();
        
        Stage stage = (Stage) btnEnter.getScene().getWindow();
        
        // Preserve the size of the stage (same size as the login window)
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();
        
        // Set the size of the stage based on the previous size
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);
        
        // Load and set the Admin scene
        Scene scene = new Scene(adminRoot);
        stage.setScene(scene);
        stage.show();
    }
}
