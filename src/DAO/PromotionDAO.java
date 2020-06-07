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
import modele.Promotion;
import modele.Utilisateur;

/**
 *
 * @author noork
 */
public class PromotionDAO extends DAO<Promotion> {
  public PromotionDAO(Connection conn) throws SQLException {
    super(conn);
  }

  public boolean create(Promotion obj, Connection conn) throws SQLException {
      //String sql = " INSERT INTO students(Nom, Prenom,Email) VALUES(‘Merkel’, ‘Angela’, ‘angela.merkel@germany.de’) " ;
      String sql = "INSERT INTO promotion (ID,Nom)VALUES ('" + obj.getId()+"','"+ obj.getNom();
       conn.createStatement().executeUpdate(sql) ;
  return false;
}

public boolean delete(Promotion obj, Connection conn) throws SQLException {
  String sql = " DELETE FROM promotion  WHERE Nom=’"+ obj.getNom() +"'";
  conn.createStatement().executeUpdate(sql) ;

  return false;
}
 

//ON ASSOCIE LA PROMO 2022 à l'id 2022 (jsp si ça a vraiment de sens mdr)
public boolean update(Promotion obj, Connection conn) throws SQLException {
  String sql = "UPDATE promotion SET Nom ='2023’ WHERE"+ obj.getId() +"=2022";
  conn.createStatement().executeUpdate(sql) ;
  return false;
}


    public int SizeTab(Connection conn){
      ResultSet rs;
      try {
          rs = stDAO(conn).executeQuery("select * from promotion");
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
   


  public Promotion find(int id) {
    Promotion promotion = new Promotion();            
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
        ResultSet result = st.executeQuery("SELECT * FROM promotion WHERE ID = " + id);
      if(result.first()){
        promotion = new Promotion(
                id, 
                result.getString("Nom"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return promotion;
  }
  
  
  @Override
  public boolean create(Promotion obj) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean delete(Promotion obj) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean update(Promotion obj) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  
  
}
