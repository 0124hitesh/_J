class Solution {
	int[] mergeKArrays(int[][] arr) {
	    return mergeArrays(arr, 0, arr.length - 1);
	}
	
	int[] mergeArrays(int[][] arr, int s, int e){
		if(e - s == 1) return ms(arr[s], arr[e]);
		if(e == s) return arr[s];
		
		int m = s + (e - s)/2;        
        return ms(mergeArrays(arr, s, m), mergeArrays(arr, m + 1, e));
	}
	
    // merge 2 sorted arrays
	int[] ms(int[] A, int[] B) {
		int[] res = new int[A.length + B.length];
		int i = 0, j = 0, k = 0;
		
		while(i < A.length && j < B.length)
			if(A[i] < B[j]) res[k++] = A[i++];
			else res[k++] = B[j++];
		
		while(i < A.length) res[k++] = A[i++];
		while(j < B.length) res[k++] = B[j++];
		
		return res;
	}
}