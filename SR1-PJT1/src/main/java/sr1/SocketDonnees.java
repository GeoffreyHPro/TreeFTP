package sr1;


import sr1.arbre.*;

import java.io.IOException;
import java.util.ArrayList;

public class SocketDonnees extends SocketClient {

    public SocketDonnees(String IPAdress, int port)throws Exception{
      super(IPAdress,port);
        
    }
    /**
     * Fonction qui permet de traiter toutes les donnnées recus par la commande LIST,
     * ligne par ligne on récupere le type de l'élément et son nom. 
     * @return
     * @throws IOException
     */
    public ArrayList<Element> list() throws IOException{
      ArrayList<Element> elements = new ArrayList<>();
      String line;
      while ((line = this.reader.readLine()) != null){
        Element el = changeStringToElement(line);
        if(el != null){
          elements.add(el);
        }
      } 
      
      return elements;
    }
    /**
     * Fonction qui permet de changer le type d'un element(Dossier, Fichier ...)
     * en sa classe associé 
     * @param info
     * @return
     */
    public Element changeStringToElement(String info){
      String nom = getName(info);
      
      switch(info.substring(0, 1)){
        case "d":
          return new Dossier(nom);
        case "-":
          return new Fichier(nom);
        case "l":
          return new Lien(nom);
        default:
          return null;
      }
    }
    /**
     * Fonction qui permet de récupérer le nom d'un element 
     * @param info
     * @return
     */
    public String getName(String info){
      String[] tab = info.split("\\s+");   //permet de gérer les multiples espaces
      if((tab[tab.length-2]).equals("->")){
        return tab[tab.length-3]; 
      }
      return tab[tab.length-1];
    }

}
