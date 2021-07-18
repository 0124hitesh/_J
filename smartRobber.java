import java.util.*;
public class Main {
    public static int maxAmount(int ci, int n, int[] arr, int[] dp){
        if(ci >= n)
            return 0;

		if(dp[ci] != -1)
			return dp[ci];
        int inc = arr[ci] + maxAmount(ci + 2, n, arr,dp);
        int exc = maxAmount(ci + 1, n, arr, dp);

        return dp[ci] = Math.max(inc, exc);
    }
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();

		while(t-- > 0){
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0; i<n; ++i)
				arr[i]=sc.nextInt();

			int[] dp=new int[n];
			Arrays.fill(dp, -1);
        	System.out.println(maxAmount(0, n, arr, dp));
		}
    }
}