package IntvQue;

public class HValeStepCount {

    public static int countingValleys(int steps, String path) {


//        char[] ar = path.toCharArray();
        int up = 0;
        int down = 0;
        int count = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'U') {
                up++;
            } else if (path.charAt(i) == 'D') {
                down++;
            }

            if(i> 0 && up == down & (path.charAt(i-1) == path.charAt(i))){
                up = 0;
                down= 0;
                count++;
            }
        }

        return count;

    }

    public static void main(String[] a) {
        int c = countingValleys(8, "UDDDUDUU");
        System.out.print(" count: "+c);

    }
}
