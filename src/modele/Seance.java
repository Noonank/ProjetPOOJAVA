/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author noork
 */
public class Seance {
  //ID seance
  private int id_seance = 0;
  //ID cours
  private int id_cours = 0;
  //ID type de cours
  private int id_type = 0;
  //semaine
  private int semaine = 0;
  //Etat
  private int etat = 0;
  //date
  private Date date;
  //heure debut et fin
  private Time heure_debut;
  private Time heure_fin;
  //Liste des professeurs
  private Set<Seance> listSeance = new HashSet<Seance>();
  //Liste des élèves
  private Set<Etudiant> listEtudiant = new HashSet<Etudiant>();

  public Seance(int id_seance,int semaine, Date date,Time heure_debut,Time heure_fin, int etat, int ID_cours,int ID_type) {
    this.id_seance = id_seance;
    this.id_cours = ID_cours;
    this.id_type = ID_type;
    this.semaine = semaine;
    this.etat = etat;
    this.date = date;
    this.heure_debut = heure_debut;
    this.heure_fin = heure_fin;
  }
  public Seance(){}

  public int getIdSeance() {
    return id_seance;
  }

  public void setIdSeance(int id) {
    this.id_seance = id;
  }
  
  public int getIdCours() {
    return id_cours;
  }

  public void setIdCours(int id) {
    this.id_cours= id;
  }
  
  public int getIdType() {
    return id_type;
  }

  public void setIdType(int id) {
    this.id_type= id;
  }
  
  //constructuer semaine
    public int getSemaine() {
    return semaine;
  }

  public void setSemaine(int semaine) {
    this.semaine= semaine;
  }
  //etat de la seance
    public int getEtat() {
    return etat;
  }

  public void setEtat(int etat) {
    this.etat= etat;
  }
  //date
    public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date= date;
  }
  
  //constructeur heure de debut et de fin 
    public Time getHeureDebut() {
    return heure_debut;
  }

  public void setHeureDebut(Time heure_debut) {
    this.heure_debut= heure_debut;
  }
    public Time getHeureFin() {
    return heure_debut;
  }

  public void setHeureFin(Time heure_fin) {
    this.heure_fin= heure_fin;
  }
  

  public Set<Seance> getListSeance() {
    return listSeance;
  }

  public void setListSeance(Set<Seance> listSeance) {
    this.listSeance = listSeance;
  }

  public void addSeance(Seance prof) {
    if(!listSeance.contains(prof))
      listSeance.add(prof);
  }

  public void removeSeance(Seance prof ) {
    this.listSeance.remove(prof);
  }

  public Set<Etudiant> getListEtudiant() {
    return listEtudiant;
  }

  public void setListEtudiant(Set<Etudiant> listEtudiant) {
    this.listEtudiant = listEtudiant;
  }

  //Ajoute un élève à la classe
  public void addEtudiant(Etudiant etudiant){
    if(!this.listEtudiant.contains(etudiant))
      this.listEtudiant.add(etudiant);
  }

  //Retire un élève de la classe
  public void removeEtudiant(Etudiant etudiant){
    this.listEtudiant.remove(etudiant);
  }

  public boolean equals(Seance seance){
    return this.getIdSeance() == seance.getIdSeance();
  }   
  public boolean equalsDate(Seance seance){
    return this.getDate() == seance.getDate();
  }  
  public static Date ConverterDS(String string) throws ParseException{
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    Date date = formatter.parse(string);
    return date;
  }
  public static Time ConverterTS(String string) throws ParseException{
 DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
 Time time = (Time)formatter.parse(string);
 return time;
  }
  

public static boolean isBetween(LocalTime candidate, LocalTime start, LocalTime end) {
  return !candidate.isBefore(start) && !candidate.isAfter(end);  // Inclusive.
}
}


