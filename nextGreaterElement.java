import java.util.*;

// Given an array of positive integers A, 
// find the first greater number for every element on its right. 
// If a greater number does not exist, use -1.

class Solution {
	int[] getNextGreaterElement (int[] A) {
		Stack<Integer> s = new Stack<>();
		int[] res = new int[A.length];
		Arrays.fill(res, -1);
		
		for(int i = 0; i < A.length; ++i){
			while(!s.isEmpty() && A[s.peek()] < A[i])
                res[s.pop()] = A[i];

            s.push(i);
		}

        return res;
	}
}