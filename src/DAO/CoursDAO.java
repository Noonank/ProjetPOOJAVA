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

/**
 *
 * @author noork
 */
public class CoursDAO extends DAO<Cours> {
  public CoursDAO(Connection conn) {
    super(conn);
  }
  
  public boolean create(Cours obj, Connection conn) throws SQLException {
      String sql = "INSERT INTO cours(ID,Nom) VALUES ('" + obj.getId()+"','"+ obj.getNom();
       conn.createStatement().executeUpdate(sql) ;
  return false;
}

public boolean delete(Cours obj, Connection conn) throws SQLException {
  String sql = " DELETE FROM cours WHERE Nom='" + obj.getNom() +"'";
  conn.createStatement().executeUpdate(sql) ;

  return false;
}
 
//ON ASSOCIE LE NOM DE DROIT DU TRAVAIL QUAND Nom
public boolean update(Cours obj, Connection conn) throws SQLException {
	//String sql = "UPDATE cours SET Nom ='Droit du travail' WHERE"+ obj.getNom + " "();
	String sql = "UPDATE cours SET Nom ='Droit du travail' WHERE"+ obj.getNom();
  conn.createStatement().executeUpdate(sql) ;
  return false;
}


  @Override
  public boolean create(Cours obj) {
    return false;
  }

  @Override
  public boolean delete(Cours obj) {
    return false;
  }

  @Override
  public boolean update(Cours obj) {
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