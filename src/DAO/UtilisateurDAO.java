/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Utilisateur;

/**
 *
 * @author noork
 */
public class UtilisateurDAO extends DAO<Utilisateur> {
  public UtilisateurDAO(Connection conn) throws SQLException {
    super(conn);
  }
  

  @Override
  public boolean create(Utilisateur obj) {
    return false;
  }

  @Override
  public boolean delete(Utilisateur obj) {
    return false;
  }
   
  @Override
  public boolean update(Utilisateur obj) {
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
          rs = stDAO(conn).executeQuery("select * from utilisateur");
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
  public Utilisateur find(int id) {
    Utilisateur utilisateur = new Utilisateur();      
      
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
        ResultSet result = st.executeQuery("SELECT * FROM utilisateur WHERE ID = " + id);
      if(result.first()){
        utilisateur = new Utilisateur(
          id,
          result.getString("Email"),
          result.getString("Password"),
          result.getString("Nom"),
          result.getString("Prenom"),
          result.getInt("Droit")); }        
    } catch (SQLException e) {
    }
    return utilisateur;
  }
}