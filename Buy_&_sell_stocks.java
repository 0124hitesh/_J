import java.util.*;

// You are given an array prices where prices[i] denotes the price of a stock on the ith day. 
// You want to maximize the profit by buying a stock and 
// then selling it at a higher price.
 // what is the maximum profit that you can make?

class A{

    // Best Time to Buy and Sell Stocks
    // Suppose you can make a single buy and single sell at any date after you buy, 
    int maxProfit(int[] prices) {
	    int res = 0, min = prices[0];
		
		for(int i = 1; i < prices.length; ++i){
			if(prices[i] > min){
				int t = prices[i] - min;
				if(t > res) res = t;
			}
			else min = prices[i];

            // also can be coded as -
            // res = Math.max(res, prices[i] - min);
			// min = Math.min(min, prices[i]);
		}
		
		return res;
	}


    // Best Time to Buy and Sell Stocks II
   
    // Suppose you can do as many transactions as you want,

    int maxProfit2(int[] prices) {
        int res = 0, llastBought = prices[0];

       for(int cur: prices){
           if(cur < llastBought) llastBought = cur;
           else if(cur > llastBought){
               res += cur - llastBought;
               llastBought = cur;
           }
       }

       return res;
   }
}