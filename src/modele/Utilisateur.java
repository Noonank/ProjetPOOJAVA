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
public class Utilisateur {
  //ID
  private int id;
  //email
  private String email="";
  //passwords
  private String psw="";
  //email
  private int droit=0;
  //Nom de l'élève
  private String nom = "";
  //Prénom de l'élève
  private String prenom = "";
   
  public Utilisateur(int id, String email,String psw,String nom, String prenom,int droit) {
    this.id = id;
    this.email = email;
    this.psw = psw;
    this.prenom = prenom;
    this.nom = nom;
    this.droit = droit;
  }
  public Utilisateur(){};

    public Utilisateur(int id, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
  public int getId() {
    return id;
    
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  public String getPsw() {
    return psw;
  }

  public void setPsw(String psw) {
    this.psw = psw;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }   
  public int getDroit() {
    return droit;
  }

  public void setDroit(int droit) {
    this.droit = droit;
  }
}