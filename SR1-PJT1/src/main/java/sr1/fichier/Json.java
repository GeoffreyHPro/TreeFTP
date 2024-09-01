package sr1.fichier;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Json{
  private String name;
  public Json(String title){
    this.name = title + ".json";
    try{
      File f = new File(this.name); 
      f.createNewFile();
    }catch(Exception e){

    }  

  } 
  /**
   * Fonction qui permet de remplacer toutes les données d'un fichier JSON par
   * le parametre String donné en paramètre
   * @param content
   */
  public void write(String content){
    Path path = Paths.get(this.name);
		try {
			String str = content ;
			byte[] bs = str.getBytes();
			Files.write(path, bs);
		} catch (Exception e) {
			e.printStackTrace();
		}  
  }
}