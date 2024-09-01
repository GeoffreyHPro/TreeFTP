package sr1;

import java.util.Scanner;

import sr1.commands.ExceptionPass;
import sr1.commands.ExceptionUser;
import sr1.fichier.Json;

public class ClientFtp {
  
  private CommandManager cm;
  private Json file;

  public ClientFtp(){  
  } 
  /**
   * Fonction qui permet la connexion à un serveur FTP avec le parametre donné.
   * Ce parametre est l'adresse du serveur.
   * @param adress
   */
  public void Connexion(String adress){
    try{
      cm = new CommandManager(adress);
    }catch(Exception e){
      System.out.println("---ERREUR---\nMauvaise adresse du serveur !!!");
      Scanner s = new Scanner(System.in);
      System.out.println("Veuillez entrer une nouvelle adresse : ");
      
      Connexion(s.nextLine());
      
    }    
  }

  public void login(String username,String password){
    try {
      cm.login(username, password);
    }catch(ExceptionUser e){
    }catch(ExceptionPass e){
    }
  }
  /**
   * Permet l'affichage de la commande Tree
   * le parametre représente la profondeur de l'arbre
   * @param i
   */
  public void tree(int i){
    cm.tree(i);
  }
  /**
   * Fonction qui permet de retranscrire la classe Repertoire dans un fichier JSON
   */
  public void json(){
    file = new Json("tree");
    file.write(cm.json());
  }

}
