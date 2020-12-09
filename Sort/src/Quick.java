public class Quick {
    public static void main(String[] args) {

        int[] arr = {1, 9, 6, 4, 7, 9, 0};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr, int L, int R) {
        int i = L;
        int j = R;
        int pivot = arr[(L + R) / 2];
        while (i <= j) {
            while (pivot > arr[i]) {
                i++;
            }
            while (pivot < arr[j]) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (L < j) {
            quickSort(arr, L, j);
        }
        if (R > i) {
            quickSort(arr, i, R);
        }
    }
}
