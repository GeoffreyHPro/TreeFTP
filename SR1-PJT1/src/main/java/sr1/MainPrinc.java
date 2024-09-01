package sr1;

import java.io.Console;
import java.util.Scanner;


public class MainPrinc {
  public static void main(String[] args) {
    if (args.length  == 1){
      
      ClientFtp c = new ClientFtp();
      
      Scanner s = new Scanner(System.in);

      System.out.println("entrez un username");
      String user = s.nextLine();

      System.out.println("entrez un mot de passe");
      String pass = s.nextLine();
      System.out.println("entrez un entier pour la profondeur de l'arbre");
      String profondeur = s.nextLine();
      
      
      c.Connexion(args[0]);
      
      c.login(user, pass);
      
      c.tree(Integer.parseInt(profondeur));
      
      c.json();
      
       
    }else{
      System.out.println("Il n'y a pas assez de parametres");
    }    
  } 
}
