package sr1.commands;

import java.util.ArrayList;

import sr1.arbre.*;

import sr1.SocketCommandes;
import sr1.SocketDonnees;

public class List extends CommandWithoutParam{
  
  private SocketDonnees s;
  private SocketCommandes s2;
  private ArrayList<Element> listElement;
  
  public List(SocketCommandes s1){
    super(s1) ;   
    this.s2 = s1;  
  } 
    
  @Override
  public void execute(){
    Pasv p = new Pasv(s2);
    p.execute();
    try{
      this.s = new SocketDonnees(p.getAdress(),p.getPort());
      this.s2.sendMessage("LIST");
      this.s2.receiveMessage(); 
    
    listElement = s.list();
    this.s2.receiveMessage();

    s.close();

    }catch(Exception e){

    }
    
  }  
  
  public ArrayList<Element> getlistElement(){
    return listElement;  
  }
}