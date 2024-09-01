package sr1;


public class Main2 {
  public static void main(String[] args) {
    try{
      

      CommandManager c = new CommandManager("webtp.fil.univ-lille.fr");
      //ClientFTP c = new ClientFTP("ftp.ubuntu.com");
      //c.commandFTP("Connexion", "");
      //c.commandFTP("User", "anonymous"); 
      //c.commandFTP("Pass","anonymous");
      //c.commandFTP("User", "geoffrey.herman.etu"); 
      //c.commandFTP("Pass","a13c08g19s12v15");
      
      //c.commandFTP("List","");
      //c.commandFTP("Cwd", "public_html");
      //c.commandFTP("List","");

      //c.commandFTP("Cwd", "server");
      //c.commandFTP("List","");
      //c.commandFTP("Cdup", "");

      c.tree(10);
      
      
    
    }catch(Exception e){
      System.out.println("pas co");
    }   
  }
}
