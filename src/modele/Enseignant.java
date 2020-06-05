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
public class Enseignant {
  //ID
  private int id = 0;
  //Nom du professeur
  private int id_cours;
  //Liste des matières dispensées
  private Set<Enseignant> listEnseignant = new HashSet<Enseignant>();

  public Enseignant(int id, int id_cours) {
    this.id = id;
    this.id_cours = id_cours;
  }

  public Enseignant(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getIdCours() {
    return id_cours;
  }

  public void setIdCours(int idcours) {
    this.id_cours = idcours;
  }

  public Set<Enseignant> getListEnseignant() {
    return listEnseignant;
  }

  public void setListEnseignant(Set<Enseignant> listEnseignant) {
    this.listEnseignant = listEnseignant;
  }

  //Ajoute une matière à un professeur
  public void addEnseignant(Enseignant enseignant){
    this.listEnseignant.add(enseignant);
  }

  //Retire une matière à un professeur
  public void removeEnseignant(Enseignant enseignant){
    this.listEnseignant.remove(enseignant);
  }
}
