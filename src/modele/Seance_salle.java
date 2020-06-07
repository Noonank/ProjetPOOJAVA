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
public class Seance_salle {
  //ID
  private int id_seance = 0;
  //ID sitetion
  private int id_salle = 0;
  //Liste des professeurs
  private Set<Seance_salle> listSeance_salle = new HashSet<Seance_salle>();
  //Liste des élèves
  private Set<Etudiant> listEtudiant = new HashSet<Etudiant>();

  public Seance_salle(int id_seance,int id_salle) {
    this.id_seance = id_seance;
    this.id_salle = id_salle;

  }
  public Seance_salle(){}

  public int getIdSeance() {
    return id_seance;
  }

  public void setIdSeance(int id) {
    this.id_seance = id;
  }
  
  public int getIdSalle() {
    return id_salle;
  }

  public void setIdSalle(int id) {
    this.id_salle= id;
  }
  
  

  public Set<Seance_salle> getListSeance_salle() {
    return listSeance_salle;
  }

  public void setListSeance_salle(Set<Seance_salle> listSeance_salle) {
    this.listSeance_salle = listSeance_salle;
  }

  public void addSeance_salle(Seance_salle prof) {
    if(!listSeance_salle.contains(prof))
      listSeance_salle.add(prof);
  }

  public void removeSeance_salle(Seance_salle prof ) {
    this.listSeance_salle.remove(prof);
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

  public boolean equals(Seance_salle seance_salle){
    return this.getIdSalle() == seance_salle.getIdSalle();
  }   
}
