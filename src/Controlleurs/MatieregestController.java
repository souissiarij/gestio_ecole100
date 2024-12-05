package Controlleurs;

import java.io.IOException;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelle.matiere.matiere;
import modelle.matiere.cours; 
import modelle.matiere.video;
import modelle.matiere.document;
        import modelle.personnes.administrateur;

public class MatieregestController {
     administrateur administrateurprincipal = administrateur.getInstance();

   
    // Liste observable pour les matières
    private ObservableList<matiere> matieresList;

  
    @FXML
    private void ajouterMatiere(ActionEvent event) {
        // Charger l'interface d'ajout de matière
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/ajoutermatiere.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajouter une Matière");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            // Une fois la matière ajoutée, afficher la liste mise à jour
            afficherListeMatieres(null); // Rafraîchir la liste des matières
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de l'interface Ajouter Matière : " + e.getMessage());
            e.printStackTrace();
        }
    }

   @FXML
private TableView<matiere> matiereTable;

@FXML
private TableColumn<matiere, Integer> idMatiereColumn;

@FXML
private TableColumn<matiere, String> titreMatiereColumn;



@FXML
private void afficherListeMatieres(ActionEvent event) {
    // Rendre le tableau visible
    matiereTable.setVisible(true);

    // Configurer les colonnes en utilisant PropertyValueFactory pour lier les colonnes aux propriétés des objets
    idMatiereColumn.setCellValueFactory(new PropertyValueFactory<>("idMatiere"));
    titreMatiereColumn.setCellValueFactory(new PropertyValueFactory<>("titreMatiere"));
    //coursSizeColumn.setCellValueFactory(new PropertyValueFactory<>("coursSize"));

    // Charger les données dans la TableView
    // Récupérer la liste des matières à partir de votre instance administrateurprincipal
    ObservableList<matiere> matieres = FXCollections.observableArrayList(administrateurprincipal.getListeMatieres());

    // Mettre la liste dans la TableView
    matiereTable.setItems(matieres);
}

    @FXML
private void supprimerMatiere(ActionEvent event) {
    // Afficher une boîte de dialogue pour demander l'ID de la matière à supprimer
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Supprimer une matière");
    dialog.setHeaderText("Entrez l'identifiant de la matière à supprimer :");
    dialog.setContentText("ID :");

    // Récupérer l'input utilisateur
    Optional<String> result = dialog.showAndWait();
    if (result.isPresent()) {
        String idMatiere = result.get().trim();

        // Affiche les IDs disponibles pour le débogage
        System.out.println("ID recherché : " + idMatiere);
        administrateurprincipal.getListeMatieres().forEach(matiere -> {
            System.out.println("ID dans la liste : " + matiere.getIdMatiere());
        });

        // Rechercher la matière avec cet ID
        matiere matiereASupprimer = administrateurprincipal
            .getListeMatieres()
            .stream()
         .filter(matiere -> Integer.parseInt(idMatiere) == matiere.getIdMatiere())
            .findFirst()
            .orElse(null);

        if (matiereASupprimer != null) {
            // Supprimer la matière de la liste
            administrateurprincipal.getListeMatieres().remove(matiereASupprimer);

            // Mettre à jour le tableau
            matiereTable.setItems(FXCollections.observableArrayList(administrateurprincipal.getListeMatieres()));

            // Message de confirmation
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Matière supprimée avec succès !");
            alert.showAndWait();
        } else {
            // Message d'erreur si l'ID est introuvable
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucune matière trouvée avec l'ID fourni !");
            alert.showAndWait();
        }
    }
}

    @FXML
    private void modifierMatiere(ActionEvent event) {
        System.out.println("Modifier une matière");
        // Implémenter la logique pour modifier une matière
    }

   

    @FXML
    private void ajouterCoursAMatiere(ActionEvent event) {
        System.out.println("Ajouter un cours à une matière");
        // Implémenter la logique pour ajouter un cours
    }

    @FXML
    private void handleRetourMenuPrincipal(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/admin.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu Principal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Pour déboguer en cas d'erreur
        }
    }
    @FXML
private void afficherMatiereParId(ActionEvent event) {
    // Afficher une boîte de dialogue pour demander l'ID de la matière
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Afficher une matière");
    dialog.setHeaderText("Entrez l'identifiant de la matière :");
    dialog.setContentText("ID :");

    // Récupérer l'input utilisateur
    Optional<String> result = dialog.showAndWait();
    if (result.isPresent()) {
        String idMatiere = result.get().trim();

        // Affiche les IDs disponibles pour le débogage
        System.out.println("ID recherché : " + idMatiere);
        administrateurprincipal.getListeMatieres().forEach(matiere -> {
            System.out.println("ID dans la liste : " + matiere.getIdMatiere());
        });

        // Rechercher la matière avec cet ID
        matiere matiereTrouvee = administrateurprincipal
            .getListeMatieres()
            .stream()
            .filter(matiere -> Integer.parseInt(idMatiere) == matiere.getIdMatiere())
            .findFirst()
            .orElse(null);

        if (matiereTrouvee != null) {
            // Détails de la matière
            String details = "ID : " + matiereTrouvee.getIdMatiere() + "\n" +
                             "Titre : " + matiereTrouvee.getTitreMatiere() + "\n" +
                             "Nombre de Cours : " + matiereTrouvee.getCoursSize() + "\n\n" +
                             "Détails des Cours :\n";

            // Ajouter les détails des cours associés
            for (cours cours : matiereTrouvee.getCours()) {
                details += "  - Cours ID : " + cours.getIdCours() + ", Titre : " + cours.getTitreCours() + "\n";

                // Vérifier si le cours est une vidéo
                if (cours instanceof video) {
                    video v = (video) cours; // Cast du cours en vidéo
                    details += "    Type : Vidéo\n" +
                               "    URL : " + v.getUrlVideo() + "\n" +
                               "    Durée : " + v.getDureeVideo() + " minutes\n" +
                               "    Taille : " + v.getTaille() + " Mo\n";
                }
                // Vérifier si le cours est un document
                else if (cours instanceof document) {
                    document d = (document) cours; // Cast du cours en document
                    details += "    Type : Document\n" +
                               "    Format : " + d.getFormat() + "\n" +
                               "    Nombre de Pages : " + d.getNbPages() + "\n" +
                               "    Taille : " + d.getTaille() + " Ko\n";
                }
            }

            // Message d'information
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Détails de la Matière");
            alert.setHeaderText(null);
            alert.setContentText(details);
            alert.showAndWait();
        } else {
            // Message d'erreur si l'ID est introuvable
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucune matière trouvée avec l'ID fourni !");
            alert.showAndWait();
        }
    }
}



}
