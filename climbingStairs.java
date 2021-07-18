import java.util.*;
public class Main {
    public static int countWays(int n, int[] dp){
        if(n == 0)
            return 1;

        if(n < 0)
            return 0;

        if(dp[n] != -1)
            return dp[n];
        int inc = countWays(n - 1, dp);
        int exc = countWays(n - 2, dp);

        return dp[n] = inc + exc;
    }
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        // int n = sc.nextInt();

        int n=2;
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(countWays(n, dp));
    }
}