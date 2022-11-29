class Solution {
	int maxSumSubsequence(int[] arr) {
	    int[] dp = new int[arr.length];
        dp[0] = arr[0];

        int res = 0;
        for(int i = 0; i < dp.length; ++i){
            int max = 0;

            for(int j = 0; j < i; ++j){
                if(arr[j] < arr[i]){
                    if(dp[j] > max) max = dp[j];
                }
            }

            dp[i] = arr[i] + max;
            if(res < dp[i]) res = dp[i];
        }

        return res;
	}
	
}