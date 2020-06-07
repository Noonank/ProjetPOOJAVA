/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modele.SdzConnection;
import modele.Seance;

/**
 *
 * @author noork
 */
public class SeanceDAO extends DAO<Seance> {
  public SeanceDAO(Connection conn) {
    super(conn);
  }
  
  
  
  public void remplissagetableauseance(JTable table,String ValueToSearch) throws ClassNotFoundException, SQLException{
      Connection conne = SdzConnection.getInstance();
      PreparedStatement ps;
      ps = conne.prepareStatement("SELECT * FROM `seance` WHERE CONCAT(`ID`,`Semaine`,`Etat`) LIKE ?");
      ps.setString(1,"%"+ValueToSearch+"%");
      
      ResultSet rs = ps.executeQuery();
      DefaultTableModel model = (DefaultTableModel)table.getModel();
      
      Object[] row;
      
      while(rs.next()){
          row = new Object[11];
          row[0] = rs.getInt(1);
          row[1] = rs.getString(2);
          row[2] = rs.getString(3);
          row[3] = rs.getString(4);
          row[4] = rs.getString(5);
          row[5] = rs.getString(6);
          row[6] = rs.getString(7);
          row[7] = rs.getString(8);
          
          model.addRow(row);
          
      }
      
  }

    public boolean create(char operation,
            String ID, String Semaine,String Date,String Heure_debut,String heure_fin,
            String Etat,String ID_cours,String ID_type) throws SQLException, ClassNotFoundException {
        //i for insertC
        Connection con = SdzConnection.getInstance();
        PreparedStatement ps;
        if (operation == 'i'){
            //ps = conn.prepareStatement();
            ps = con.prepareStatement ("INSERT INTO seance (ID,Semaine,Date,Heure_debut,heure_fin,Etat,ID_cours,ID_type) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1,ID);
            ps.setString(2,Semaine);
            ps.setString(3,Date);
            ps.setString(4,Heure_debut);
            ps.setString(5,heure_fin);
            ps.setString(6,Etat);
            ps.setString(7,ID_cours);
            ps.setString(8,ID_type);
            
            if (ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Une nouvelle seance à ete créer");
            }
            //conn.createStatement().executeUpdate(sql) ;
        }
        if (operation == 'u'){//update
            //ps = conn.prepareStatement();
            ps = con.prepareStatement ("UPDATE `seance` SET `Semaine`= ?,`Date`= ?,`Heure_debut`= ?,`Heure_fin`= ?,`Etat`= ?,`ID_cours`= ?,`ID_type`= ? WHERE `ID`= ?");
            ps.setString(1,ID);
            ps.setString(2,Semaine);
            ps.setString(3,Date);
            ps.setString(4,Heure_debut);
            ps.setString(5,heure_fin);
            ps.setString(6,Etat);
            ps.setString(7,ID_cours);
            ps.setString(8,ID_type);
            
            if (ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"La seance a etet modifié");
            }
            //conn.createStatement().executeUpdate(sql) ;
        }
       
  return false;
}

public boolean delete(Seance obj, Connection conn) throws SQLException {
  String sql = " DELETE FROM seance  WHERE Date ='"+ obj.getDate() +"'";
  conn.createStatement().executeUpdate(sql) ;

  return false;
}
 
public boolean update(Seance obj, Connection conn) throws SQLException {
//    String sql = "UPDATE seance SET Date ='2020-07-08' WHERE"+ obj.getDate() +"'";
	  String sql = "UPDATE seance  SET Date ='2020-07-08' WHERE"+ obj.getDate();
  conn.createStatement().executeUpdate(sql) ;
  return false;
}

  public boolean create(Seance obj) {
    return false;
  }

  public boolean delete(Seance obj) {
    return false;
  }
   
  public boolean update(Seance obj) {
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
          rs = stDAO(conn).executeQuery("select * from seance");
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
   
  
  public Seance find(int id) {
    Seance seance = new Seance();            
    try {
        Statement st = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM seance WHERE ID_seance = " + id); 

      if(result.first()){
        seance = new Seance(id, 
                result.getInt("Semaine"),
                result.getDate("Date"),
                result.getTime("Heure_debut"),
                result.getTime("Heure_fin"),
                result.getInt("Etat"),
                result.getInt("ID_cours"),
                result.getInt("ID_type"));

        /*EnseignantDAO profDao = new EnseignantDAO(this.connect);

        while(result.next())             
          seance.addEnseignant(profDao.find(result.getInt("prof_id")));

        EtudiantDAO etudiantDao = new EtudiantDAO(this.connect);
        result = this.connect.createStatement().executeQuery(
          "SELECT elv_id, elv_nom, elv_prenom FROM etudiant " +
          "INNER JOIN seance ON elv_cls_k = cls_id AND cls_id = " + id
        );

        while(result.next())
          seance.addEtudiant(etudiantDao.find(result.getInt("etd_id")));
     */ }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance;
  }
  
  public static Seance find(int id, Connection conne) {
    Seance seanceDAO = new Seance();
        try {
        Statement st = conne.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
      ResultSet result = st.executeQuery("SELECT * FROM seance WHERE ID= " + id); 
      if(result.first())
        seanceDAO = new Seance(id, 
                result.getInt("Semaine"),
                result.getDate("Date"),
                result.getTime("Heure_debut"),
                result.getTime("Heure_fin"),
                result.getInt("Etat"),
                result.getInt("ID_cours"),
                result.getInt("ID_type"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seanceDAO;
    }

}
