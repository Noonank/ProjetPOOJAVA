//2.2) Le package vue
//Le package vue contient la classe LabyConsole associée à l’IHM
//Cette classe LabyConsole contient les méthodes suivantes à compléter et screenshots des résultats à obtenir :

package vue;

import DAO.DAO;
import DAO.UtilisateurDAO;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import modele.Utilisateur;
import modele.SdzConnection;

//import projet1.LabyConsole;

public class EdtConsole{
    private Statement st;
	boolean stop;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EdtConsole accueil = new EdtConsole();
		accueil.executer();
		
	}
	
	public void executer() throws ClassNotFoundException, SQLException
	{
            //while(!stop)
		//{
                        String choix = menu();
                        System.out.println(choix);
			//proposition(choix);
		//}
	}

    /**
     * Affiche le menu composé de 3 choix : déplacement aléatoire, en profondeur DFS ou quitter le programme.
     * L’utilisateur doit saisir un choix de type int et recommencer tant qu’aucun des 3 choix proposés n’est valide,
     *  y compris si l’utilisateur saisit des caractères au lieu d’un nombre entier.
     * Il faut donc pouvoir convertir la saisie, y compris avec des caractères, en entier.
     * Dans le cas où l’utilisateur saisit des caractères autres que des chiffres, cette conversion génère
     * l’exception  NumberFormatException qu’il faut attraper pour afficher un message d’erreur,
     * tout en pouvant recommencer la saisie.
     *
     * Cette méthode retourne le choix saisi.
     *
     * @return choix
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
	
    public String menu() throws ClassNotFoundException, SQLException{
        Scanner sc = new Scanner(System.in); 
        System.out.println("\n\nBienvenue dans notre Menu");

        System.out.println("veuillez entrer votre mail ece:");
        String email = sc.nextLine();
        System.out.println("veuillez entrer votre mot de passe ece:");
        String psw = sc.nextLine();
        
        DAO<Utilisateur> UtilisateurDao = new UtilisateurDAO(SdzConnection.getInstance());
        int len = UtilisateurDao.SizeTab(SdzConnection.getInstance());
        Utilisateur util = null ;
        while (util==null){
         util = UtilisateurDao.find(email,psw);
        }       
        System.out.println("Utilisateur N°" + util.getId() + "  - " + util.getNom()+ "  - " + util.getPrenom()+ "  - " + util.getDroit());
        
        switch (util.getDroit()){
            case 1:
                return "admin";
            case 2: 
                return "charger de TD";
            case 3: 
                return "prof";
            case 4:
                return "eleve";
        }
      
    System.out.println("\n********************************\n");
        return null;
		
    }
    
    /*
    private void proposition(int choix)
    {
    	switch(choix)
    	{
    	case 0:
    	{
    		stop = true;
    		System.out.println("Vous avez fait le choix de quitter \n");
    		break;
    	}

    	case 1:
    	{
    		System.out.println("Vous avez choisi le deplacement aleatoire \n");
    		//AJOUTER FONCTION
    		    		
    		break;
    	}
    	

    	case 2:
    	{
    		System.out.println("Vous avez fait choisi le deplacement aleatoire en profondeur \n");
    		//AJOUTER FONCTION    		
    		break;
    	}
    		
    	default:
    		System.out.println("Erreur");
    	}
    }
    
    */

    /**
     * Affiche les coordonnées positionX et positionY protected de la Case c en paramètre
     *
     * @param c 
     */
    
    //    public void affiche(Case c) { ...  }
    /*
   public void affiche(Case c)
    {
	   System.out.println("Affichage des coordonnees de positionX et positionY selon Case c");
	   System.out.println("Position X =" + c.getPositionX());
	   System.out.println("Position Y =" + c.getPositionY());
    }   */
   
     /**
     * Affiche un labyrinthe en mode console en se servant des méthodes du Labyrinthe laby en paramètre :
     * afficher toutes les cases soit de CaseMur avec le caractère ‘X’, soit de CaseTrou avec le caractère ’_’
     * en se servant de instanceof pour les distinguer, soit le caractère ‘V’ si la case est visitée (voir  la méthode
     *  getVisited définie dans l’interface Case et implémentée dans la classe CaseImplementee).
     *
     * @param laby
     */
   // public void affiche(Labyrinthe laby) { … }
    
    /*
	  public void affiche(Labyrinthe laby)
	  {
		  for (int ligne = 0; ligne < laby.getTailleY(); ligne++)
		  {	
		      for (int colonne = 0; colonne < laby.getTailleX(); colonne++)
		      {
		    	  Case c = laby.getCase(ligne, colonne);
		          	if (c instanceof CaseMur)		//si c'est vrai on affiche X source pour instance of https://www.javatpoint.com/downcasting-with-instanceof-operator
		          	{
		          		System.out.print("X");
		            }
		          	
		          	else
		          	{
			            if (c.getVisited())
			            {
			            	System.out.print("V");
			            }
			            else
			            {
			            	System.out.print("_");
			            }
		            }
		      }
		      System.out.println();
	       }
	   }
    
   */
}