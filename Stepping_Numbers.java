// Given two numbers begin and end, find all the stepping numbers in the range [begin, end].

// A positive integer is called a stepping number if the adjacent digits have a difference of 1.
//  All single-digit numbers are stepping numbers.

// 123, 121, 654, 5 are all stepping numbers. 124, 122, 46 are not stepping numbers.

// https://workat.tech/problem-solving/practice/stepping-numbers

import java.util.*;

class Solution {
	List<Integer> getSteppingNumbers(int begin, int end) {
		List<Integer> res = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		if(begin == 0) res.add(0);
		
		for(int i = 1; i < 10; ++i) q.add(i);
		
		while(!q.isEmpty()){
			int num = q.poll();
			
			if(num >= begin && num <= end) res.add(num);
			
			int child, lastDigit = num%10;
			num *= 10;
			
			if(lastDigit != 0){
				child = num + lastDigit - 1;
				if(child <= end)
					q.add(child);
			}
			if(lastDigit != 9){
				child = num + lastDigit + 1;
				if(child <= end)
					q.add(child);
			}
			
		}
		
		return res;
	}
}