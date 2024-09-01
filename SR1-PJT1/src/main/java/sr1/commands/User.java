package sr1.commands;

import java.util.Scanner;

import sr1.*;

public class User extends CommandWithParam{

    public User(SocketCommandes s){
      super(s);
    }

    @Override
    public void execute(){
      this.s.sendMessage("USER " + param);
      
      String message = this.s.receiveMessage();
      try{ 
        error((message.split("\\s+"))[0]);
      }catch(ExceptionUser e) {
        System.out.println("Réentrez un nouveau username : ");
        Scanner s = new Scanner(System.in);
        param = s.nextLine();
        execute();
      }
    } 
    
    private void error(String content)throws ExceptionUser{
      if (content.equals("530")){
        throw new ExceptionUser();
      }     
    }
}
