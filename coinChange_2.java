// You are given an integer array coins representing coins of different denominations 
// and an integer amount representing a total amount of money.

// You may assume that you have an infinite number of each kind of coin.

// #1
// Find the different number of combinations that make up the amount target.

// #2
// Return the fewest number of coins that you need to make up that amount. 
// If that amount of money cannot be made up by any combination of the coins, return -1.


class Solution {
    int numberOfCombinations(int[] coins, int amount) {
	    int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int coin : coins){
            for(int i = coin; i <= amount; ++i){
                dp[i] += dp[i - coin];
            }
        }
    
        return dp[amount];
	}

    public int minCoinChange(int[] coins, int amount) {
      int[] dp = new int[amount + 1];
      java.util.Arrays.fill(dp, amount + 1);
      dp[0] = 0;

      for(int coin : coins){
          for(int i = coin; i <= amount; ++i){
              dp[i] = Math.min(dp[i], dp[i - coin] + 1);
          }
      }
  
      return dp[amount] <= amount ? dp[amount] : -1;
  }

  public static void main(String...args){
    int[] coins = {};
    int amount = 1;
    
    System.out.println(new Solution().minCoinChange(coins, amount));
  }
}