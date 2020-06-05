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
import modele.Etudiant;

/**
 *
 * @author noork
 */
public class EtudiantDAO extends DAO<Etudiant> {
  public EtudiantDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Etudiant obj) {
    return false;
  }

  @Override
  public boolean delete(Etudiant obj) {
    return false;
  }
   
  @Override
  public boolean update(Etudiant obj) {
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
          rs = stDAO(conn).executeQuery("select * from etudiant");
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
  public Etudiant find(int id) {
    Etudiant etudiant = new Etudiant();      
      
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
        ResultSet result = st.executeQuery("SELECT * FROM etudiant WHERE ID_utilisateur = " + id);
      if(result.first())
        etudiant = new Etudiant(
          id,
          result.getString("Numero"),
          result.getInt("ID_groupe"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return etudiant;
  }
}