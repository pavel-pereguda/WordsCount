package hello.LanguageBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by q3kasper on 23.11.2017.
 */
public class Base {                 //база с нежелательными словами
    public List getBase() {
        ArrayList lst = new ArrayList();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("D://q3kasper//JavaCourse//rty//src//main//resources//UnwelcomeWords.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String result;
        while (scanner.hasNext()) {
            result = scanner.nextLine();
            String[] arr = result.split(" ");
            for (int i = 0; i < arr.length; i++) {
                lst.add(arr[i]);
            }

    }return lst;
    }
}