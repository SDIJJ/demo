package test;

import java.util.Scanner;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/1/13 12:21
 * @version: v1.0.0
 */
public class RegularTest {
   private  static int s = 9;
    static String str = "Java now has regular expressions";

    public static void main(String[] args) {
        RegularTest.s++;

//        String regex="(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(pattern(scanner.nextLine()));
        }
    }

    public static boolean pattern(String target) {
        return str.matches(target);
    }


}
