/*
 * To change this licEnse header, choose LicEnse Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import DAO.*;
import java.sql.*;
import modele.*;

/**
 *
 * @author noork
 */
public class Test { 
    private Statement st;
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
      
    //Testons des élèves
    DAO<Salle> SalleDao = new SalleDAO(SdzConnection.getInstance());
   int len = SalleDao.SizeTab(SdzConnection.getInstance());
    for(int i = 1; i < len+1; i++){
      Salle util = SalleDao.find(i);
      System.out.println("Salle N°" + util.getId() + "  - " + util.getNom()+ "  - " + util.getCapacite()+ "  - " + util.getIdSite());
    }
      
    System.out.println("\n********************************\n");
     /* 
    //Voyons voir les professeurs
    DAO<Professeur> profDao = new ProfesseurDAO(SdzConnection.getInstance());
    for(int i = 4; i < 8; i++){
      Professeur prof = profDao.find(i);
      System.out.println(prof.getNom() + " " + prof.getPrenom() + " Enseigne : ");
      for(Matiere mat : prof.getListMatiere())
        System.out.println("\t * " + mat.getNom());
    }*/
     /*
    System.out.println("\n********************************\n");
      
    //Et là, c'est la classe
    DAO<Classe> classeDao = new ClasseDAO(SdzConnection.getInstance());
    Classe classe = classeDao.find(11);
      
    System.out.println("Classe de " + classe.getNom());
    System.out.println("\nListe des élèves :");
    for(Eleve eleve : classe.getListEleve())
      System.out.println("  - " + eleve.getNom() + " " + eleve.getPrenom());
      
    System.out.println("\nListe des professeurs :");
    for(Professeur prof : classe.getListProfesseur())
      System.out.println("  - " + prof.getNom() + " " + prof.getPrenom());      
  }*/
}
}