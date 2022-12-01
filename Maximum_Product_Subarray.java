class Solution {
    public int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];

        min[0] = nums[0]; max[0] = nums[0];
        for(int i = 1; i < nums.length; ++i){
            int m1 = nums[i]*max[i - 1];
            int m2 = nums[i]*min[i - 1];

            max[i] = Math.max(nums[i], Math.max(m1, m2));
            min[i] = Math.min(nums[i], Math.min(m1, m2));
        }

        int res = nums[0];
        for(int x: max) if(x > res) res = x;

        System.out.println(res);
        return res;
    }

    public static void main(String...args){
        int[] arr = {};

        new Solution().maxProduct(arr);
    }
}