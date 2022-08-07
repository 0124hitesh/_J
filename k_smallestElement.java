public class k_smallestElement {
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int partition(int[] arr, int low, int high) {
        int i = low - 1, pivot = arr[high];

        for (int j = low; j <= high - 1; ++j) {
            if (arr[j] <= pivot) {
                ++i;
                if(i != j)
                    swap(arr, i, j);
            }
        }
        swap(arr, ++i, high);

        return i;
    }

    int quickSelect(int[] arr, int low, int high, int k) {
        while (low <= high) {
            int pIndex = partition(arr, low, high);

            if (pIndex == k)
                return arr[k];
            else if (pIndex < k)
                low = pIndex + 1;
            else
                high = pIndex - 1;
        }

        return -1;
    }

    public static void main(String... args) {
        k_smallestElement ob = new k_smallestElement();

        int[] arr = { 10, 4, 5, 8, 11, 6, 26 };
        System.out.println(ob.quickSelect(arr, 0, arr.length - 1, 4));
    }
}
