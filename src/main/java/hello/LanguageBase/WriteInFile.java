package hello.LanguageBase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by q3kasper on 24.11.2017.
 */
public class WriteInFile {          //создает, сохраняет в файл и очищает его по завершении. Временный файл для хранения очищенного текста от нежелательного слов и скобок.


String path;

File fileWitoutBad;
    WriteInFile (){
       path= new File("").getAbsolutePath();
      fileWitoutBad = new File (path+"/filewithoutbad");
    }




    public File getFileWitoutBad() throws IOException{
        fileWitoutBad.createNewFile();
        return fileWitoutBad;
    }


public  void writeIn(String line) throws IOException{
    FileWriter writer = new FileWriter(getFileWitoutBad().getAbsolutePath(), true);
   try {
       writer.write(line+" ");
   }catch (NullPointerException e){
       writer.write("");
   }
    writer.flush();

}
public void eraseFileOnExit() throws IOException {
    FileOutputStream writer1 = new FileOutputStream(fileWitoutBad.getAbsolutePath());
    writer1.write(("").getBytes());
    writer1.close();
}
}