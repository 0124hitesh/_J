import java.util.*;
public class Main {
	public static int maxValue(int cr, int cc, int lr, int lc, int[][] arr, int[][] dp){
		if(cr < 0 || cr > lr || cc < 0 || cc > lc)
			return 0;
		
		if(dp[cr][cc] != -1)
			return dp[cr][cc];
			
		int rc = 0;
		if(cc == 0)
			rc += maxValue(cr + 1, cc, lr, lc, arr, dp);

		int ru = arr[cr][cc] + maxValue(cr - 1, cc + 1, lr, lc, arr, dp);
		int rd = arr[cr][cc] + maxValue(cr + 1, cc + 1, lr, lc, arr, dp);
		int rr = arr[cr][cc] + maxValue(cr, cc + 1, lr, lc, arr, dp);

		return dp[cr][cc] = Math.max(Math.max(rr, rc), Math.max(ru, rd));
	}
    public static void main (String args[]) {
		Scanner sc=new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0){
			int n = sc.nextInt();
        	int m = sc.nextInt();

			int[][] arr=new int[n][m];
			for(int i=0; i<n; ++i)
				for(int j=0; j<m; ++j)
					arr[i][j] = sc.nextInt();

			int[][] dp=new int[n][m];
			for(int[] row : dp)
				Arrays.fill(row, -1);

			System.out.println(maxValue(0, 0, n-1, m-1, arr, dp));
		}
    }
}