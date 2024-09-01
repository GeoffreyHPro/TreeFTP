package sr1.commands;

import sr1.SocketCommandes;

public class Cwd extends CommandWithParam{

    public Cwd(SocketCommandes s){
      super(s);
    }

    @Override
    public void execute(){
      this.s.sendMessage("CWD " + param);
      String message = this.s.receiveMessage();
    }  
}