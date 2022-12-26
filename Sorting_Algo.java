class Solution {
    // Quick Sort
    void quickSort(int[] arr) {
        quickSort(0, arr.length - 1, arr);
    }

    void quickSort(int l, int h, int[] arr) {
        if (l < h) {
            int i = partition(l, h, arr);

            quickSort(l, i - 1, arr);
            quickSort(i + 1, h, arr);
        }
    }

    int partition(int l, int h, int[] arr) {
        int pivot = arr[h];
        int i = l - 1;

        for (int j = l; j < h; ++j) {
            if (arr[j] <= pivot) {
                ++i;
                if (j != i) {
                    swap(i, j, arr);
                }
            }
        }
        swap(++i, h, arr);

        return i;
    }

    void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Merge Sort
    void merge(int[] arr, int low, int mid, int high) {
        int subArr1Size = mid - low + 1, subArr2Size = high - mid;
        int[] subArr1 = new int[subArr1Size], subArr2 = new int[subArr2Size];
        for (int i = 0; i < subArr1Size; i++) {
            subArr1[i] = arr[low + i];
        }
        for (int i = 0; i < subArr2Size; i++) {
            subArr2[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0, k = low;
        while (i < subArr1Size && j < subArr2Size) {
            if (subArr1[i] < subArr2[j]) {
                arr[k] = subArr1[i];
                i++;
            } else {
                arr[k] = subArr2[j];
                j++;
            }
            k++;
        }
        while (i < subArr1Size) {
            arr[k++] = subArr1[i++];
        }
        while (j < subArr2Size) {
            arr[k++] = subArr2[j++];
        }
    }

    void mergesort(int[] arr, int low, int high) {
        if (high > low) {
            int mid = (high + low) / 2;
            mergesort(arr, low, mid);
            mergesort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    void mergeSort(int[] arr) {
        int n = arr.length;
        mergesort(arr, 0, n - 1);
    }


    // Insertion Sort 
    void insertionSort (int[] arr) {
		int n = arr.length;
		
		for(int i = 1; i < n; ++i){
			int cur = arr[i];
			int j = i - 1;
			
			while(j > -1 && arr[j] > cur){
				arr[j + 1] = arr[j];
				--j;
			}
			arr[j + 1] = cur;
		}
	}
}
