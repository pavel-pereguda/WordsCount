package hello.LanguageBase;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.Map.Entry;

import static javafx.scene.input.KeyCode.H;

/**
 * Created by q3kasper on 26.11.2017.
 */
public class SortingWords {

    public void  getSortedTopList() {
            for (Entry<String, Integer> entry : list) {                   //-выводит весь порядок по употребляемости. Выводит все, а не первые десять. Не допилил
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
    }

    List<Entry<String,Integer>> list;
    HashMap<String, Integer> map ;

     SortingWords(String destination) throws IOException {         //принимает уже очищенный список для подсчета употребляемости
     WriteInFile wf = new WriteInFile();
      map = new HashMap<String, Integer>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(wf.fileWitoutBad)));
    String currentLine=reader.readLine();
     while (currentLine!=null){

         String [] words = currentLine.toLowerCase().split(" ");
for (String word:words){
    if(map.containsKey(word)){
        map.put(word,map.get(word)+1);
    } else {
        map.put(word,1);
    }
}
currentLine=reader.readLine();
     }
      list = new ArrayList<Entry<String, Integer>>(map.entrySet());                 //-не до конца понимаю как это работает. Запихнули в Map, а потом с Entry запихнули в Array, но используем как объект Entry...Чет запутался
     Collections.sort(list, new Comparator<Entry<String, Integer>>()
     {
         @Override
         public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
             return (o2.getValue().compareTo(o1.getValue()));
         }
     });
     reader.close();
     }
 }

