package sr1.arbre;

public abstract class abstractElement implements Element {
  private String name;
  static String lastElement = "\u2503\u2501";
  static String Element = "\u2501";

  public abstractElement(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

}