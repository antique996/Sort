import java.util.ArrayList;
import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int len = a.length;
        boolean isChange;
        for (int i = 0; i < len - 1; i++) {
            isChange = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    exch(a, j, j + 1);
                }
                isChange = false;
            }
            if (isChange) {
                break;
            }
        }
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
