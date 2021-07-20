import java.util.*;
public class Main {
    public static long friendPair(int n, long[] dp){
        if(n == 1)
            return 1;

        if(n == 2)
            return 2;    

		if(dp[n] != -1)
			return dp[n];    

        return dp[n] = friendPair(n - 1, dp) + friendPair(n - 2, dp) * (n - 1);

    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-- > 0){
            int n=sc.nextInt();

			long[] dp=new long[n + 1];
			Arrays.fill(dp, -1);

            System.out.println(friendPair(n, dp));
        }
    }
}