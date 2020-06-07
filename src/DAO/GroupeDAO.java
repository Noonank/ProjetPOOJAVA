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
import modele.Groupe;

/**
 *
 * @author noork
 */
public class GroupeDAO extends DAO<Groupe> {
  public GroupeDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Groupe obj) {
    return false;
  }

  public boolean delete(Groupe obj) {
    return false;
  }
   
  public boolean update(Groupe obj) {
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
          rs = stDAO(conn).executeQuery("select * from groupe");
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
   
  
  public Groupe find(int id) {
    Groupe groupe = new Groupe();            
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM groupe WHERE ID = " + id); 

      if(result.first()){
        groupe = new Groupe(id, result.getString("Nom"),
        result.getInt("ID_Promotion"));

        /*EnseignantDAO profDao = new EnseignantDAO(this.connect);

        while(result.next())             
          groupe.addEnseignant(profDao.find(result.getInt("prof_id")));

        EtudiantDAO etudiantDao = new EtudiantDAO(this.connect);
        result = this.connect.createStatement().executeQuery(
          "SELECT elv_id, elv_nom, elv_prenom FROM etudiant " +
          "INNER JOIN groupe ON elv_cls_k = cls_id AND cls_id = " + id
        );

        while(result.next())
          groupe.addEtudiant(etudiantDao.find(result.getInt("etd_id")));
     */ }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return groupe;
  }





  public static Groupe find(int id, Connection conne) {
    Groupe groupe = new Groupe();            
    try {
        Statement st = conne.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM groupe WHERE ID = " + id); 

      if(result.first()){
        groupe = new Groupe(id, result.getString("Nom"),
        result.getInt("ID_Promotion"));

        /*EnseignantDAO profDao = new EnseignantDAO(this.connect);

        while(result.next())             
          groupe.addEnseignant(profDao.find(result.getInt("prof_id")));

        EtudiantDAO etudiantDao = new EtudiantDAO(this.connect);
        result = this.connect.createStatement().executeQuery(
          "SELECT elv_id, elv_nom, elv_prenom FROM etudiant " +
          "INNER JOIN groupe ON elv_cls_k = cls_id AND cls_id = " + id
        );

        while(result.next())
          groupe.addEtudiant(etudiantDao.find(result.getInt("etd_id")));
     */ }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return groupe;
  }
}

