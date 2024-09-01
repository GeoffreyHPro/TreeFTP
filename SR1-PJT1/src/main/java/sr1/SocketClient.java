package sr1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClient {

  protected Socket s; 
  
  protected BufferedReader reader;
  private String ipAdress;
  private int port;
  
  public SocketClient(String IPadress,int port) throws Exception{
    this.ipAdress = ipAdress;
    this.port = port; 
    s = new Socket(IPadress,port);
    s.setSoTimeout(50000);
    
    InputStream in = s.getInputStream();
    InputStreamReader isr = new InputStreamReader(in);
    reader = new BufferedReader(isr);

  }


  public Socket getSocket(){
    return this.s;  
  }

  public String getIpAdress() {
      return ipAdress;
  }

  public int getPort() {
      return port;
  }


  
  public String receiveMessage(){
    try{
      String message = reader.readLine();
      return message;
    }catch(Exception e){
      return "";  
    }
    
  }

  public void close() throws IOException{
    this.reader.close();
    this.s.close();
  }
  
}
