package javapr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJavaList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayCount = scanner.nextInt();
        scanner.nextLine();
        String s[]= scanner.nextLine().split(" ");
        List<Integer> numList = new ArrayList<>();
        // int numArr[] = new int[s.length];
        for(int i =0 ;i < arrayCount;i++){
            // numArr[i]= Integer.parseInt(s[i]);
            numList.add(Integer.parseInt(s[i]));
        }
        int operationCount = scanner.nextInt();
        scanner.nextLine();
        for(int j=0;  j<operationCount; j++){
            String operation = scanner.nextLine();
            switch(operation){
                case "Insert":
                    String sInsArr[]= scanner.nextLine().split(" ");
                    numList.add(Integer.parseInt(sInsArr[0]),
                            Integer.parseInt(sInsArr[1]));
                    break;
                case "Delete":
                    numList.remove(scanner.nextInt());
                    break;
            }

        }
        for(int k: numList)
            System.out.print(k+" ");

    }
}
