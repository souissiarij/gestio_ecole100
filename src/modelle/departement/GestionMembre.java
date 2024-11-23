/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelle.departement;

/**
 *
 * @author user
 */
@FunctionalInterface
interface GestionMembre {
    void gerer(String membre) throws ClubException;
}
