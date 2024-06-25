package IntvQue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HSalesByMatch {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] arr) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hm.replace(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> hmm : hm.entrySet()) {
//            if(hmm.getValue() /2 ==0)
            if (hmm.getValue() / 2 > 0) {
//                aa.add(hmm.getValue()/2);
                sum += (hmm.getValue() / 2);

            }
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       /* BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
        int arr[] = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int result = sockMerchant(9, arr);
        System.out.print(result);
    }

}
