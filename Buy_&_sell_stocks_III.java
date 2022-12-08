// You are given an array prices 
// where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete at most two transactions.
// Based on Buy and Sell 1

class Solution {

    // https://www.youtube.com/watch?v=YAWRyWJalM0
    int maxProfit(int[] prices) {
	    int profit1 = 0, min1 = Integer.MAX_VALUE;
		int profit2 = 0, min2 = Integer.MAX_VALUE; 
		
		for(int i = 0; i < prices.length; ++i){
			profit1 = Math.max(profit1, prices[i] - min1);
			min1 = Math.min(min1, prices[i]);
			
			profit2 = Math.max(profit2, prices[i] - min2);
			min2 = Math.min(min2, prices[i] - profit1);
			
		}
		
		return profit2;
	}


    //  TLE
    // Integer[] dp;
    // public int maxProfit(int[] prices) {
    //     dp = new Integer[prices.length];

    //     int res = 0;
    //     for(int i = 0; i < prices.length; ++i){
    //         int a = maxProfit1(prices, i, 0);
    //         if(a > res) res = a;
    //     }

    //     return res;
    // }

    // // one time
    // int maxProfit1(int[] prices, int in, int times) {
    //     if(in == prices.length || times == 2) return 0;

    //     if(dp[in] != null) return dp[in];

	//     int res = 0, min = prices[in];
		
	// 	for(int i = in + 1; i < prices.length; ++i){
	// 		if(prices[i] > min){
	// 			int t = prices[i] - min;
    //             t += dp[in] != null ? dp[in]: maxProfit1(prices, i, times + 1);
	// 			if(t > res) res = t;
	// 		}
	// 		else min = prices[i];
	// 	}
		
	// 	return dp[in] = res;
	// }
}