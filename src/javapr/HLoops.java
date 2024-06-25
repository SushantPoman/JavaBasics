package javapr;

import java.util.Scanner;

// (a+ 2^0 * b), (a+ 2^0 * b + 2^1 *b)

public class HLoops {

    public static void main(String[] args) {

        boolean firstTime = true;
        Scanner in = new Scanner(System.in);
        int totalLines = in.nextInt();
//        System.out.println("total lines:" +totalLines);

        for (int i = 0; i < totalLines; i++) {
//            System.out.print("total lines loop :" +i);
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
//           System.out.println("a " + a + " b " + b + " n " + n);

            int sum = a + (1*b);
            if(firstTime){
                firstTime = false;
            } else {
                System.out.print("\n");
            }

            System.out.print(sum+" ");

            for(int j =1; j < n; j++){
                int power = (int) Math.pow(2, j);
//               System.out.print( "a "+a + " power "+power  +" b "+ b);
                int newSum = power*b;
                sum += newSum;
                System.out.print(sum+" ");
            }
        }
        in.close();

    }

}
