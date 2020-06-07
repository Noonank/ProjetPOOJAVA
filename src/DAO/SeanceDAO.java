/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Seance;

/**
 *
 * @author noork
 */
public class SeanceDAO extends DAO<Seance> {
  public SeanceDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Seance obj) {
    return false;
  }

  public boolean delete(Seance obj) {
    return false;
  }
   
  public boolean update(Seance obj) {
    return false;
  }

     /**
     *https://stackoverflow.com/questions/7886462/how-to-get-row-count-using-resultset-in-java
     * @param conn
     * @return
     * @throws SQLException
     */
    @Override
  public int SizeTab(Connection conn){
      ResultSet rs;
      try {
          rs = stDAO(conn).executeQuery("select * from seance");
           int size = 0;
            try {
                rs.last();
                size = rs.getRow();
                rs.beforeFirst();
            }
            catch(Exception ex) {
                return 0;
            }
            return size;
      } catch (SQLException ex) {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
      return 0;

  }
   
  
  public Seance find(int id) {
    Seance seance = new Seance();            
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM seance WHERE ID_seance = " + id); 

      if(result.first()){
        seance = new Seance(id, 
                result.getInt("Semaine"),
                result.getDate("Date"),
                result.getTime("Heure_debut"),
                result.getTime("Heure_fin"),
                result.getInt("Etat"),
                result.getInt("ID_cours"),
                result.getInt("ID_type"));

        /*EnseignantDAO profDao = new EnseignantDAO(this.connect);

        while(result.next())             
          seance.addEnseignant(profDao.find(result.getInt("prof_id")));

        EtudiantDAO etudiantDao = new EtudiantDAO(this.connect);
        result = this.connect.createStatement().executeQuery(
          "SELECT elv_id, elv_nom, elv_prenom FROM etudiant " +
          "INNER JOIN seance ON elv_cls_k = cls_id AND cls_id = " + id
        );

        while(result.next())
          seance.addEtudiant(etudiantDao.find(result.getInt("etd_id")));
     */ }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance;
  }
  
  public static Seance find(int id, Connection conne) {
    Seance seanceDAO = new Seance();
        try {
        Statement st = conne.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM seance WHERE ID= " + id); 
      if(result.first())
        seanceDAO = new Seance(id, 
                result.getInt("Semaine"),
                result.getDate("Date"),
                result.getTime("Heure_debut"),
                result.getTime("Heure_fin"),
                result.getInt("Etat"),
                result.getInt("ID_cours"),
                result.getInt("ID_type"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seanceDAO;
    }

}
