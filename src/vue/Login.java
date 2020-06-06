/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import DAO.DAO;
import DAO.UtilisateurDAO;
import modele.Utilisateur;
import modele.SdzConnection;

/**
 *
 * @author noork
 */
import javax.swing.*;
//package com.swing.examples;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modele.SdzConnection;
import modele.Utilisateur;

public class Login extends JFrame implements ActionListener {

    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;

    Login() {
        
        // User Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        
        // Password

        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();

        // Submit

        submit = new JButton("SUBMIT");

        panel = new JPanel(new GridLayout(3, 1));

        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(1000, 540);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        DAO<Utilisateur> UtilisateurDao;
        try {
            UtilisateurDao = new UtilisateurDAO(SdzConnection.getInstance());
            String userName = userName_text.getText();
        String password = password_text.getText();
        int len = UtilisateurDao.SizeTab(SdzConnection.getInstance());
        Utilisateur util = null ;
        while (util==null){
         util = UtilisateurDao.find(userName,password);
        }       
        System.out.println("Utilisateur N°" + util.getId() + "  - " + util.getNom()+ "  - " + util.getPrenom()+ "  - " + util.getDroit());
        
        switch (util.getDroit()){
            case 1:
                message.setText(" Hello admin");
                this.setVisible(false);
        Graphique chart = new Graphique("Emploi du temps ECE Paris 2019/2020",
		"Emploi du temps ECE Paris 2019/2020");
	chart.pack();
	chart.setVisible(true);
            case 2: 
                message.setText(" Hello responsable");
                this.setVisible(false);
        Graphique chart2 = new Graphique("Emploi du temps ECE Paris 2019/2020",
		"Emploi du temps ECE Paris 2019/2020");
	chart2.pack();
	chart2.setVisible(true);
            case 3: 
                message.setText(" Hello prof");
                this.setVisible(false);
        Graphique chart3 = new Graphique("Emploi du temps ECE Paris 2019/2020",
		"Emploi du temps ECE Paris 2019/2020");
	chart3.pack();
	chart3.setVisible(true);
            case 4:
                message.setText(" Hello eleve");
                this.setVisible(false);
        Graphique chart4 = new Graphique("Emploi du temps ECE Paris 2019/2020",
		"Emploi du temps ECE Paris 2019/2020");
	chart4.pack();
	chart4.setVisible(true);
        }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

}
