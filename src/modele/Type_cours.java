/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;

/**
 *
 * @author noork
 */
public class Type_cours {


  //ID
  private int id = 0;
  //Nom du professeur
  private String nom = "";

  public Type_cours(int id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public Type_cours(){}

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