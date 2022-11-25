import java.util.*;   
// x << i means, x multiply by 2^i

class Solution {
  public int divide(int dividend, int divisor) {
       // when -2^31 is divided by -1 will give 2^31 which doesn't exist so overflow
      if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

      boolean isNeg = (dividend < 0) ^ (divisor < 0);

      dividend = Math.abs(dividend);
      divisor = Math.abs(divisor);

      int quo = 0, i = 0;

      while(dividend - divisor >= 0){
          // wrong
          // for(i = 0; dividend - (divisor << i) >= 0; ++i);
          // --i;

          for(i = 0; dividend - ((divisor << i) << 1) >= 0; ++i);
          quo += 1 << i;
          dividend = dividend - (divisor << i);
      }
      return isNeg ? -quo: quo;
  }

    public static void main(String...args){
      int dividend = 116;
      int divisor = 3;

      System.out.println(new Solution().divide(dividend, divisor));
    }
}
