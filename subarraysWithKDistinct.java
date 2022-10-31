/*
Given an integer array nums and an integer k, 
return the number of good subarrays of nums.

A good array is an array where 
the number of different integers in that array is exactly k.


Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: 
[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]


Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length  ####IMPORTANT

 */

class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }
    private int atMostK(int[] A, int K) {
        int ans = 0;
        int[] count = new int[A.length + 1];

        for (int l = 0, r = 0; r < A.length; ++r) {
            if (++count[A[r]] == 1) --K;
            while (K == -1)
                if (--count[A[l++]] == 0) ++K;
            ans += r - l + 1;
        }

        return ans;
    }

    // int atMostK(int[] arr, int k){
    //     Map<Integer, Integer> m = new HashMap<>();
    //     int res = 0, pre = 0;

    //     for(int i = 0; i < arr.length; ++i){
    //         int t = arr[i];

    //         if(m.containsKey(t)){
    //             m.put(t, m.get(t) + 1);
    //         }
    //         else{
    //             while(m.size() == k){
    //                 int x = m.get(arr[pre]);
    //                 if(x == 1) m.remove(arr[pre]);
    //                 else m.put(arr[pre], x - 1);
    //                 ++pre;
    //             }
    //             m.put(t, 1);
    //         }
    //         res += i - pre + 1;
    //     }

    //     return res;
    // }
}