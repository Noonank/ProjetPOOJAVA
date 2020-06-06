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
import modele.Enseignant;
import modele.Utilisateur;

/**
 *
 * @author noork
 */
public class EnseignantDAO extends DAO<Enseignant> {
  public EnseignantDAO(Connection conn) throws SQLException  {
    super(conn);
  }

  public boolean create(Enseignant obj, Connection conn) throws SQLException {
      //String sql = " INSERT INTO students(Nom, Prenom,Email) VALUES(�Merkel�, �Angela�, �angela.merkel@germany.de�) " ;
      String sql = "INSERT INTO enseignant(ID_utilisateur,ID_cours) VALUES ('" + obj.getId()+"','"+ obj.getIdCours();
       conn.createStatement().executeUpdate(sql) ;
  return false;
}

  
  //on supprime l'enseignant selon son ID_COURS
public boolean delete(Enseignant obj, Connection conn) throws SQLException {
  String sql = " DELETE FROM enseignant WHERE ID_cours=�"+ obj.getIdCours() +"'";
  conn.createStatement().executeUpdate(sql) ;

  return false;
}

 
public boolean update(Enseignant obj, Connection conn) throws SQLException {
  String sql = "UPDATE enseignant SET ID_cours ='2� WHERE"+ obj.getIdCours() +"=4";
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
          rs = stDAO(conn).executeQuery("select * from enseignant");
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
   
  
  public Enseignant find(int id) {
    Enseignant enseignant = new Enseignant();            
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM enseignant WHERE ID_utilisateur = " + id);

      if(result.first()){
        enseignant = new Enseignant(id, result.getInt("ID_cours"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return enseignant;
  }
  
  
  
  
  @Override
  public boolean create(Enseignant obj) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean delete(Enseignant obj) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean update(Enseignant obj) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
