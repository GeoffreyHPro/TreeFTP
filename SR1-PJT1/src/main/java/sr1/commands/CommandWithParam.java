package sr1.commands;

import sr1.SocketCommandes;

public abstract class CommandWithParam extends abstractCommandes {
  protected String param;  

  
  public CommandWithParam(SocketCommandes s){
    super(s);  
  } 

  public void setParam(String param){
    this.param = param;
  }
  
}
