package sr1;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketCommandes extends SocketClient{

  private PrintWriter writer; 

  public SocketCommandes(String IPAdress,int port)throws Exception{
    super(IPAdress, port);
    
    OutputStream out = this.getSocket().getOutputStream();
    writer = new PrintWriter(out, true);
  }
  
  public void sendMessage(String message){
    writer.println(message); 
         
  }
  /**
   * Fonction qui permet de se reconnecter au serveur FTP
   */
  public void reconnect(){
    try{ 
      s = new Socket(getIpAdress(),getPort());
    }catch(Exception e){

    }
  }
  /**
   * Fonction qui permet de savoir si l'on est toujours connecté au serveur
   * @return
   */
  public boolean connected() {
    return s.isConnected();
  } 
  
}
