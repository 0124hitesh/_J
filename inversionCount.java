// ex mergeSort

import java.util.*;

public class inversionCount {

    public int merge(int[] arr, int l, int m, int r) {
        int[] arr1 = Arrays.copyOfRange(arr, l, m + 1);
        int[] arr2 = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;
        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] <= arr2[j])
                arr[k++] = arr1[i++];
            else {
                arr[k++] = arr2[j++];
                swaps += m - i - l + 1;
            }
        }

        while (i < arr1.length)
            arr[k++] = arr1[i++];
        while (j < arr2.length)
            arr[k++] = arr2[j++];

        return swaps;
    }

    public int sort(int[] arr, int l, int r) {
        int swaps = 0;
        if (l < r) {
            int m = (r - l) / 2 + l;

            swaps += sort(arr, l, m);
            swaps += sort(arr, m + 1, r);

            swaps += merge(arr, l, m, r);
        }

        return swaps;
    }

    public static void main(String[] args) {
        // int[] arr = {5,1,2,4,3,7,32,3};
        int[] arr = { 5, 20, 6, 4, 1 };

        System.out.println(new inversionCount().sort(arr, 0, arr.length - 1));
        System.out.println(Arrays.toString(arr));
    }
}