package sr1.arbre;

import java.util.ArrayList;
import java.util.Iterator;


public class Repertoire{
  private ArrayList<abstractElement> listElements;

  public Repertoire(){
    listElements = new ArrayList<>();
    
  }

  public void addElement(abstractElement e){
    listElements.add(e);
  }

  public ArrayList<abstractElement> getListElements() {
    return listElements;
  }
  /**
   * Fonction qui affiche la commande tree
   */
  public void affichage(){
    String tree = "\n.";
      
    Iterator<abstractElement> it = this.listElements.iterator();
    int j =0;
    while(it.hasNext()){
      Element element = (Element) it.next();
      if(j != this.listElements.size()-1){
      tree += "\n" +  element.affichage(0,"|",0);
      }else{
      tree += "\n" +  element.affichage(0,"",1);  
      }
      j++;
    }

    System.out.println(tree);
  }  
  /**
   * Fonction qui retourne une variable String ayant la structure d'un fichier JSON
   * @return
   */
  public String json(){
    if(this.listElements.size() != 0){
      String content = "[\n  {\n";

      Iterator it = this.listElements.iterator();
      abstractElement el;
      el = (abstractElement) it.next();
      content += el.json("", 2);
      content += "  }";
      
      while(it.hasNext()){
        el = (abstractElement) it.next();
        content += ",\n  {\n";
        content += el.json("",2);
        content += "\n  }";
      }
      content += "\n]";
      return content;
    }else{
      return "[\n]";
    }    
  }
}