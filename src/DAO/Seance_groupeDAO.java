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
import modele.Seance_groupe;

/**
 *
 * @author noork
 */
public class Seance_groupeDAO extends DAO<Seance_groupe> {
  public Seance_groupeDAO(Connection conn) {
    super(conn);
  }
  public boolean create(Seance_groupe obj, Connection conn) throws SQLException {
      String sql = "INSERT INTO seance_groupe(ID_seance,ID_groupe) VALUES ('" + obj.getIdSeance()+"','"+ obj.getIdGroupe();
       conn.createStatement().executeUpdate(sql) ;
  return false;
}

public boolean delete(Seance_groupe obj, Connection conn) throws SQLException {
  String sql = " DELETE FROM seance_groupe WHERE ID_groupe ='"+ obj.getIdGroupe() +"'";
  conn.createStatement().executeUpdate(sql) ;

  return false;
}
 
public boolean update(Seance_groupe obj, Connection conn) throws SQLException {
//    String sql = "UPDATE seance_groupe SET ID_seance ='5' WHERE"+ obj.getIdSeance() +"'";
	  String sql = "UPDATE seance_groupe SET ID_seance ='5' WHERE"+ obj.getIdSeance();
  conn.createStatement().executeUpdate(sql) ;
  return false;
}

  public boolean create(Seance_groupe obj) {
    return false;
  }

  public boolean delete(Seance_groupe obj) {
    return false;
  }
   
  public boolean update(Seance_groupe obj) {
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
          rs = stDAO(conn).executeQuery("select * from seance_groupeDAO");
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
   
  
     /**
     *https://stackoverflow.com/questions/7886462/how-to-get-row-count-using-resultset-in-java
     * @param conn
     * @return
     * @throws SQLException
     */
  public static int SizeTabsta(Connection conn){
      ResultSet rs;
      try {
          rs = conn.createStatement().executeQuery("select * from seance_groupes");
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
   
  public Seance_groupe findsea(int id) {
    Seance_groupe seance_groupeDAO = new Seance_groupe();            
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM seance_groupeDAO WHERE ID_seance = " + id); 

      if(result.first()){
        seance_groupeDAO = new Seance_groupe(id, 
                result.getInt("ID_groupe"));
}
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupeDAO;
  }
  
  public Seance_groupe findgrp(int id_grp) {
    Seance_groupe seance_groupeDAO = new Seance_groupe();            
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM seance_groupes WHERE ID_groupe = " + id_grp); 
      System.out.println("je suis la tete de bite");
      if(result.first()){
        seance_groupeDAO = new Seance_groupe( 
                result.getInt("ID_seance"),id_grp);
}
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupeDAO;
  }

   public static Seance_groupe findgrp(int id_grp, Connection conne) {
    Seance_groupe seance_groupeDAO = new Seance_groupe();
        try {
        Statement st = conne.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM seance_groupes WHERE ID_groupe = " + id_grp); 
      if(result.first())
        seance_groupeDAO = new Seance_groupe(
                result.getInt("ID_seance"),id_grp);         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupeDAO;
    }
 
      public static Seance_groupe findsea(int id, Connection conne) throws SQLException {
    Seance_groupe seance_groupeDAO = new Seance_groupe();
        try {
        Statement st = conne.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM seance_groupes WHERE ID_seance = " + id); 
      System.out.println("je suis la tete de bite");
      if(result.next()!=false){
        seance_groupeDAO = new Seance_groupe(id,
                result.getInt("ID_groupe")); }       
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupeDAO;
    }

    @Override
    public Seance_groupe find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
