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
import modele.Site;
import modele.Utilisateur;

/**
 *
 * @author noork
 */
public class SiteDAO extends DAO<Site> {
  public SiteDAO(Connection conn) throws SQLException {
    super(conn);
  }

 public boolean create(Site obj, Connection conn) throws SQLException {
      //String sql = " INSERT INTO students(Nom, Prenom,Email) VALUES(�Merkel�, �Angela�, �angela.merkel@germany.de�) " ;
      String sql = "INSERT INTO site(ID_site,Nom) VALUES ('" + obj.getId()+"','"+ obj.getNom();
       conn.createStatement().executeUpdate(sql) ;
  return false;
}

public boolean delete(Site obj, Connection conn) throws SQLException {
  String sql = " DELETE FROM site WHERE Nom=�"+ obj.getNom() +"'";
  conn.createStatement().executeUpdate(sql) ;

  return false;
}
 

//on associe Eiffel2 quand l'ID du site est 2
public boolean update(Site obj, Connection conn) throws SQLException {
  String sql = "UPDATE site SET Nom ='Eiffel2� WHERE"+ obj.getId() +"=2";
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
          rs = stDAO(conn).executeQuery("select * from site");
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
  public Site find(int id) {
    Site site = new Site();  

    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
     ResultSet result = st.executeQuery("SELECT * FROM site WHERE ID_site = " + id);
        if(result.first())
          site = new Site(id, result.getString("Nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return site;
  }
  
  public static Site find(int id, Connection conne) {
    Site site = new Site();  

    try {
        Statement st = conne.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
     ResultSet result = st.executeQuery("SELECT * FROM site WHERE ID_site = " + id);
        if(result.first())
          site = new Site(id, result.getString("Nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return site;

  }

    @Override
    public boolean create(Site obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Site obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Site obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}