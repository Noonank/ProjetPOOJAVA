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
import modele.Seance_enseignant;

/**
 *
 * @author noork
 */
public class Seance_enseignantDAO extends DAO<Seance_enseignant> {
  public Seance_enseignantDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Seance_enseignant obj) {
    return false;
  }

  public boolean delete(Seance_enseignant obj) {
    return false;
  }
   
  public boolean update(Seance_enseignant obj) {
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
          rs = stDAO(conn).executeQuery("select * from seance_enseignantDAO");
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
   
  
  public Seance_enseignant find(int id) {
    Seance_enseignant seance_enseignantDAO = new Seance_enseignant();            
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM seance_enseignant WHERE ID_seance = " + id); 

      if(result.first()){
        seance_enseignantDAO = new Seance_enseignant(id, 
                result.getInt("ID_enseignant"));

        /*EnseignantDAO profDao = new EnseignantDAO(this.connect);

        while(result.next())             
          seance_enseignantDAO.addEnseignant(profDao.find(result.getInt("prof_id")));

        EtudiantDAO etudiantDao = new EtudiantDAO(this.connect);
        result = this.connect.createStatement().executeQuery(
          "SELECT elv_id, elv_nom, elv_prenom FROM etudiant " +
          "INNER JOIN seance_enseignantDAO ON elv_cls_k = cls_id AND cls_id = " + id
        );

        while(result.next())
          seance_enseignantDAO.addEtudiant(etudiantDao.find(result.getInt("etd_id")));
     */ }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_enseignantDAO;
  }
  
  public static Seance_enseignant find(int id,Connection conne) {
    Seance_enseignant seance_enseignantDAO = new Seance_enseignant();            
    try {
        Statement st = conne.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM seance_enseignant WHERE ID_seance = " + id); 
System.out.println("\nSELECT * FROM seance_enseignant WHERE ID_seance = " + id);
      if(result.first()){
        seance_enseignantDAO = new Seance_enseignant(id, 
                result.getInt("ID_enseignant"));
}
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_enseignantDAO;
  }
}
