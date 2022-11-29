
class Solution {
	int getLengthOfLCS(String s1, String s2) {
		int a = s1.length(), b = s2.length();
        int[][] dp = new int[a + 1][b + 1];

        for(int i = 1; i <= a; ++i){
            for(int j = 1; j <= b; ++j){
                if(s1.charAt(a - i) == s2.charAt(b - j)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 
                }
            }
        }

        return dp[a][b];
	}
}