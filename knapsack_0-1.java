import java.util.*;
public class Main {
    public static int maxValue(int ci, int cap, int[] size, int[] val, int[][] dp){
        if(ci == -1 || cap == 0)
            return 0;

        if(dp[ci][cap] != -1)
            return dp[ci][cap];

        System.out.println("val = "+val[ci] + " cap = "+cap);
        if(size[ci] > cap)
            return dp[ci][cap] = maxValue(ci - 1, cap, size, val, dp);
        int inc = val[ci] + maxValue(ci - 1, cap - size[ci], size, val, dp);
        int exc = maxValue(ci - 1, cap, size, val, dp);

        return dp[ci][cap] = Math.max(inc, exc);
    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int cap = sc.nextInt();

		int[] size=new int[n];
		int[] val=new int[n];

		for(int i=0; i<n; ++i)
			size[i] = sc.nextInt();

		for(int i=0; i<n; ++i)
			val[i] = sc.nextInt();  

        int[][] dp=new int[n+1][cap + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(maxValue(n-1, cap, size, val, dp));
    }
}
