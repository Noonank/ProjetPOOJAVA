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
import modele.Utilisateur;

/**
 *
 * @author noork
 */
public class GroupeDAO extends DAO<Groupe> {
	  public GroupeDAO(Connection conn) throws SQLException {
	    super(conn);
	  }

  public boolean create(Groupe obj, Connection conn) throws SQLException {
      //String sql = " INSERT INTO students(Nom, Prenom,Email) VALUES(‘Merkel’, ‘Angela’, ‘angela.merkel@germany.de’) " ;
      String sql = "INSERT INTO groupe(ID,Nom,ID_promotion) VALUES ('" + obj.getId()+"','"+ obj.getNom()+"','"+ obj.getIdPromo();
       conn.createStatement().executeUpdate(sql) ;
  return false;
}

public boolean delete(Groupe obj, Connection conn) throws SQLException {
  String sql = " DELETE FROM groupe WHERE Nom=’"+ obj.getNom() +"'";
  conn.createStatement().executeUpdate(sql) ;

  return false;
}

//ON AFFECTE LA PROMO 2023 AUX ELEVES DU TD06
public boolean update(Groupe obj, Connection conn) throws SQLException {
  String sql = "UPDATE groupe SET ID_promotion ='2023’ WHERE"+ obj.getNom() +"=TD06";
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
        result.getInt("ID_Promotion")); }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return groupe;
  }



	@Override
	public boolean create(Groupe obj) {
	    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	@Override
	public boolean delete(Groupe obj) {
	    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	@Override
	public boolean update(Groupe obj) {
	    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}