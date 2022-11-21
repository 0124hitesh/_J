import java.util.*;
import java.lang.Math.*;
class Math{

    // 1. 
    // Greatest Common Divisor
    int euclideanGCD(int firstNum, int secondNum) {
        if(firstNum == 0) {
            return secondNum;
        }
        return euclideanGCD(secondNum % firstNum, firstNum);
    }
    int gcd(int firstNum, int secondNum) {
        return euclideanGCD(firstNum, secondNum);
    }

    // 2.
    // a^b in O(log n) 
    // Binary Exponentiation
    // https://cp-algorithms.com/algebra/binary-exp.html
    // https://leetcode.com/problems/super-pow/solutions/2412552/java-binary-exponentiation-euler-totient-function-etf-with-explanation/
    int pow(int a, int b){
        int res = 1;

        while(b > 0){
            // if b is odd
            if((b&1) == 1) res = res*a;

            a *= a;
            b >>= 1;
        }
        return res;
    }

    // 3. 
    // Most Significant Bit
    // Given a number n, find the significance of the most significant bit, i.e., 
    // find the greatest number less than or equal to n which is the power of two.
    // int msbSignificance(int n) {
    //     int res = (int)(Math.log(1.0)/Math.log(2.0));
    //      return 1 << res;
    //  }


    // 4.
    // is Power of two
    boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
		
		return (n & (n - 1)) == 0;
    }


    // 5. a
    // Count Set Bits
    //  count the number of set bits in the binary representation of n.
    int countSetBits(int n){
		int ans = 0;
		int x = 1;
		for(int i = 0; i < 31; ++i){
			if((n&x) != 0){
				x = x << 1;
				++ans;
			} 
		}
		return ans;
    }

    // 5. b
    // Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
    // ans[i] is the number of 1's in the binary representation of i.
    // Input: n = 2
    // Output: [0,1,1]
    // Explanation:
    // 0 --> 0
    // 1 --> 1
    // 2 --> 10

    // An easy recurrence for this problem is res[i] = res[i / 2] + i % 2.
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i = 1; i <= n; ++i){
            res[i] = res[i >> 1] + (i&1);
        }

        return res;
    }
    public static void  main(String...args){

        Math o = new Math();
        
        System.out.println();
    }
}