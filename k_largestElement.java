//ex quicksearch

class k_largestElement {
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int quickSelect(int[] arr, int low, int high, int k) {
        while (low <= high) {
            int i = low - 1, pivot = arr[high];

            for (int j = low; j < high; ++j) {
                if (arr[j] <= pivot) {
                    ++i;
                    if (i != j)
                        swap(arr, i, j);
                }
            }
            swap(arr, ++i, high);

            if (i == k)
                return i;
            else if (i < k)
                low = i + 1;
            else
                high = i - 1;
        }

        return low - 1;
    }

    public static void main(String... args) {
        k_largestElement ob = new k_largestElement();

        int[] arr = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int n = arr.length;
        int res = ob.quickSelect(arr, 0, n - 1, n - 4);
        System.out.println(arr[res]);
    }
}
