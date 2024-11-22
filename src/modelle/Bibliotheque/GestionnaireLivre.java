/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelle.Bibliotheque;

public class GestionnaireLivre implements OperationLivre {
    @Override
    public void executer(String livre) {
        System.out.println("Gestionnaire traite le livre : " + livre);
    }
}
