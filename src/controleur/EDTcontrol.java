/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import DAO.CoursDAO;
import DAO.EtudiantDAO;
import DAO.SeanceDAO;
import DAO.Seance_groupeDAO;
import DAO.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.JButton;
import modele.Button;
import modele.Cours;
import modele.Enseignant;
import modele.Etudiant;
import modele.Groupe;
import modele.Salle;
import modele.Seance;
import static modele.Seance.isBetween;
import modele.Seance_enseignant;
import modele.Seance_groupe;
import modele.Seance_salle;
import modele.Site;
import modele.Type_cours;
import modele.Utilisateur;
import vue.EDT;
import vue.Login;


/**
 *
 * @author noork
 */
public class EDTcontrol {

    public static void remplissageEDT(Utilisateur util,Connection conne) {
        System.out.println("nous avons repurer les données suivante:"+util.getEmail()+";"+util.getNom());
        int id_util = util.getId();
        System.out.println("#######"+id_util);
        Etudiant etud = EtudiantDAO.find( id_util,conne);
        int etud_id_grp = etud.getid_grp();
        System.out.println("###---------####"+etud_id_grp);
        Seance_groupe seance_grp = Seance_groupeDAO.findgrp(etud_id_grp,conne);
        int util_seance = seance_grp.getIdSeance();
        System.out.println("###----seancetamer----####"+util_seance);
        Seance ensemblecours = SeanceDAO.find(util_seance,conne);
        System.out.println("inshalla ca marche"+ensemblecours.getHeureDebut());
                System.out.println("inshalla ca date ptn de merdere "
                        + "marche"+ensemblecours.getDate());

    }

    public static void remplissageEDT1(Utilisateur util, Connection conne, EDT edtmain) throws ParseException, SQLException {
        System.out.println("nous avons repurer les données suivante:"+util.getEmail()+";"+util.getNom());
        int id_util = util.getId();
        System.out.println("#######"+id_util);
        Etudiant etud = EtudiantDAO.find( id_util,conne);
        int etud_id_grp = etud.getid_grp();
        System.out.println("###---------####"+etud_id_grp);
        
        
        //int len = Seance_groupeDAO.SizeTabsta(conne);
        //System.out.println("tien la taille du truc wsh "+len);
        //for(int i = 1; i < len+1; i++)
        ResultSet rs = conne.createStatement().executeQuery("SELECT * FROM seance_groupes WHERE ID_groupe = "+etud_id_grp);

        while(rs.next()){
        Seance_groupe seance_grp = new Seance_groupe(rs.getInt("ID_seance"),etud_id_grp);       
    
        //Seance_groupe seance_grp = Seance_groupeDAO.findgrp(etud_id_grp,conne);
        int util_seance = seance_grp.getIdSeance();
        System.out.println("###----seancetamer----####"+util_seance);
        Seance ensemblecours = SeanceDAO.find(util_seance,conne);
        System.out.println("inshalla ca marche"+ensemblecours.getHeureDebut());
                System.out.println("inshalla ca date      "+ensemblecours.getSemaine()+"    ptn de merdere "
                        + "marche"+ensemblecours.getDate()+"--------"+ensemblecours.getEtat()+"("
                +"--------"+ensemblecours.getIdCours()+")"); 
        int idcour = ensemblecours.getIdCours();
        
        System.out.println("###---- idenitificant du cours ----####"+idcour);
        Cours cours = CoursDAO.find(idcour,conne);
        Utilisateur prof =  recupdataProf(ensemblecours,conne);
        System.out.println("###--[[[[[[[[[[[-- cours ----####"+prof.getNom());
        Groupe grp = recupdatagroupe(ensemblecours,conne);
        
        System.out.println("###---- groupe sa mer ----####"+grp.getNom());
        rangement(conne,ensemblecours,edtmain,cours,prof,grp);
        }
        
    }

      public static void rangement(Seance seance,EDT edtmain,Cours cours) throws ParseException{

        if (seance.getDate().compareTo(Seance.ConverterDS("2020-06-08"))==0){
            if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(8,30,00), LocalTime.of(10,00,00))== true){
                edtmain.jButton1A.setText(cours.getNom());
                
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(10,15,00), LocalTime.of(11,45,00))== true){
                edtmain.jButton1B.setText(cours.getNom());
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(12, 00,00), LocalTime.of(13,30,00))== true){
                edtmain.jButton1C.setText(cours.getNom());
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(13,45,00), LocalTime.of(15,15,00))== true){
                edtmain.jButton1D.setText(cours.getNom());
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(15,30,00), LocalTime.of(17,00,00))== true){
                edtmain.jButton1E.setText(cours.getNom());
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(17,15,00), LocalTime.of(18,45,00))== true){
                edtmain.jButton1F.setText(cours.getNom());
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(19,00,00), LocalTime.of(20,30,00))== true){
                edtmain.jButton1G.setText(cours.getNom());
            }
           
        } else {
            
        }
        
    }
      
      public static void rangement(Connection conne, Seance seance,EDT edtmain,Cours cours,Utilisateur prof,Groupe grp ) throws ParseException{

        if (seance.getDate().compareTo(Seance.ConverterDS("2020-06-08"))==0){
            if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(8,30,00), LocalTime.of(10,00,00))== true){
                edtmain.jButton1A.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
                
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(10,15,00), LocalTime.of(11,45,00))== true){
                edtmain.jButton1B.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(12, 00,00), LocalTime.of(13,30,00))== true){
                edtmain.jButton1C.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(13,45,00), LocalTime.of(15,15,00))== true){
                edtmain.jButton1D.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(15,30,00), LocalTime.of(17,00,00))== true){
                edtmain.jButton1E.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(17,15,00), LocalTime.of(18,45,00))== true){
                edtmain.jButton1F.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(19,00,00), LocalTime.of(20,30,00))== true){
                //remplissagetext(jButton1G,conne,seance,edtmain,cours,prof,grp);
                edtmain.jButton1G.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }
           
            
        }else if (seance.getDate().compareTo(Seance.ConverterDS("2020-06-09"))==0){
            if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(8,30,00), LocalTime.of(10,00,00))== true){
                edtmain.jButton2A.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
                
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(10,15,00), LocalTime.of(11,45,00))== true){
                edtmain.jButton2B.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(12, 00,00), LocalTime.of(13,30,00))== true){
                edtmain.jButton2C.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(13,45,00), LocalTime.of(15,15,00))== true){
                edtmain.jButton2D.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(15,30,00), LocalTime.of(17,00,00))== true){
                edtmain.jButton2E.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(17,15,00), LocalTime.of(18,45,00))== true){
                edtmain.jButton2F.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(19,00,00), LocalTime.of(20,30,00))== true){
                //remplissagetext(jButton1G,conne,seance,edtmain,cours,prof,grp);
                edtmain.jButton2G.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");}
        }else if (seance.getDate().compareTo(Seance.ConverterDS("2020-06-10"))==0){
            if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(8,30,00), LocalTime.of(10,00,00))== true){
                edtmain.jButton3A.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
                
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(10,15,00), LocalTime.of(11,45,00))== true){
                edtmain.jButton3B.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(12, 00,00), LocalTime.of(13,30,00))== true){
                edtmain.jButton3C.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(13,45,00), LocalTime.of(15,15,00))== true){
                edtmain.jButton3D.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(15,30,00), LocalTime.of(17,00,00))== true){
                edtmain.jButton3E.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(17,15,00), LocalTime.of(18,45,00))== true){
                edtmain.jButton3F.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(19,00,00), LocalTime.of(20,30,00))== true){
                //remplissagetext(jButton1G,conne,seance,edtmain,cours,prof,grp);
                edtmain.jButton3G.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }
        
    }else if (seance.getDate().compareTo(Seance.ConverterDS("2020-06-11"))==0){
            if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(8,30,00), LocalTime.of(10,00,00))== true){
                edtmain.jButton4A.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
                
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(10,15,00), LocalTime.of(11,45,00))== true){
                edtmain.jButton4B.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(12, 00,00), LocalTime.of(13,30,00))== true){
                edtmain.jButton4C.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(13,45,00), LocalTime.of(15,15,00))== true){
                edtmain.jButton4D.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(15,30,00), LocalTime.of(17,00,00))== true){
                edtmain.jButton4E.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(17,15,00), LocalTime.of(18,45,00))== true){
                edtmain.jButton4F.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(19,00,00), LocalTime.of(20,30,00))== true){
                //remplissagetext(jButton1G,conne,seance,edtmain,cours,prof,grp);
                edtmain.jButton4G.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }
    }else if (seance.getDate().compareTo(Seance.ConverterDS("2020-06-12"))==0){
            if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(8,30,00), LocalTime.of(10,00,00))== true){
                edtmain.jButton5A.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
                
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(10,15,00), LocalTime.of(11,45,00))== true){
                edtmain.jButton5B.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(12, 00,00), LocalTime.of(13,30,00))== true){
                edtmain.jButton5C.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(13,45,00), LocalTime.of(15,15,00))== true){
                edtmain.jButton5D.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(15,30,00), LocalTime.of(17,00,00))== true){
                edtmain.jButton5E.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(17,15,00), LocalTime.of(18,45,00))== true){
                edtmain.jButton5F.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(19,00,00), LocalTime.of(20,30,00))== true){
                //remplissagetext(jButton1G,conne,seance,edtmain,cours,prof,grp);
                edtmain.jButton5G.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }
    }else if (seance.getDate().compareTo(Seance.ConverterDS("2020-06-13"))==0){
            if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(8,30,00), LocalTime.of(10,00,00))== true){
                edtmain.jButton6A.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
                
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(10,15,00), LocalTime.of(11,45,00))== true){
                edtmain.jButton6B.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(12, 00,00), LocalTime.of(13,30,00))== true){
                edtmain.jButton6C.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(13,45,00), LocalTime.of(15,15,00))== true){
                edtmain.jButton6D.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(15,30,00), LocalTime.of(17,00,00))== true){
                edtmain.jButton6E.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(17,15,00), LocalTime.of(18,45,00))== true){
                edtmain.jButton6F.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(19,00,00), LocalTime.of(20,30,00))== true){
                //remplissagetext(jButton1G,conne,seance,edtmain,cours,prof,grp);
                edtmain.jButton6G.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }
        }else if (seance.getDate().compareTo(Seance.ConverterDS("2020-06-14"))==0){
            if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(8,30,00), LocalTime.of(10,00,00))== true){
                edtmain.jButton7A.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
                
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(10,15,00), LocalTime.of(11,45,00))== true){
                edtmain.jButton7B.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(12, 00,00), LocalTime.of(13,30,00))== true){
                edtmain.jButton7C.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(13,45,00), LocalTime.of(15,15,00))== true){
                edtmain.jButton7D.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(15,30,00), LocalTime.of(17,00,00))== true){
                edtmain.jButton7E.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(17,15,00), LocalTime.of(18,45,00))== true){
                edtmain.jButton7F.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }else if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(19,00,00), LocalTime.of(20,30,00))== true){
                //remplissagetext(jButton1G,conne,seance,edtmain,cours,prof,grp);
                edtmain.jButton7G.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
            }
        }

      /*
      public static void remplissagetext(Button jButton1A, Connection conne, Seance seance,EDT edtmain,Cours cours,Utilisateur prof,Groupe grp ){
          
          edtmain.jButton1A.setText("<html><center>"+cours.getNom()+"-"+recupdatatypecours(seance,conne)
                        +"<br>"+prof.getNom()+"<br>"+grp.getNom()+"<br>"
                        +recupdatasalle(seance,conne).getNom()+"-"
                        +recupdatasite(recupdatasalle(seance,conne),conne)
                        +"("+recupdatasalle(seance,conne).getCapacite()+")"+"<html>");
        */    
      }
    /**
     *
     */

   
    /**
     *
     * @param seance
     * @param conne
     * @return
     */
    public static Utilisateur recupdataProf(Seance seance, Connection conne){
        
        Seance_enseignant se = Seance_enseignantDAO.find(seance.getIdSeance(), conne);
        Utilisateur profdata = UtilisateurDAO.find( se.getIdEnseignant(),conne);
        
        return profdata;
      }
    
    /**
     *
     */
    public static String recupdatatypecours(Seance seance, Connection conne){
        int idtype = seance.getIdType();
        Type_cours typc = Type_coursDAO.find(idtype,conne);
        return typc.getNom();
      }
    
    public static Groupe recupdatagroupe(Seance seance, Connection conne) throws SQLException{
        
        System.out.println("je susi dans la fct recup data"+seance.getIdSeance());
        Seance_groupe SG = Seance_groupeDAO.findsea(seance.getIdSeance(), conne);
        System.out.println(SG.getIdGroupe());
        Groupe grp = GroupeDAO.find(SG.getIdGroupe(),conne);
        return grp;
      }
    
    public static Salle recupdatasalle(Seance seance, Connection conne){
        Seance_salle seancesalle = Seance_salleDAO.find(seance.getIdSeance(), conne);
        Salle salle = SalleDAO.find(seancesalle.getIdSalle(),conne);
        return salle;
      }
    
    public static String recupdatasite(Salle salle, Connection conne){
        int idsite = salle.getIdSite();
        Site site = SiteDAO.find(idsite,conne);
        return site.getNom();
      }
    
    
    /*
    public boolean remplissageEDT(){
        
        return false;
        
    }*/

    public void rangement(Seance seance) throws ParseException{

        if (seance.getDate().compareTo(Seance.ConverterDS("2020-06-08"))==0){
            if (isBetween(seance.getHeureDebut().toLocalTime(), LocalTime.of(8, 30,00), LocalTime.of(10, 00,10))== true){
             }
        } else {
            
        }
        
    }
    
    
    public static void main(String[] args) {
        //Login login = new Login();
         
    }

    public EDTcontrol() {
        //this.util =new Utilisateur;
    }

    
}
