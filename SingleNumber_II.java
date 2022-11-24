// Given an integer array nums where every element appears three times except for one, 
// which appears exactly once. Find the single element and return it.

// implement a solution with a linear runtime complexity and 
// use only constant extra space.

class Solution {
    public int singleNumber(int[] nums) {
        // r0 = Integer.MAX_VALUE
        int r0 = -1, r1 = 0, r2 = 0;

        for(int i: nums){
            // till count of 1
            // can be 3n | 3n + 1 | 3n + 2
            // (3n) + 1 = 3n + 1
            // (3n + 1) + 1 = 3n + 2
            // (3n + 2) + 1 = 3n
            int temp_r0 = r0 & i;
            int temp_r1 = r1 & i;
            int temp_r2 = r2 & i;

            // 1's complement of x = ~x
            r0 = r0 & (~temp_r0);
            r1 = temp_r0 | r1;

            r1 = r1 & (~temp_r1);
            r2 = temp_r1 | r2;

            r2 = r2 & (~temp_r2);
            r0 = temp_r2 | r0;
        }

        return r1;
    }

    public static void main(String...args){
        int[] arr = {};

        System.out.println(new Solution().singleNumber(arr));
    }
}