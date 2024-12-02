package Controlleurs;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modelle.departement.Club;
import modelle.departement.TypeClub;
import modelle.departement.ClubException;
import modelle.departement.Membre;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClubController {

    @FXML
    private ChoiceBox<String> clubTypeChoiceBox;

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextArea outputArea;

    private List<Club> clubs = new ArrayList<>();

@FXML
public void initialize() {
    System.out.println("Interface Club chargée avec succès !");
    clubTypeChoiceBox.setItems(FXCollections.observableArrayList(
        "SPORTIF", "CULTUREL", "SCIENTIFIQUE", "ARTISTIQUE"
    ));
}


    @FXML
    public void ajouterMembre() {
        String nomMembre = nomField.getText().trim();
        String prenomMembre = prenomField.getText().trim();
        String typeClubStr = clubTypeChoiceBox.getValue();

        if (nomMembre.isEmpty() || prenomMembre.isEmpty() || typeClubStr == null) {
            outputArea.setText("Veuillez remplir tous les champs avant d'ajouter un membre !");
            return;
        }

        // Trouver ou créer un club correspondant
        TypeClub typeClub = TypeClub.valueOf(typeClubStr.toUpperCase());
        Club club = clubs.stream()
            .filter(c -> c.getTypeClub() == typeClub)
            .findFirst()
            .orElseGet(() -> {
                Club newClub = new Club(typeClub.name(), typeClub);
                clubs.add(newClub);
                return newClub;
            });

        // Ajouter le membre au club
        try {
            club.ajouterMembre(new Membre(nomMembre, prenomMembre));
            outputArea.setText("Membre ajouté avec succès au club " + club.getNom() + " !");
        } catch (ClubException e) {
            outputArea.setText("Erreur : " + e.getMessage());
        }

        // Effacer les champs
        nomField.clear();
        prenomField.clear();
        clubTypeChoiceBox.setValue(null);
    }

    @FXML
    public void afficherMembres() {
        if (clubs.isEmpty()) {
            outputArea.setText("Aucun club n'a été créé.");
            return;
        }

        StringBuilder affichage = new StringBuilder();
        for (Club club : clubs) {
            affichage.append("Club: ").append(club.getNom())
                    .append(" (").append(club.getTypeClub()).append(")\n");
            club.getMembres().forEach(membre ->
                    affichage.append("- ").append(membre.nom()).append(" ").append(membre.prenom()).append("\n")
            );
            affichage.append("\n");
        }

        outputArea.setText(affichage.toString());
    }
    
    @FXML
public void afficherNomClub() {
    String typeClubStr = clubTypeChoiceBox.getValue();
    if (typeClubStr == null) {
        outputArea.setText("Aucun type de club sélectionné !");
        return;
    }

    TypeClub typeClub = TypeClub.valueOf(typeClubStr.toUpperCase());
    Club club = clubs.stream()
            .filter(c -> c.getTypeClub() == typeClub)
            .findFirst()
            .orElse(null);

    if (club != null) {
        outputArea.setText("Le club sélectionné est : " + club.getNom());
    } else {
        outputArea.setText("Aucun club de ce type n'existe !");
    }
}
@FXML
private TextField nomClubField; // Nouveau champ pour le nom du club

@FXML
public void ajouterClub() {
    String nomClub = nomClubField.getText().trim();
    String typeClubStr = clubTypeChoiceBox.getValue();

    if (nomClub.isEmpty() || typeClubStr == null) {
        outputArea.setText("Veuillez remplir le nom du club et sélectionner un type !");
        return;
    }

    // Vérifiez si un club avec le même nom existe déjà
    if (clubs.stream().anyMatch(club -> club.getNom().equalsIgnoreCase(nomClub))) {
        outputArea.setText("Un club avec ce nom existe déjà !");
        return;
    }

    // Créez un nouveau club
    TypeClub typeClub = TypeClub.valueOf(typeClubStr.toUpperCase());
    Club nouveauClub = new Club(nomClub, typeClub);
    clubs.add(nouveauClub);

    outputArea.setText("Club '" + nomClub + "' de type '" + typeClub + "' ajouté avec succès !");
    
    // Effacer le champ
    nomClubField.clear();
}
@FXML
    private void handleRetourMenuPrincipal(ActionEvent event) {
    try {
        // Charger le fichier FXML du menu principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/admin.fxml"));
        Parent root = loader.load();

        // Obtenir la scène actuelle et définir le nouveau contenu
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));

        // Optionnel : définir le titre de la fenêtre
        stage.setTitle("Menu Principal");

        // Afficher la scène
        stage.show();
    } catch (IOException e) {
        e.printStackTrace(); // Pour déboguer en cas d'erreur
    }
}

}
