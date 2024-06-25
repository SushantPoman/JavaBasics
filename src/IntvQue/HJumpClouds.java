package IntvQue;

public class HJumpClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        int count = 0;
        for(int i =0; i< c.length-1; i++){
            if(c[i] ==0){
                i++;
            }
            count++;
        }

        return count;
    }

    public static void main(String [] ar){

        int a[] = {0, 0, 1, 0, 0, 1, 0};
        int result = jumpingOnClouds(a);
        System.out.print(result);
    }


}
