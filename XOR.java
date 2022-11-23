public class XOR {
    
    // Single Number III
    // Given an integer array nums, 
    // in which exactly two elements appear only once and 
    // all the other elements appear exactly twice. 
    // Find the two elements that appear only once. 

    // https://www.youtube.com/watch?v=pnx5JA9LNM4
    // ### Important
    public int[] singleNumber(int[] nums) {
        int xxory = 0;
        for(int i: nums) xxory ^= i;

        // get Right Set Bit Mask
        int rsbm = xxory & -xxory;
        int x = 0, y = 0;
        for(int i: nums){
            if((i & rsbm) == 0) x^= i;
            else y ^= i;
        }

        return new int[]{x, y};
    }

    // Repeat and Missing Number in Array
    // You are given a list nums of size n. Each number in nums lies from 1 to n.
    // Each integer appears exactly once, except x which appears twice,
    // and y which doesn't appear at all.

    // https://www.youtube.com/watch?v=MvklwzVz654&t=107s
    int[] findRepeatAndMissingNumber(int[] nums) {
        int xxory = 0;
		for(int i: nums) xxory ^= i;
		for(int i = 1; i <= nums.length; ++i) xxory ^= i;
		
		int rsbm = xxory & -xxory;
        int x = 0, y = 0;
        for(int i: nums){
            if((i & rsbm) == 0) x^= i;
            else y ^= i;
        }
		for(int i = 1; i <= nums.length; ++i){
            if((i & rsbm) == 0) x^= i;
            else y ^= i;
        }
		
		for(int i: nums){
			if(x == i) return new int[]{x, y};
			else if(y == i) return new int[]{y, x};
		}
		
		return new int[0];
    }
}
