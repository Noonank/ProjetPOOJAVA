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
public class Etudiant {
  //ID
  private int id_util = 0;
  //Nom de l'élève
  private String numero = "";
  //Prénom de l'élève
  private int id_grp = 0;
   
  public Etudiant(int id, String num, int id_grp) {
    this.id_util = id;
    this.numero = num;
    this.id_grp = id_grp;
  }
  public Etudiant(){};
     
  public int getId() {
    return id_util;
  }

  public void setId(int id) {
    this.id_util = id;
  }

  public String getNum() {
    return numero;
  }

  public void setNum(String num) {
    this.numero = num;
  }

  public int getid_grp() {
    return id_grp;
  }

  public void setid_grp(int id_grp) {
    this.id_grp = id_grp;
  }   
}