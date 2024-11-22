/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.matiere;

/**
 *
 * @author souis
 */
import java.util.Date;

public class certificat {
    private String idCertificat;
    private String nomCertificat;
    private Date dateExpiration;
    private Date dateEmission;

    // Constructeur
    public certificat(String idCertificat, String nomCertificat, Date dateExpiration, Date dateEmission) {
        this.idCertificat = idCertificat;
        this.nomCertificat = nomCertificat;
        this.dateExpiration = dateExpiration;
        this.dateEmission = dateEmission;
    }

    // Getters et Setters
    public String getIdCertificat() {
        return idCertificat;
    }

    public void setIdCertificat(String idCertificat) {
        this.idCertificat = idCertificat;
    }

    public String getNomCertificat() {
        return nomCertificat;
    }

    public void setNomCertificat(String nomCertificat) {
        this.nomCertificat = nomCertificat;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    // Méthode toString pour afficher les informations du certificat
    @Override
    public String toString() {
        return "Certificat{" +
               "ID Certificat='" + idCertificat + '\'' +
               ", Nom Certificat='" + nomCertificat + '\'' +
               ", Date Expiration=" + dateExpiration +
               ", Date Emission=" + dateEmission +
               '}';
    }
}

