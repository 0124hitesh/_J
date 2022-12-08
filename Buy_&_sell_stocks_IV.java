import java.util.*;

// You may complete at most k transactions.

class Solution {
    public int maxProfit(int k, int[] prices) {
        // ```
        // if we 8 days than max transaction can be made equals to 4
        // So if k > prices.length/2, then it is same as infinte transaction
        if(k > prices.length/2)
            return maxProfit2(prices);

        // above part not mandatory 
        // ```

       int[] min = new int[k], profit = new int[k];

        Arrays.fill(min, Integer.MAX_VALUE);

        for(int i = 0; i < prices.length; ++i){
            for(int j = 0; j < k; ++j){
                min[j] = Math.min(min[j], prices[i] - (j > 0 ? profit[j - 1]: 0));
                profit[j] = Math.max(profit[j], prices[i] - min[j]);
            }
        }

        return profit[k - 1];
    }

       public int maxProfit2(int[] prices) {
        int res = 0, l = prices[0];

        for(int cur: prices){
            if(cur < l) l = cur;
            else if(cur > l){
                res += cur - l;
                l = cur;
            }
        }

        return res;
    }
}