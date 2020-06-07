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
import modele.Type_cours;
import modele.Utilisateur;

/**
 *
 * @author noork
 */
public class Type_coursDAO extends DAO<Type_cours> {
  public Type_coursDAO(Connection conn) throws SQLException {
    super(conn);
  }

  public boolean create(Type_cours obj, Connection conn) throws SQLException {
      //String sql = " INSERT INTO students(Nom, Prenom,Email) VALUES(�Merkel�, �Angela�, �angela.merkel@germany.de�) " ;
      String sql = "INSERT INTO type_cours (ID,Nom) VALUES ('" + obj.getId()+"','"+ obj.getNom();
       conn.createStatement().executeUpdate(sql) ;
  return false;
}

public boolean delete(Type_cours obj, Connection conn) throws SQLException {
  String sql = " DELETE FROM type_cours  WHERE Nom=�"+ obj.getNom() +"'";
  conn.createStatement().executeUpdate(sql) ;

  return false;
}
 
//ON UPDATE interactif PAR CI Interactif
public boolean update(Type_cours obj, Connection conn) throws SQLException {
  String sql = "UPDATE type_cours SET Nom ='CI Cours Interactif� WHERE"+ obj.getId() +"=1";
  conn.createStatement().executeUpdate(sql) ;
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
          rs = stDAO(conn).executeQuery("select * from type_cours");
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
   

  @Override
  public Type_cours find(int id) {
    Type_cours cours = new Type_cours();  

    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
     ResultSet result = st.executeQuery("SELECT * FROM type_cours WHERE ID = " + id);
        if(result.first())
          cours = new Type_cours(id, result.getString("Nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return cours;
  }
  
    public static Type_cours find(int id, Connection conne) {
    Type_cours tpc = new Type_cours();
        try {
        Statement st = conne.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
     ResultSet result = st.executeQuery("SELECT * FROM type_cours WHERE ID = " + id);
      if(result.first())
        tpc = new Type_cours(id, result.getString("Nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return tpc;
    }

    @Override
    public boolean create(Type_cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Type_cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Type_cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}