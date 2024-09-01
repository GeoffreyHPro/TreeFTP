package sr1;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {    
        System.out.println( "Hello World!" );

        Socket s;
        BufferedReader reader;
        PrintWriter writer;
        Socket ss;
        
        BufferedReader reader2;

        
        try{
          //s = new Socket("webtp.fil.univ-lille.fr",21);
          s = new Socket("ftp.ubuntu.com",21);

          InputStream in = s.getInputStream();
          InputStreamReader isr = new InputStreamReader(in);
          reader = new BufferedReader(isr);

          OutputStream out = s.getOutputStream();
          writer = new PrintWriter(out, true);
          writer.println("");
          System.out.println(reader.readLine());
          //writer.println("USER geoffrey.herman.etu");
          writer.println("USER anonymous");
          System.out.println(reader.readLine());
          Scanner scanner = new Scanner(System.in);
          Console console = System.console();
          char[] mdp = console.readPassword();
          //String mdp = scanner.nextLine();
          writer.println("PASS " + mdp.toString());
          System.out.println(reader.readLine());
          writer.println("PWD  ");
          System.out.println(reader.readLine());
          /*writer.println("CWD /ubuntu/indices");
          System.out.println(reader.readLine());*/

          /*writer.println("CWD /ubuntu/indices");
          System.out.println(reader.readLine());*/

          writer.println("PASV");
          String message = reader.readLine();
          System.out.println(message);
          
          
          /* Tous les parametres sont dans le tableau final*/
          String tab[] = message.split(" ");
          System.out.println(tab[4]);
          String info = tab[4];
          info = info.substring(1,info.length() -2);
          String infos[] = info.split(","); 
          
          /*Création Socket de Données*/
          
          ss = new Socket(infos[0] + "." + infos[1] + "." + infos[2] + "." + infos[3], Integer.parseInt(infos[4]) * 256 + Integer.parseInt(infos[5]));
          
          InputStream in2 = ss.getInputStream();
          InputStreamReader isr2 = new InputStreamReader(in2);
          reader2 = new BufferedReader(isr2);
          PrintWriter writer2;
          OutputStream out2 = ss.getOutputStream();
          writer2 = new PrintWriter(out2, true);
          



          
          
          
          writer.println("LIST");
          System.out.println(reader.readLine());
          
          
          /*writer.println("QUIT");
          System.out.println(reader.readLine());*/
          //writer2.println("");
         
          //System.out.println(ss.isConnected());
          //System.out.println(reader2.ready());
          //String line = reader2.readLine();
          //System.out.println(line); 
          String line;
          while ((line = reader2.readLine()) != null){
            //line = reader2.readLine();
            System.out.println(line);   
          }
          //System.out.println(reader.readLine());
          writer2.println("QUIT");

          reader2.close();
          ss.close();
          

          
          /*writer.println("LIST");
          System.out.println(reader.readLine());
          System.out.println(reader.readLine());
          while (reader2.ready()){
            System.out.println(reader2.readLine());  
          } 
          
          reader2.close();
          scanner.close();*/


        }catch(Exception e){
        
        }

    }
}
