import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = t;
    }

    public static void sink(int[] a, int k, int N) { // 将小的数字下沉
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(int[] a, int i, int j) {

        return a[i - 1] - a[j - 1] < 0;
    }
}
