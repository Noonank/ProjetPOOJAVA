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
import modele.Seance_salle;

/**
 *
 * @author noork
 */
public class Seance_salleDAO extends DAO<Seance_salle> {
  public Seance_salleDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Seance_salle obj) {
    return false;
  }

  public boolean delete(Seance_salle obj) {
    return false;
  }
   
  public boolean update(Seance_salle obj) {
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
          rs = stDAO(conn).executeQuery("select * from seance_salleDAO");
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
   
  
  public Seance_salle find(int id) {
    Seance_salle seance_salleDAO = new Seance_salle();            
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM seance_salleDAO WHERE ID_seance = " + id); 

      if(result.first()){
        seance_salleDAO = new Seance_salle(id, 
                result.getInt("ID_salle"));

        /*EnseignantDAO profDao = new EnseignantDAO(this.connect);

        while(result.next())             
          seance_salleDAO.addEnseignant(profDao.find(result.getInt("prof_id")));

        EtudiantDAO etudiantDao = new EtudiantDAO(this.connect);
        result = this.connect.createStatement().executeQuery(
          "SELECT elv_id, elv_nom, elv_prenom FROM etudiant " +
          "INNER JOIN seance_salleDAO ON elv_cls_k = cls_id AND cls_id = " + id
        );

        while(result.next())
          seance_salleDAO.addEtudiant(etudiantDao.find(result.getInt("etd_id")));
     */ }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_salleDAO;
  }
  
    public static Seance_salle find(int id, Connection conne) {
    Seance_salle seance_salleDAO = new Seance_salle();            
    try {
        Statement st = conne.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM seance_salle WHERE ID_seance = " + id); 

      if(result.first()){
        seance_salleDAO = new Seance_salle(id, 
                result.getInt("ID_salle"));

        }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_salleDAO;
  }
}
