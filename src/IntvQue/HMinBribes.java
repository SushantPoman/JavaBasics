package IntvQue;

import java.util.Arrays;

import static java.lang.Math.max;

public class HMinBribes {


    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        /*for(int i=0;i<q.length;i++){
            if((q[i] - (i+1)) > 2){
                System.out.println("Too chaotic");
                return;
            }
        }

        //now we just need to count number of Swaps
        int swaps=0;
        for(int i=0;i< q.length;i++){
            for(int j=i+1;j<q.length;j++){
                if(q[i] > q[j]){
                    int tmp=q[j];
                    q[j]=q[i];
                    q[i]=tmp;
                    swaps++;
                }
            }
        }

        System.out.println(swaps);


        for (int i = q.length - 1; i >= 0; i--) {

            int orgValue = orgArr[i];
            int pos = getIndex(q, orgValue);

            int diff = i - pos;
            if (diff > 2) {
                isChaotic = true;
            } else if (diff > 0) {
                counter += diff;
            }
        }
        */

        /*int orgArr[] = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            orgArr[i] = i + 1;
        }

        int counter = 0;
        boolean isChaotic = false;//Too chaotic


        for (int i = q.length-1; i >0; i--) {

            int orgValue = orgArr[i];
            int pos = getIndex(q, orgValue);

            int diff = i - pos;
            if (diff > 2) {
                isChaotic = true;
            } else if (diff > 0) {
                counter += diff;
            }
        }

        if (isChaotic)
            System.out.println("Too chaotic");
        else
            System.out.println(counter);
*/

        /*int ans = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) {
                    ans++;
                }
        }
        System.out.println(ans);*/

        int totalBribes = 0;

        int expectedFirst = 1;
        int expectedSecond = 2;
        int expectedThird = 3;

        for (int i = 0; i < q.length; ++i) {
            if (q[i] == expectedFirst) {
                expectedFirst = expectedSecond;
                expectedSecond = expectedThird;
                ++expectedThird;
            } else if (q[i] == expectedSecond) {
                ++totalBribes;
                expectedSecond = expectedThird;
                ++expectedThird;
            } else if (q[i] == expectedThird) {
                totalBribes += 2;
                ++expectedThird;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }

        System.out.println(totalBribes);
    }

    static int getIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] ar) {
        int a[] = new int[]{1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(a);

    }
}
