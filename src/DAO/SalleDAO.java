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
import modele.Utilisateur;

/**
 *
 * @author noork
 */
public class SalleDAO extends DAO<Salle> {
  public SalleDAO(Connection conn) throws SQLException  {
    super(conn);
  }

  public boolean create(Salle obj, Connection conn) throws SQLException {
      //String sql = " INSERT INTO students(Nom, Prenom,Email) VALUES(‘Merkel’, ‘Angela’, ‘angela.merkel@germany.de’) " ;
      String sql = "INSERT INTO salle(ID,Nom,Capacite,ID_site) VALUES ('" + obj.getId()+"','"+ obj.getNom()+"','"+ obj.getCapacite()+"','"+ obj.getIdSite();
       conn.createStatement().executeUpdate(sql) ;
  return false;
}

public boolean delete(Salle obj, Connection conn) throws SQLException {
  String sql = " DELETE FROM salle WHERE ID_site=’"+ obj.getIdSite() +"'";
  conn.createStatement().executeUpdate(sql) ;

  return false;
}
 

//LA SALLE EST ASSOCIEE AU SITE 1 QUAND ELLE APPARTIENT A EM
public boolean update(Salle obj, Connection conn) throws SQLException {
  String sql = "UPDATE salle SET ID_site ='1’ WHERE"+ obj.getNom() +"=EM009";
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
                result.getInt("ID_site"));}
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return salle;
  }
  
  @Override
  public boolean create(Salle obj) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean delete(Salle obj) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean update(Salle obj) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}

