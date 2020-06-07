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
import modele.Cours;
import modele.Utilisateur;

/**
 *
 * @author noork
 */
public class CoursDAO extends DAO<Cours> {
  public CoursDAO(Connection conn) throws SQLException {
    super(conn);
  }

  public boolean create(Cours obj, Connection conn) throws SQLException {
      //String sql = " INSERT INTO students(Nom, Prenom,Email) VALUES(�Merkel�, �Angela�, �angela.merkel@germany.de�) " ;
      String sql = "INSERT INTO cours(ID,Nom) VALUES ('" + obj.getId()+"','"+ obj.getNom();
       conn.createStatement().executeUpdate(sql) ;
  return false;
}

public boolean delete(Cours obj, Connection conn) throws SQLException {
  String sql = " DELETE FROM cours WHERE Nom=�"+ obj.getNom() +"'";
  conn.createStatement().executeUpdate(sql) ;

  return false;
}
 
//ON ASSOCIE LE NOM DE DROIT DU TRAVAIL QUAND ID=3
public boolean update(Cours obj, Connection conn) throws SQLException {
  String sql = "UPDATE cours SET Nom ='Droit du travail� WHERE"+ obj.getId() +"=3";
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
          rs = stDAO(conn).executeQuery("select * from cours");
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
  public Cours find(int id) {
    Cours cours = new Cours();  

    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
     ResultSet result = st.executeQuery("SELECT * FROM cours WHERE ID = " + id);
        if(result.first())
          cours = new Cours(id, result.getString("Nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return cours;
  }
  
    public static Cours find(int id, Connection conne) {
Cours cours = new Cours();  

    try {
        Statement st = conne.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
     ResultSet result = st.executeQuery("SELECT * FROM cours WHERE ID = " + id);
        if(result.first())
          cours = new Cours(id, result.getString("Nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return cours;    }
}