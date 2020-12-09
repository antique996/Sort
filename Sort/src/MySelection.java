import java.util.Arrays;

public class MySelection {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (less(a, j, min)) min = j;
            }
            exch(a, i, min);
        }
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }
}
