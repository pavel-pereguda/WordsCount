package hello.LanguageBase;

import com.sun.org.apache.xpath.internal.SourceTree;


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by q3kasper on 23.11.2017.
 */
public class FileStream {
static String fileDestination;
    public static void main(String[] args) throws IOException {

        WriteInFile wif = new WriteInFile();
        BracketCounter brcoutn = new BracketCounter();
        Scanner ind = new Scanner(System.in);
        System.out.println("Pring absolute file path: /n");
//        D:\q3kasper\JavaCourse\rty\src\main\resources\SourceWithWords.txt
         fileDestination = ind.nextLine();

       BufferedReader  reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileDestination)));     //- принимаем на вход файл
        String line;
        while ((line = reader.readLine()) != null) {
            FileStream fl = new FileStream();
fl.doMatch(line);
        }

      brcoutn.counter();   //-счетчик скобок
        SortingWords s = new SortingWords(fileDestination);
        s.getSortedTopList();                //-подсчет употребляемости
       wif.eraseFileOnExit();                 //очищаем временные файлы
    }



    void doMatch(String line) throws IOException {                //- сравнивает со списком нежелательных слов и удаляет их. Также удаляет все символы.
        WriteInFile wf = new WriteInFile();
        Base bs = new Base();
        ArrayList<String> arr = new ArrayList();
        arr.addAll(bs.getBase());

        String withoutSpecialChars = ("[^\\w\\s]");
        for (int i = 0; i < arr.size(); i++) {
            Pattern p = Pattern.compile("^"+arr.get(i)+"$");
            Matcher m = p.matcher(line.toLowerCase());
            line = m.replaceAll("");
            Pattern pattern = Pattern.compile(withoutSpecialChars);
            Matcher matcher = pattern.matcher(line.toLowerCase());
            line=matcher.replaceAll("");

        }
       wf.writeIn(line);
    }
}


