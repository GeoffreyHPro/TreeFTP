package sr1.arbre;

import java.util.ArrayList;
import java.util.Iterator;


public class Dossier extends abstractElement{
  static String color = "\u001B[34m";
  static String basicColor = "\u001B[37m";
  private ArrayList<abstractElement> list; 
  private String type = "Dossier"; 
  
  public Dossier(String name){
    super(name);
    list = new ArrayList<>();
  } 

  public void addElement(abstractElement el){
    list.add(el);  
  }

  public ArrayList<abstractElement> getList() {
    return list;
  }
  
  /**
   * Fonction qui permet l'affichage de la commande tree de la classe Dossier
   */
  public String affichage(int i,String s,int last){
    String tree = "";
    if(last == 1){
      tree = s + lastElement + color + getName() + basicColor;
    }else if(last == 0){ 
      tree = s + Element + color + getName() + basicColor;
    }
    

    Iterator<abstractElement> it = this.list.iterator();
    int j =0;
    while(it.hasNext()){
      Element element = (Element) it.next();
      if(j != this.list.size()-1){
        tree += "\n" + element.affichage(0,s + "  |",0);
      }else{
        tree += "\n" + element.affichage(0,s + "  ",1);  
      }
      j++;
    }

    return tree;
  }

  @Override
  public String json(String content, int profondeur) {
    String newContent = content;

    newContent += "  ".repeat(profondeur) + "\"name\" : \"" + getName() + "\",\n";
    newContent += "  ".repeat(profondeur) + "\"type\" : \"" + type + "\",\n";
    
    newContent += "  ".repeat(profondeur) + "\"list\" : [";
    
    if(this.list.size() != 0){
      
      newContent += "\n" + "  ".repeat(profondeur+1) + "{\n";
      Iterator<abstractElement> it = this.list.iterator();
      abstractElement el;
      el = (abstractElement) it.next();
      newContent += el.json("", profondeur + 2);
      newContent += "  ".repeat(profondeur+1) + "}";
      
      while(it.hasNext()){
        newContent += ", \n" + "  ".repeat(profondeur+1) + "{\n";
        el = (abstractElement) it.next();
        newContent += el.json("",profondeur +2);
        newContent += "  ".repeat(profondeur+1) + "}";
      }
      newContent +="\n" +  "  ".repeat(profondeur) + "]\n" ;
      
    }else{
      newContent += "]\n";
    } 
    return newContent;   



  }
}