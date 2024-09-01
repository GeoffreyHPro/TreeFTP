package sr1.commands;

import sr1.SocketCommandes;

public class Connexion extends CommandWithoutParam{
 
  
  public Connexion(SocketCommandes s){
    super(s) ;     
  } 
    
  @Override
  public void execute(){
    this.s.sendMessage("");
    this.s.receiveMessage();
  }    
}
