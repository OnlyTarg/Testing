package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
       /* String str = "sdfg*";
        String str1 = ".*tring.*";
        String str2 = "fff";
        Pattern pattern1 = Pattern.compile(str);
        Pattern pattern2 = Pattern.compile(str1);
        Pattern pattern3 = Pattern.compile(str2);
        Pattern[] mas = {pattern1, pattern2, pattern3};
        for (int i = 0; i < mas.length; i++) {

            Matcher mat = mas[i].matcher("Some string for testing");
            if (mat.find()) {

                System.out.println("I find equal at the line number - " + i + "   " + mat.group());
            }
        }*/
        String s = "Some String REGEX";
        String [] mas = s.split(":");
        System.out.println(mas.length);
        System.out.println(mas[0]);


    }
}
