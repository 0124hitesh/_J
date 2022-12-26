class Solution {
	int largestContiguousSum(int[] arr) {
		int maximumSum = 0, currentSum = 0;
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			maxValue = Math.max(maxValue, arr[i]);
			minValue = Math.min(minValue, arr[i]);
		}

		if (maxValue < 0) {
			return minValue;
		}
		
		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];
			maximumSum = Math.max(maximumSum, currentSum);
			if (currentSum < 0) {
				currentSum = 0;
			}
		}
		return maximumSum;
	}


	// Pascal's Triangle
	int[] pascalTriangleRow(int rowNo) {
		int[] arr = new int[rowNo];
		arr[0] = 1;
		--rowNo;
		
		for(int i = 1; i <= rowNo; ++i){
			arr[i] = arr[i - 1] * (rowNo - i + 1) / i;
		}
		
		return arr;	
	}	


	// Is Perfect Square
	// 1 <= Num <= 10^8
	boolean isPerfectSquare (int num) {
		return isPerfectSquare(1, 10000, num);
	}
	
	boolean isPerfectSquare(int l, int h, int num){
		if(l > h) return false;
		
		int mid = l + (h - l)/2;
		int sqr = mid*mid;
		
		if(sqr == num) return true;
		
		if(sqr < num) return isPerfectSquare(mid + 1, h, num);
		return isPerfectSquare(l, mid - 1, num);
	}
}
