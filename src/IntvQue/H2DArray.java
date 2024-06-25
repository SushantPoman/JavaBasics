package IntvQue;

import java.util.*;

public class H2DArray {

    static int hourglassSum(int[][] arr) {

        Set<Integer> ss = new LinkedHashSet<Integer>();

        for (int[] x : arr) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }


        for (int rows = 0; rows < 4; rows++) {
            for(int cols = 0; cols < 4; cols++) {
                int sum = getTotalCount(get2DSubArray(arr, rows, rows+2, cols, cols+2));
                System.out.print("Individual sum -=>>"+sum);
                ss.add(sum);
            }
        }


        int max = Collections.max(ss);
        System.out.print("\nFinal max -=>>"+max);

        return max;
    }

    public static int[][] get2DSubArray(int[][] largeArray, int rowStartIndex, int rowEndIndex, int columnStartIndex,
                                           int columnEndIndex) {
        int[][] subArray = new int[rowEndIndex - rowStartIndex + 1][columnEndIndex - columnStartIndex + 1];
        int index = 0;
        for (int row = rowStartIndex; row <= rowEndIndex; row++) {
            subArray[index++] = Arrays.copyOfRange(largeArray[row], columnStartIndex, columnEndIndex+1);
        }

        /*System.out.println("===============================");
        for (int[] x : subArray) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }*/

        return subArray;
    }

    public static int getTotalCount(int[][] arr){
        int count = 0;

        for (int rows = 0; rows < 3; rows++) {
            for(int cols = 0; cols < 3; cols++){
                if(!(rows==1 && (cols ==0 || cols ==2))){
                    count += arr[rows][cols];
                }
            }
        }
        return count;
    }

    public static void main(String[] a) {

        int[][] contents = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};


        int max = hourglassSum(contents);


//        System.out.println(Arrays.deepToString(contents).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

    }
}
