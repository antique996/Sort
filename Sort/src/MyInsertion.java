import java.util.Arrays;

public class MyInsertion {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1, 0};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0 && (less(a[j], a[j - 1])); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(int i, int j) {
        return i < j;
    }
}
