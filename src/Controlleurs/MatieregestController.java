package Controlleurs;

import java.io.IOException;
import java.util.List;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
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
import modelle.personnes.Enseignant;

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

@FXML private TableView<matiere> matiereTable;
    @FXML private TableColumn<matiere, Integer> idMatiereColumn;
    @FXML private TableColumn<matiere, String> titreMatiereColumn;
    @FXML private TableColumn<matiere, Integer> nbrecoursColumn;

    private ObservableList<matiere> matieres = FXCollections.observableArrayList();

@FXML
private void afficherListeMatieres(ActionEvent event) {
    // Rendre le tableau visible
    matiereTable.setVisible(true);
    
    // Configurer les colonnes en utilisant PropertyValueFactory pour lier les colonnes aux propriétés des objets
   
    nbrecoursColumn.setCellValueFactory(new  PropertyValueFactory<>("nbrecours") );
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
private void ajouterCoursAMatiere(ActionEvent event) {
    // Boîte de dialogue pour entrer l'ID de la matière
    TextInputDialog idDialog = new TextInputDialog();
    idDialog.setTitle("Ajouter un Cours");
    idDialog.setHeaderText("Entrez l'identifiant de la matière :");
    idDialog.setContentText("ID de la matière :");

    Optional<String> idResult = idDialog.showAndWait();
    if (idResult.isPresent()) {
        String idMatiere = idResult.get().trim();

        // Rechercher la matière
        matiere matiereSelectionnee = administrateurprincipal
                .getListeMatieres()
                .stream()
                .filter(matiere -> Integer.parseInt(idMatiere) == matiere.getIdMatiere())
                .findFirst()
                .orElse(null);

        if (matiereSelectionnee != null) {
            // Créer une boîte de dialogue pour le choix du type de cours (Vidéo ou Document)
            ChoiceDialog<String> typeDialog = new ChoiceDialog<>("Vidéo", "Vidéo", "Document");
            typeDialog.setTitle("Choisir le type de cours");
            typeDialog.setHeaderText("Choisissez le type de cours :");
            typeDialog.setContentText("Type de cours :");

            Optional<String> typeResult = typeDialog.showAndWait();
            if (typeResult.isPresent()) {
                String typeCours = typeResult.get().toLowerCase();

                // Créer une boîte de dialogue personnalisée pour les détails du cours
                javafx.scene.control.Dialog<String[]> dialog = new javafx.scene.control.Dialog<>();
                dialog.setTitle("Ajouter un Cours");
                dialog.setHeaderText("Entrez les informations du cours :");

                // Champs pour le titre du cours
                javafx.scene.control.TextField titreField = new javafx.scene.control.TextField();
                titreField.setPromptText("Titre du cours");

                // Créer les champs pour la vidéo ou le document
                javafx.scene.control.TextField urlField = new javafx.scene.control.TextField();
                urlField.setPromptText("URL (pour une vidéo)");

                javafx.scene.control.TextField dureeField = new javafx.scene.control.TextField();
                dureeField.setPromptText("Durée (minutes, pour une vidéo)");

                javafx.scene.control.TextField tailleField = new javafx.scene.control.TextField();
                tailleField.setPromptText("Taille (Mo pour une vidéo / Ko pour un document)");

                javafx.scene.control.TextField formatField = new javafx.scene.control.TextField();
                formatField.setPromptText("Format (ex : PDF pour un document)");

                javafx.scene.control.TextField pagesField = new javafx.scene.control.TextField();
                pagesField.setPromptText("Nombre de pages (pour un document)");

                // Créer le GridPane pour ajouter les champs au dialogue
                javafx.scene.layout.GridPane grid = new javafx.scene.layout.GridPane();
                grid.setHgap(10);
                grid.setVgap(10);
                grid.add(new javafx.scene.control.Label("Titre :"), 0, 0);
                grid.add(titreField, 1, 0);

                if (typeCours.equals("vidéo")) {
                    grid.add(new javafx.scene.control.Label("URL :"), 0, 1);
                    grid.add(urlField, 1, 1);
                    grid.add(new javafx.scene.control.Label("Durée :"), 0, 2);
                    grid.add(dureeField, 1, 2);
                } else if (typeCours.equals("document")) {
                    grid.add(new javafx.scene.control.Label("Format :"), 0, 1);
                    grid.add(formatField, 1, 1);
                    grid.add(new javafx.scene.control.Label("Pages :"), 0, 2);
                    grid.add(pagesField, 1, 2);
                }
                grid.add(new javafx.scene.control.Label("Taille :"), 0, 3);
                grid.add(tailleField, 1, 3);

                dialog.getDialogPane().setContent(grid);
                dialog.getDialogPane().getButtonTypes().addAll(javafx.scene.control.ButtonType.OK, javafx.scene.control.ButtonType.CANCEL);

                // Récupérer les données saisies
                dialog.setResultConverter(dialogButton -> {
                    if (dialogButton == javafx.scene.control.ButtonType.OK) {
                        return new String[] {
                            titreField.getText().trim(),
                            typeCours,
                            urlField.getText().trim(),
                            dureeField.getText().trim(),
                            tailleField.getText().trim(),
                            formatField.getText().trim(),
                            pagesField.getText().trim()
                        };
                    }
                    return null;
                });

                Enseignant enseignant = new Enseignant("2", "2", "2", "2", "2");
                Optional<String[]> courseResult = dialog.showAndWait();
                if (courseResult.isPresent()) {
                    try {
                        String[] data = courseResult.get();
                        String courseTitle = data[0];
                        String courseType = data[1];

                        // Créer un cours selon le type
                        if ("vidéo".equals(courseType)) {
                            String url = data[2];
                            double duree = Double.parseDouble(data[3]);
                            double taille = Double.parseDouble(data[4]);

                            video newVideo = new video(courseTitle, enseignant, url, duree, taille);
                            matiereSelectionnee.ajouterCours(newVideo);
                        } else if ("document".equals(courseType)) {
                            String format = data[5];
                            int pages = Integer.parseInt(data[6]);
                            long taille = Long.parseLong(data[4]);

                            document newDocument = new document(courseTitle, enseignant, format, pages, taille);
                            matiereSelectionnee.ajouterCours(newDocument);
                        }

                        // Message de succès après ajout du cours
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Succès");
                        alert.setHeaderText(null);
                        alert.setContentText("Cours ajouté avec succès !");
                        alert.showAndWait();
                    } catch (NumberFormatException e) {
                        // Message d'erreur si des valeurs numériques invalides sont entrées
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Valeurs numériques invalides !");
                        alert.showAndWait();
                    }
                }
            }
        } else {
            // Message d'erreur si la matière n'est pas trouvée
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucune matière trouvée avec l'ID fourni !");
            alert.showAndWait();
        }
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

 public void handleRetourMenuprinicipal(ActionEvent event) {
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
private void supprimerCoursAMatiere(ActionEvent event) {
    // Boîte de dialogue pour entrer l'ID de la matière
    TextInputDialog idDialog = new TextInputDialog();
    idDialog.setTitle("Supprimer un Cours");
    idDialog.setHeaderText("Entrez l'identifiant de la matière :");
    idDialog.setContentText("ID de la matière :");

    Optional<String> idResult = idDialog.showAndWait();
    if (idResult.isPresent()) {
        String idMatiere = idResult.get().trim();

        // Rechercher la matière
        matiere matiereSelectionnee = administrateurprincipal
                .getListeMatieres()
                .stream()
                .filter(matiere -> Integer.parseInt(idMatiere) == matiere.getIdMatiere())
                .findFirst()
                .orElse(null);

        if (matiereSelectionnee != null) {
            // Liste des cours de la matière
          List<cours> listeCours =  matiereSelectionnee.getListeCours();

            if (listeCours.isEmpty()) {
                // Si la matière n'a pas de cours
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Aucun Cours");
                alert.setHeaderText(null);
                alert.setContentText("Il n'y a aucun cours à supprimer dans cette matière.");
                alert.showAndWait();
                return;
            }

            // Créer une boîte de dialogue pour choisir un cours à supprimer
            ChoiceDialog<cours> coursDialog = new ChoiceDialog<>(null, listeCours);
            coursDialog.setTitle("Choisir le Cours à Supprimer");
            coursDialog.setHeaderText("Choisissez le cours à supprimer :");
            coursDialog.setContentText("Cours :");

            Optional<cours> coursResult = coursDialog.showAndWait();
            if (coursResult.isPresent()) {
                cours coursASupprimer = coursResult.get();

                // Demander confirmation avant de supprimer
                Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAlert.setTitle("Confirmation de Suppression");
                confirmAlert.setHeaderText(null);
                confirmAlert.setContentText("Êtes-vous sûr de vouloir supprimer ce cours ?");
                Optional<ButtonType> confirmResult = confirmAlert.showAndWait();

                if (confirmResult.isPresent() && confirmResult.get() == ButtonType.OK) {
                    // Supprimer le cours de la liste de la matière
                    matiereSelectionnee.supprimercours(coursASupprimer);

                    // Message de succès
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Succès");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Cours supprimé avec succès !");
                    successAlert.showAndWait();
                }
            }
        } else {
            // Message d'erreur si la matière n'est pas trouvée
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucune matière trouvée avec l'ID fourni !");
            alert.showAndWait();
        }
    }
}


} 