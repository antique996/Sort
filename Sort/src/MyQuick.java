import java.util.Arrays;

public class MyQuick {

    public static void main(String[] args) {
        int[] arrays = {8, 6, 9, 3, 0, 2, 4, 1};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);

        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) if (i == hi) break;

            while (v < a[--j]) if (j == lo) break;

            if (i >= j) break;

            exch(a, i, j);

        }
        exch(a, lo, j);

        return j;
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
