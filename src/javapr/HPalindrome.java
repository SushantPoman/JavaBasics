package javapr;

import java.util.Scanner;

public class HPalindrome {

    public static void main(String [] ar){

        Scanner sc=new Scanner(System.in);
        String A=sc.next();

        String reverse = "";

        for(int i =A.length()-1; i>=0; i--){
            reverse = reverse+A.charAt(i);
        }

        if(A.equals(reverse)){
            System.out.print("Yes");
        } else{
            System.out.print("No");
        }

    }

}
