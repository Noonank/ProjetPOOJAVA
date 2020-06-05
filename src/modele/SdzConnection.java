/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author noork
 */
public class SdzConnection{
/**
     * URL de connection
     */
    private static String url = "jdbc:mysql://localhost:3306/prj_poojava";
     /**
     * Nom du user
     */
    private static String user = "root";
    /**
     * Mot de passe du user
     */
    private static String passwd = "";
    /**
     * Objet Connection
     */
    private static Connection connect;
    /**
     * Méthode qui va retourner notre instance
     * et la créer si elle n'existe pas...
     * @return
    
     * @return  */
    public static Connection getInstance() throws ClassNotFoundException{
       if(connect == null){
           try {
               
                Class.forName("com.mysql.jdbc.Driver");
               connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
            }
        }
       return connect;
    } 
}