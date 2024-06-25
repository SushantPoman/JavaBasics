package IntvQue;

public class HLeftRotation {

    static int[] rotLeft(int[] a, int d) {

        /*int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i < d) {
                result[a.length + i - d] = a[i];
            } else {
                result[i - d] = a[i];
            }
        }*/

        int first = 0;

        for (int j=0; j<d; j++) {
            for (int i = 0; i < a.length; i++) {
                if (i == 0) {
                    first = a[i];
                } else if (i == a.length - 1) {
                    a[i - 1] = a[i];
                    a[i] = first;
                } else
                    a[i - 1] = a[i];
            }
        }

        return a;
    }

    public static void main(String[] ar) {
        int a[] = new int[]{1, 2, 3, 4, 5};
        int[] c = rotLeft(a, 6);
        for (int arrVal : c)
            System.out.print(arrVal + " ");

    }
}
