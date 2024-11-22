package Controlleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WelcomeController {

    @FXML
    private Button startButton;

    @FXML
    private void initialize() {
        // Initialisation si nécessaire
        System.out.println("WelcomeController initialized!");
    }

    @FXML
    private void handleStartButton(ActionEvent event) {
        System.out.println("Start button clicked!");
        // Ajoutez ici la logique pour changer de scène ou effectuer une action
    }
}
