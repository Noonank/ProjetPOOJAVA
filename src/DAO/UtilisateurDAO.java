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
  
  public boolean create(Utilisateur obj, Connection conn) throws SQLException {
        //String sql = " INSERT INTO students(Nom, Prenom,Email) VALUES(‘Merkel’, ‘Angela’, ‘angela.merkel@germany.de’) " ;
        String sql = "INSERT INTO utilisateur(ID,Email,Password,Nom,Prenom,Droit) VALUES ('" + obj.getId()+"','"+ obj.getEmail()+"','"+ obj.getPsw()+"','"+ obj.getNom()+"','"+ obj.getPrenom()+"','"+ obj.getDroit();
         conn.createStatement().executeUpdate(sql) ;
    return false;
  }

  public boolean delete(Utilisateur obj, Connection conn) throws SQLException {
    String sql = " DELETE FROM utilisateur WHERE nom=’"+ obj.getNom() +"'";
    conn.createStatement().executeUpdate(sql) ;

    return false;
  }
   
  public boolean update(Utilisateur obj, Connection conn) throws SQLException {
    String sql = "UPDATE utilisateur SET Email ='emmanuel.macron@france.fr’ WHERE"+ obj.getId() +"=1";
    conn.createStatement().executeUpdate(sql) ;
    return false;
  }
  
    /**
     *https://stackoverflow.com/questions/7886462/how-to-get-row-count-using-resultset-in-java
     * @param conn
     * @return
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
  
  
  public static Utilisateur find(int id,Connection conne) {
    Utilisateur utilisateur = new Utilisateur();      
      
    try {
        Statement st = conne.createStatement(
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
  
    /**
     *
     * @param email
     * @param psw
     * @return
     */
    @Override
  public Utilisateur find(String email,String psw){
    Utilisateur utilisateur = new Utilisateur();     
      
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
        ResultSet result = st.executeQuery("SELECT * FROM utilisateur WHERE Email = '" + email + "'AND Password = '"+psw +"'");
        System.out.println(email);
      while(result.next()){
          System.out.println("SELECT * FROM utilisateur WHERE Email = '" +result.getInt("ID") + "'AND Password = '"+psw +"'");
        utilisateur = new Utilisateur(
          result.getInt("ID"),email,psw,
          result.getString("Nom"),
          result.getString("Prenom"),
          result.getInt("Droit")); 
      }//if{
          //System.out.println("Votre mail ou votre mot de passe est faut veuillez ressaisir ces informations, merci")  ;}      
    } catch (SQLException e) {
    }
    return utilisateur;
  }

    @Override
    public boolean create(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}