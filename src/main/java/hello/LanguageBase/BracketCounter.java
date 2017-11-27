package hello.LanguageBase;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by q3kasper on 24.11.2017.
 */
public class BracketCounter {
    int bracketCounterL;
    int bracketCounterR;
    char[] left = {'[', '(', '{'};
    char[] rigth = {'}', ')', ']'};

    public void counter() throws IOException {      // Считаем количество скобок
        WriteInFile wr = new WriteInFile();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream((FileStream.fileDestination))));
        String line = null;
        while ((line = reader.readLine()) != null) {

            for (int i = 0; i < left.length; i++) {
                String s = String.valueOf(left[i]);
                Pattern pattern = Pattern.compile("(\\" + s + ")");
                Matcher m = pattern.matcher(line);
                if (m.find()) {
                    bracketCounterL++;
                }
            }
            for (int z = 0; z < rigth.length; z++) {
                String s = String.valueOf(rigth[z]);
                Pattern pattern = Pattern.compile("(\\" + s + ")");
                Matcher m = pattern.matcher(line);
                if (m.find()) {
                    bracketCounterR++;
                }
            }
        }
        if(bracketCounterR==bracketCounterL)
            System.out.println("Brackets correct");
        else System.out.println("Brackets incorrect");

        }


}
