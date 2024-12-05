package Controlleurs ; 
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelle.matiere.*;
import modelle.personnes.Enseignant;
import modelle.personnes.administrateur;
import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AjouterMatiereController {
    
     administrateur administrateurprincipal = administrateur.getInstance();
     matiere nouvelleMatiere = new matiere();
    @FXML private ComboBox<String> typeCoursComboBox;
    @FXML private TextField titreMatiereField;
    @FXML private VBox formulaireCours;
    @FXML private TextField coursTitreField;
    @FXML private TextField enseignantNomField;
    @FXML private HBox videoSection;
    @FXML private TextField urlVideoField;
    @FXML private TextField dureeVideoField;
    @FXML private TextField tailleVideoField;
    @FXML private HBox documentSection;
    @FXML private TextField formatDocumentField;
    @FXML private TextField pagesDocumentField;
    @FXML private TextField tailleDocumentField;

    private ArrayList<cours> listeCours = new ArrayList<>();
    private final administrateur admin = administrateur.getInstance();

    @FXML
    public void initialize() {
        // Ajouter les options pour le type de cours dans le ComboBox
        ObservableList<String> types = FXCollections.observableArrayList("Vidéo", "Document");
        typeCoursComboBox.setItems(types);

        // Initialiser la visibilité des sections
        videoSection.setVisible(false);
        documentSection.setVisible(false);

        // Écouter les changements dans la ComboBox pour afficher la section correspondante
        typeCoursComboBox.setOnAction(this::handleTypeCoursChange);
    }

    // Méthode pour changer la visibilité des sections en fonction du type de cours sélectionné
    private void handleTypeCoursChange(ActionEvent event) {
        String typeCours = typeCoursComboBox.getValue();
        if ("Vidéo".equals(typeCours)) {
            videoSection.setVisible(true);
            documentSection.setVisible(false);
        } else if ("Document".equals(typeCours)) {
            videoSection.setVisible(false);
            documentSection.setVisible(true);
        }
    }

    @FXML
    private void ajouterCours(ActionEvent event) {
        String typeCours = typeCoursComboBox.getValue();
        String titreCours = coursTitreField.getText();
        String nomEnseignant = enseignantNomField.getText();

        if (typeCours == null || titreCours.isEmpty() || nomEnseignant.isEmpty()) {
            System.err.println("Veuillez remplir les champs obligatoires !");
            return;
        }

        Enseignant enseignant = new Enseignant("2","2","2","2","2");
        cours cours;

        try {
            if ("Vidéo".equals(typeCours)) {
                String url = urlVideoField.getText();
                double duree = Double.parseDouble(dureeVideoField.getText());
                double taille = Double.parseDouble(tailleVideoField.getText());

                cours = new video(titreCours, enseignant, url, duree, taille);
            } else { // Type Document
                String format = formatDocumentField.getText();
                int nbPages = Integer.parseInt(pagesDocumentField.getText());
                long taille = Long.parseLong(tailleDocumentField.getText());

                cours = new document(titreCours, enseignant, format, nbPages, taille);
            }

            nouvelleMatiere.ajouterCours(cours);
            System.out.println("Cours ajouté : " + cours);
        } catch (NumberFormatException e) {
            System.err.println("Veuillez entrer des valeurs numériques valides pour les champs numériques !");
        }
    }

   @FXML
private TableView<matiere> matiereTable;

@FXML

private void enregistrerMatiere(ActionEvent event) {
    String titreMatiere = titreMatiereField.getText();

    if (titreMatiere.isEmpty() || nouvelleMatiere.getCours().isEmpty()) {
        System.err.println("Veuillez remplir tous les champs avant d'enregistrer !");
        return;
    }

    // Assigner le titre de la matière à l'objet nouvelleMatiere
    nouvelleMatiere.setTitreMatiere(titreMatiere); // Assurez-vous que vous avez une méthode setTitreMatiere dans votre classe matiere

    // Ajouter la nouvelle matière dans le gestionnaire d'administrateur
    administrateurprincipal.ajouterMatiere(nouvelleMatiere);
    System.out.println("Matière enregistrée : " + nouvelleMatiere);

    // Mettre à jour la TableView
   // matiereTable.setItems(FXCollections.observableArrayList(administrateurprincipal.getListeMatieres()));

    // Réinitialisation des champs après enregistrement
    titreMatiereField.clear();
    coursTitreField.clear();
    enseignantNomField.clear();
    tailleVideoField.clear();
    urlVideoField.clear();
    dureeVideoField.clear();
    formatDocumentField.clear();
    pagesDocumentField.clear();
    tailleDocumentField.clear();
    listeCours.clear();
}
}