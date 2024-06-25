package javapr;

import java.util.SortedSet;
import java.util.TreeSet;

public class HLexicographicallySubString {

    public static void main(String[] a){

        String s = "welcometojava";
        int k = 3;
        String smallest = "";
        String largest = "";

        String currStr = s.substring(0, k);
        smallest = currStr;
        largest = currStr;

        // Consider all remaining substrings. We consider
        // every substring ending with index i.
        for (int i = k; i < s.length(); i++) {
            currStr = currStr.substring(1, k) + s.charAt(i);
            if (largest.compareTo(currStr) < 0)
                largest = currStr;
            if (smallest.compareTo(currStr) > 0)
                smallest = currStr;
        }

        System.out.println(smallest+ "\n"+largest);


    }

}
