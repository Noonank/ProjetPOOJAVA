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
import modele.Salle;

/**
 *
 * @author noork
 */
public class SalleDAO extends DAO<Salle> {
  public SalleDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Salle obj) {
    return false;
  }

  public boolean delete(Salle obj) {
    return false;
  }
   
  public boolean update(Salle obj) {
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
          rs = stDAO(conn).executeQuery("select * from salle");
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
   
  
  public Salle find(int id) {
    Salle salle = new Salle();            
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM salle WHERE ID = " + id); 

      if(result.first()){
        salle = new Salle(id, 
                result.getString("Nom"),
                result.getInt("Capacite"),
                result.getInt("ID_site"));

        /*EnseignantDAO profDao = new EnseignantDAO(this.connect);

        while(result.next())             
          salle.addEnseignant(profDao.find(result.getInt("prof_id")));

        EtudiantDAO etudiantDao = new EtudiantDAO(this.connect);
        result = this.connect.createStatement().executeQuery(
          "SELECT elv_id, elv_nom, elv_prenom FROM etudiant " +
          "INNER JOIN salle ON elv_cls_k = cls_id AND cls_id = " + id
        );

        while(result.next())
          salle.addEtudiant(etudiantDao.find(result.getInt("etd_id")));
     */ }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return salle;
  }
  
    public static Salle find(int id, Connection conne) {
    Salle salle = new Salle();            
    try {
        Statement st = conne.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM salle WHERE ID = " + id); 

      if(result.first()){
        salle = new Salle(id, 
                result.getString("Nom"),
                result.getInt("Capacite"),
                result.getInt("ID_site"));

        }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return salle;
  }
}
