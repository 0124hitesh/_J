import java.util.*;
public class Main {
    public static long countWays(int n, long[] dp){
        if(n == 0)
            return 1;

        if(n < 0)
            return 0;
        
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = countWays(n - 1, dp) + countWays(n - 3, dp) + countWays(n - 4, dp);
    }
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        // int n=10;
        long[] dp=new long[n+1];
        Arrays.fill(dp, -1);
        System.out.println(countWays(n, dp));
    }
}