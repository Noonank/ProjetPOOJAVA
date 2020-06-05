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
public class Salle {
  //ID
  private int id = 0;
  //Nom du professeur
  private String nom = "";
  //Capacite
  private int capacite = 0;
  //ID sitetion
  private int id_site = 0;
  //Liste des professeurs
  private Set<Salle> listSalle = new HashSet<Salle>();
  //Liste des élèves
  private Set<Etudiant> listEtudiant = new HashSet<Etudiant>();

  public Salle(int id, String nom, int capacite, int id_site) {
    this.id = id;
    this.nom = nom;
    this.capacite = capacite;
    this.id_site = id_site;
  }
  public Salle(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public int getCapacite() {
    return capacite;
  }

  public void setCapacite(int capacite) {
    this.capacite = capacite;
  }
  
  public int getIdSite() {
    return id_site;
  }

  public void setIdSite(int id_site) {
    this.id_site = id_site;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Set<Salle> getListSalle() {
    return listSalle;
  }

  public void setListSalle(Set<Salle> listSalle) {
    this.listSalle = listSalle;
  }

  public void addSalle(Salle prof) {
    if(!listSalle.contains(prof))
      listSalle.add(prof);
  }

  public void removeSalle(Salle prof ) {
    this.listSalle.remove(prof);
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

  public boolean equals(Salle salle){
    return this.getId() == salle.getId();
  }   
}
