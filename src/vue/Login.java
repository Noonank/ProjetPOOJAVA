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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import modele.SdzConnection;
import modele.Utilisateur;

public class Login extends JFrame implements ActionListener {

    JPanel panel;
    JLabel user_label, password_label, message, accueil_label;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;

    public Login() {
        
        // User Label
        user_label = new JLabel();
        user_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
        user_label.setText("Email");
        userName_text = new JTextField();
        userName_text.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        // Password
        password_label = new JLabel();
        password_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
        password_label.setText("Password");
        password_text = new JPasswordField();
        password_text.setFont(new Font("Tahoma", Font.PLAIN, 13));

        // Submit
        submit = new JButton("Connexion");
        submit.setFont(new Font("Tahoma", Font.BOLD, 13));

        panel = new JPanel();
        panel.setBackground(new Color(230, 230, 250));
        
        message = new JLabel();

        accueil_label = new JLabel();
        accueil_label.setFont(new Font("Tahoma", Font.BOLD, 19));
        
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);
        panel.add(message);
        panel.add(submit);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        
        
        
        // Adding the listeners to components..
        submit.addActionListener(this);
        getContentPane().add(panel, BorderLayout.WEST);
        
        JLabel password_label = new JLabel("Password");
        password_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        accueil_label = new JLabel("Veuillez vous connecter s'il vous plait");
        accueil_label.setFont(new Font("Tahoma", Font.BOLD, 19));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addComponent(message, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_panel.createSequentialGroup()
        					.addGap(208)
        					.addComponent(submit, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel.createSequentialGroup()
        					.addGap(136)
        					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(accueil_label, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addGroup(gl_panel.createSequentialGroup()
        							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
        								.addComponent(user_label, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        								.addComponent(password_label))
        							.addGap(18)
        							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(password_text, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        								.addComponent(userName_text, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))))))
        			.addContainerGap(130, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(24)
        			.addComponent(accueil_label)
        			.addGap(37)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(userName_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(user_label, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        			.addGap(15)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(password_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(password_label))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addComponent(message, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_panel.createSequentialGroup()
        					.addGap(27)
        					.addComponent(submit, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))))
        );
        
        
        submit.addActionListener(this);
        //add(panel, BorderLayout.CENTER);
        
        panel.setLayout(gl_panel);
        
        setTitle("Veuillez vous connecter s'il vous pla�t!");
        setSize(600, 300);
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
        EDT chartadmin = new EDT();
	//chart.pack();
	chartadmin.setVisible(true);
            case 2: 
                message.setText(" Hello responsable");
                this.setVisible(false);
                EDT chartrespo = new EDT();
        //Graphique chart2 = new Graphique("Emploi du temps ECE Paris 2019/2020","Emploi du temps ECE Paris 2019/2020");
	//chart2.pack();
	//chart2.setVisible(true);
            case 3: 
                message.setText(" Hello prof");
                this.setVisible(false);
                EDT chartprof = new EDT();
//Graphique chart2 = new Graphique("Emploi du temps ECE Paris 2019/2020","Emploi du temps ECE Paris 2019/2020");
	//chart2.pack();
	//chart2.setVisible(true);
            case 4:
                message.setText(" Hello eleve "+util.getPrenom());
                //this.setVisible(false);
                EDT edtmain = new EDT();
                edtmain.setVisible(true);
                        System.out.println("OUIIIIIIIIIIIIIIIIIIIUtilisateur N°" + util.getId() + "  - " + util.getNom()+ "  - " + util.getPrenom()+ "  - " + util.getDroit());

                
                edtmain.wlcm.setText("Welcome<"+util.getPrenom()+">");
                //edtmain.pack();
        //Graphique chart2 = new Graphique("Emploi du temps ECE Paris 2019/2020","Emploi du temps ECE Paris 2019/2020");
	//chart2.pack();
	//chart2.setVisible(true);
        }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

}
