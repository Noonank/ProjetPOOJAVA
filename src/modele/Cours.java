/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author noork
 */
public class Cours {
  //ID
  private int id = 0;
  //Nom du professeur
  private String nom = "";

  public Cours(int id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public Cours(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }   
}