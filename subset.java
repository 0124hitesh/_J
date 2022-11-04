import java.util.*;

// return all possible subsets (the power set).

// The solution set must not contain duplicate subsets.

class Solution {
    List<List<Integer>> res;

    // Given an integer array nums of unique elements
    // Input: nums = [1,2,3]
    // Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        ss(new ArrayList<>(), nums, 0);
        return res;
    }

    void ss(List<Integer> l, int[] nums, int pt) {
        res.add(new ArrayList<>(l));
        for (int i = pt; i < nums.length; ++i) {
            l.add(nums[i]);
            ss(l, nums, i + 1);
            l.remove(l.size() - 1);
        }
    }

    // Given an integer array nums that may contain duplicates
    // Input: nums = [1,2,2]
    // Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        ss(0, nums, new ArrayList<>());
        return res;
    }

    void ss(int pt, int[] nums, List<Integer> l) {
        res.add(new ArrayList<>(l));
        for (int i = pt; i < nums.length; ++i) {
            if (i > pt && nums[i] == nums[i - 1]) continue;
            l.add(nums[i]);
            ss(i + 1, nums, l);
            l.remove(l.size() - 1);
        }
    }
}