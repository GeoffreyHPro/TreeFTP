package sr1.commands;

import sr1.SocketCommandes;

public class Pwd extends CommandWithoutParam{
 
  
  public Pwd(SocketCommandes s){
  super(s) ;     
  } 
    
  @Override
  public void execute(){
    this.s.sendMessage("PWD");
    String message = this.s.receiveMessage(); 
    System.out.println(message);
      
  }    
}