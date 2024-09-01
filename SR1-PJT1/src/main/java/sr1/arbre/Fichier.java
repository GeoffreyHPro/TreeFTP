
package sr1.arbre;

public class Fichier extends abstractElement{
  private String type = "Fichier"; 
    
    public Fichier(String name){
      super(name);    
    } 

    public String affichage(int i,String s,int last){
        
      if(last == 1)  {
          //System.out.println(s + lastElement + getName());    //   |_   "\u2502" + "\u2500" 
          return s + lastElement + getName();
      }else{
          //System.out.println(s + Element + getName());  //   |_
          return s + Element + getName();
      }

  }

  
  public String json(String content, int profondeur) {
    String newContent = content;

    newContent += "  ".repeat(profondeur) + "\"name\" : \"" + getName() + "\",\n";
    newContent += "  ".repeat(profondeur) + "\"type\" : \"" + this.type + "\"\n";
    return newContent;
  }
}