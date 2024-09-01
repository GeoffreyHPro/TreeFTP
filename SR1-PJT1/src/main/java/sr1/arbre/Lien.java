package sr1.arbre;

public class Lien extends Fichier {
  static String color = "\u001B[31m";
  static String basicColor = "\u001B[37m";
  private String type = "Lien"; 

  public Lien(String name){
    super(name);    
  }

  public String affichage(int i,String s,int last){
        
    if(last == 1)  {
        //System.out.println(s + lastElement + getName());    //   |_   "\u2502" + "\u2500" 
        return s + lastElement + color + getName() + basicColor;
    }else{
        //System.out.println(s + Element + getName());  //   |_
        return s + Element + color + getName() + basicColor;
    }
  }

  @Override
  public String json(String content, int profondeur) {
    String newContent = content;

    newContent += "  ".repeat(profondeur) + "\"name\" : \"" + getName() + "\",\n";
    newContent += "  ".repeat(profondeur) + "\"type\" : \"" + this.type + "\"\n";
    return newContent;
  }
}