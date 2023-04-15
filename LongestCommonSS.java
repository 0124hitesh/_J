class Solution {
	int getLengthOfLCS(String s1, String s2) {
		char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        for(int i = arr1.length - 1; i > -1; --i){
            for(int j = arr2.length - 1; j > -1; --j){
                if(arr1[i] == arr2[j]){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }   

        return dp[0][0];
	}
}