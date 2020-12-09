import java.util.Arrays;

public class MyShell {

    public static void main(String[] args) {
        int[] a = {8, 6, 9, 3, 0, 2, 4, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int len = a.length;
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && (a[j] < a[j - h]); j -= h) {
                    exch(a, h, j);
                }
            }
//            h = h / 3;
            h /= 3;
        }
    }

    private static void exch(int[] a, int h, int j) {
        int temp = a[j];
        a[j] = a[j - h];
        a[j - h] = temp;
    }
}
