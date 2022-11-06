// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> l = new ArrayList<>();
        int fact = 1;
        for(int i = 1; i < n; ++i){
            l.add(i);
            fact *= i;
        }
        l.add(n);
        --k;
        StringBuilder s = new StringBuilder();
        while(true){
            int t = l.remove(k/fact);
            s.append(t);
            if(l.size() == 0) break;

            k = k%fact;
            fact /= l.size();
        }

        return s.toString();
    }
    public static void main(String...args) {
        int n = 3;
        System.out.println(new Solution().getPermutation(n, 3));
    }
}