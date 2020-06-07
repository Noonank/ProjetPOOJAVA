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
public class Seance_enseignant {
  //ID
  private int id_seance = 0;
  //ID sitetion
  private int id_enseignant = 0;
  //Liste des professeurs
  private Set<Seance_enseignant> listSeance_enseignant = new HashSet<Seance_enseignant>();
  //Liste des élèves
  private Set<Etudiant> listEtudiant = new HashSet<Etudiant>();

  public Seance_enseignant(int id_seance,int id_enseignant) {
    this.id_seance = id_seance;
    this.id_enseignant = id_enseignant;

  }
  public Seance_enseignant(){}

  public int getIdSeance() {
    return id_seance;
  }

  public void setIdSeance(int id) {
    this.id_seance = id;
  }
  
  public int getIdEnseignant() {
    return id_enseignant;
  }

  public void setIdEnseignant(int id) {
    this.id_enseignant= id;
  }
  
  

  public Set<Seance_enseignant> getListSeance_enseignant() {
    return listSeance_enseignant;
  }

  public void setListSeance_enseignant(Set<Seance_enseignant> listSeance_enseignant) {
    this.listSeance_enseignant = listSeance_enseignant;
  }

  public void addSeance_enseignant(Seance_enseignant prof) {
    if(!listSeance_enseignant.contains(prof))
      listSeance_enseignant.add(prof);
  }

  public void removeSeance_enseignant(Seance_enseignant prof ) {
    this.listSeance_enseignant.remove(prof);
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

  public boolean equals(Seance_enseignant seance_enseignant){
    return this.getIdEnseignant() == seance_enseignant.getIdEnseignant();
  }   
}
