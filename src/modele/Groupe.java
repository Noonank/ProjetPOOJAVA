/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author noork
 */
public class Groupe {
  //ID
  private int id = 0;
  //Nom du professeur
  private String nom = "";
  //ID promotion
  private int id_promo = 0;
  //Liste des professeurs
  private Set<Groupe> listGroupe = new HashSet<Groupe>();
  //Liste des élèves
  private Set<Etudiant> listEtudiant = new HashSet<Etudiant>();

  public Groupe(int id, String nom, int id_promo) {
    this.id = id;
    this.nom = nom;
    this.id_promo = id_promo;
  }
  public Groupe(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  public int getIdPromo() {
    return id_promo;
  }

  public void setIdPromo(int id_promo) {
    this.id_promo = id_promo;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Set<Groupe> getListGroupe() {
    return listGroupe;
  }

  public void setListGroupe(Set<Groupe> listGroupe) {
    this.listGroupe = listGroupe;
  }

  public void addGroupe(Groupe prof) {
    if(!listGroupe.contains(prof))
      listGroupe.add(prof);
  }

  public void removeGroupe(Groupe prof ) {
    this.listGroupe.remove(prof);
  }

  public Set<Etudiant> getListEtudiant() {
    return listEtudiant;
  }

  public void setListEtudiant(Set<Etudiant> listEtudiant) {
    this.listEtudiant = listEtudiant;
  }

  //Ajoute un élève à la classe
  public void addEtudiant(Etudiant etudiant){
    if(!this.listEtudiant.contains(etudiant))
      this.listEtudiant.add(etudiant);
  }

  //Retire un élève de la classe
  public void removeEtudiant(Etudiant etudiant){
    this.listEtudiant.remove(etudiant);
  }

  public boolean equals(Groupe grp){
    return this.getId() == grp.getId();
  }   
}
