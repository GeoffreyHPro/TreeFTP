package sr1;

import sr1.commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import sr1.arbre.*;

public class CommandManager {
  
  /** Les deux sockets nécessaires au fonctionnement de du client FTP:
  - la socket de commandes 
  - la socket de données 
  */  
  private Repertoire r;
  private SocketCommandes s1;
  private HashMap<String,Commandes> listCommands; 

  private ArrayList<Element> actualList; 
  
  
  /**
   * Le constructeur permet de créer toutes les commandes FTP et de créer le répertoire
   * qui est utilisé pour afficher la commande tree
   * @param adress
   * @throws Exception
   */
  public CommandManager(String adress)throws Exception{
    r = new Repertoire();
    listCommands = new HashMap<String,Commandes>();
    
    
    this.s1 = new SocketCommandes(adress, 21);
    
    

    /* Création de toutes les commandes*/
    listCommands.put("Connexion",new Connexion(this.s1));
    listCommands.put("User",new User(this.s1));
    listCommands.put("Pass",new Pass(this.s1));
    listCommands.put("Pwd",new Pwd(this.s1));
    listCommands.put("Cwd",new Cwd(this.s1));
    listCommands.put("Pasv",new Pasv(this.s1));
    listCommands.put("List",new List(this.s1));

    commandFTP("Connexion","");
    
    
  }  
  /**
   * Fonction qui permet de se connecter au serveur FTP
   * @param username
   * @param password
   * @throws ExceptionUser
   * @throws ExceptionPass
   */
  public void login(String username, String password)throws ExceptionUser,ExceptionPass{
     
      commandFTP("User", username);
      commandFTP("Pass", password);
    
  }
  
  /**
   * Fonction qui permet l'appel de tous les commandes FTP
   * @param s 
   * @param param
   */
  private void commandFTP(String s, String param){
      Commandes c = listCommands.get(s);
      command(c, param);
      if(!(s1.connected())){
        s1.reconnect();
      } 
      c.execute();
      if(c instanceof List){
        List c2 = (List) c;
        this.actualList = c2.getlistElement();  
      }
  }

  /**
   * Fonction qui permet l'affichage de la commande tree
   * @param i
   */
  public void tree(int i){
    
    commandFTP("List","");
    
    Iterator it = this.actualList.iterator();
    while(it.hasNext()){
      abstractElement el = (abstractElement) it.next();
      r.addElement(el);
      
      parcoursArbre(i-1,el,"/" + el.getName());
      
    }

    r.affichage();
  
  }

  public String json(){
    return r.json();
  }

  /**
   * Fonction qui parcours tout le répertoire élément par élément
   * @param i
   * @param el
   * @param chemin
   */
  private void parcoursArbre(int i, abstractElement el,String chemin){
    try{
    if(i > 0 ){
      if(el instanceof Dossier){
        Dossier d = (Dossier) el;

        commandFTP("Cwd", chemin);
        commandFTP("List", "");
        Iterator it = this.actualList.iterator();
        if(this.actualList.size() !=0){
        while(it.hasNext()){
          abstractElement e = (abstractElement) it.next();
          d.addElement(e);
          parcoursArbre(i-1, e, chemin + "/" + e.getName()); 
               
        }
        }
      }
      
    }
    }catch (Exception e) {
      
    }
    
  }

  /**
   * Fonction qui permet d'associer le parametre param a une commande qui
   * hérite de la classe CommandWithParam.
   * Permet donc de traiter toutes les commandes qui ont besoin d'un parametre
   * @param c
   * @param param
   */
  private void command(Commandes c, String param){
    
    if (c instanceof CommandWithParam){
      CommandWithParam c2 = (CommandWithParam) c;
      c2.setParam(param);   
    }
  }
}