package javapr;

import java.util.Arrays;
import java.util.Scanner;

public class HAnagram {


    static boolean isAnagram(String a, String b) {

        char[] firstArr = a.toUpperCase().toCharArray();
        char[] secArr = b.toUpperCase().toCharArray();
        Arrays.sort(firstArr);
        Arrays.sort(secArr);

        if(Arrays.equals(firstArr,secArr))
            return true;
        else
            return false;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
