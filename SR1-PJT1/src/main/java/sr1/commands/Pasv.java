package sr1.commands;

import sr1.SocketCommandes;

public class Pasv extends CommandWithoutParam{
 
  private int port;
  private String adressIP;

  public Pasv(SocketCommandes s){
  super(s) ;     
  } 
    
  @Override
  public void execute(){
    this.s.sendMessage("PASV");
    String message = this.s.receiveMessage(); 
    
    /*permet de récupérer les informations pour la socket de donnée
     * l'adresse IP et le port 
     */
    String tab[] = message.split(" ");
    String info = tab[4];
    info = info.substring(1,info.length() -2);
    String infos[] = info.split(",");
    
    adressIP = infos[0] + "." + infos[1] + "." + infos[2] + "." + infos[3]; 
    port = Integer.parseInt(infos[4]) * 256 + Integer.parseInt(infos[5]);
    
  }

  public int getPort(){
    return port;  
  }    

  public String getAdress(){
    return adressIP;  
  }
}
