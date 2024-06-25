package javapr;

import java.util.*;

public class HStringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String words[] = s.split("[ ,'?!@]");
        // List<String> listD = new ArrayList<>(Arrays.asList(words));
        List<String> listD = new ArrayList<>();
        Collections.addAll(listD, words);
        listD.removeAll(Arrays.asList(""));
        System.out.println(listD.size());
        listD.forEach((wo) ->
                System.out.println(wo)
        );
        scan.close();
    }

}
