/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlleurs;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelle.matiere.certificat;

import java.time.LocalDate;
import java.util.Date;

public class CertificatFormController {
    @FXML
    private TextField idCertificatField;

    @FXML
    private TextField nomCertificatField;

    @FXML
    private DatePicker dateEmissionPicker;

    @FXML
    private DatePicker dateExpirationPicker;

    private certificat certificatCree;

    public certificat getCertificatCree() {
        return certificatCree;
    }

    @FXML
    private void enregistrerCertificat() {
        // Récupérer les valeurs saisies
        String idCertificat = idCertificatField.getText();
        String nomCertificat = nomCertificatField.getText();
        LocalDate dateEmission = dateEmissionPicker.getValue();
        LocalDate dateExpiration = dateExpirationPicker.getValue();

        // Validation des données
        if (idCertificat.isEmpty() || nomCertificat.isEmpty() || dateEmission == null || dateExpiration == null) {
            System.out.println("Tous les champs doivent être remplis.");
            return;
        }

        // Créer l'objet certificat
        certificatCree = new certificat(
            idCertificat,
            nomCertificat,
            java.sql.Date.valueOf(dateExpiration),
            java.sql.Date.valueOf(dateEmission)
        );

        // Fermer la fenêtre
        ((Stage) idCertificatField.getScene().getWindow()).close();
    }

    @FXML
    private void annuler() {
        certificatCree = null;
        ((Stage) idCertificatField.getScene().getWindow()).close();
    }

    void setCertificat(certificat certificatAModifier) {
          if (certificatAModifier != null) {
        // Pré-remplir les champs avec les données existantes du certificat
        idCertificatField.setText(certificatAModifier.getIdCertificat());
        nomCertificatField.setText(certificatAModifier.getNomCertificat());
        //dateEmissionPicker.setValue(certificatAModifier.getDateEmission().toLocalDate());
        //dateExpirationPicker.setValue(certificatAModifier.getDateExpiration().toLocalDate());

        // Préserver l'instance actuelle du certificat (utile pour les modifications)
        this.certificatCree = certificatAModifier;
    
}}}
