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
public class Seance_groupe {
  //ID
  private int id_seance = 0;
  //ID sitetion
  private int id_groupe = 0;
  //Liste des professeurs
  private Set<Seance_groupe> listSeance_groupe = new HashSet<Seance_groupe>();
  //Liste des élèves
  private Set<Etudiant> listEtudiant = new HashSet<Etudiant>();

  public Seance_groupe(int id_seance,int id_groupe) {
    this.id_seance = id_seance;
    this.id_groupe = id_groupe;

  }
  public Seance_groupe(){}

  public int getIdSeance() {
    return id_seance;
  }

  public void setIdSeance(int id) {
    this.id_seance = id;
  }
  
  public int getIdGroupe() {
    return id_groupe;
  }

  public void setIdGroupe(int id) {
    this.id_groupe= id;
  }
  
  

  public Set<Seance_groupe> getListSeance_groupe() {
    return listSeance_groupe;
  }

  public void setListSeance_groupe(Set<Seance_groupe> listSeance_groupe) {
    this.listSeance_groupe = listSeance_groupe;
  }

  public void addSeance_groupe(Seance_groupe prof) {
    if(!listSeance_groupe.contains(prof))
      listSeance_groupe.add(prof);
  }

  public void removeSeance_groupe(Seance_groupe prof ) {
    this.listSeance_groupe.remove(prof);
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

  public boolean equals(Seance_groupe seance_grp){
    return this.getIdGroupe() == seance_grp.getIdGroupe();
  }   
}
