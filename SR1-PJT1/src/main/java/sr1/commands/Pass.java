package sr1.commands;

import java.io.Console;
import java.util.Scanner;

import sr1.SocketCommandes;

public class Pass extends CommandWithParam{

    public Pass(SocketCommandes s){
      super(s);
    }

    @Override
    public void execute(){
      this.s.sendMessage("PASS " + param);
      String message = this.s.receiveMessage(); 
      try{ 
        error((message.split("\\s+"))[0]);
      }catch(ExceptionPass e) {
        System.out.println("Réentrez un nouveau mot de passe : ");
        Scanner s = new Scanner(System.in);
        
        param = s.nextLine();
        execute();
      }
    }  

    private void error(String content)throws ExceptionPass{
      
      if(content.equals("530")){
        throw new ExceptionPass();
      }  
    }


}