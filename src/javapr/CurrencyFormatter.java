package javapr;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

//        Locale locale = new Locale("en","US");
        NumberFormat nmUs = NumberFormat.getCurrencyInstance(Locale.US);
        Locale locInd = new Locale("en","IN");
        NumberFormat nmInd = NumberFormat.getCurrencyInstance(locInd);
//        Locale locChina = new Locale("en","CHINA");
        NumberFormat nmChina = NumberFormat.getCurrencyInstance(Locale.CHINA);
//        Locale locFrc = new Locale("fr","FR");
        NumberFormat nmFrc = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println("US: " + nmUs.format(payment));
        System.out.println("India: " + nmInd.format(payment));
        System.out.println("China: " + nmChina.format(payment));
        System.out.println("France: " + nmFrc.format(payment));


    }

}
