import java.util.*;
public class Main {
    public static int minPath(int n, int m, int[][] arr, int[][] dp){
        if(n == arr.length - 1 && m == arr[0].length - 1)
            return arr[n][m];

        if(n == arr.length || m == arr[0].length)
            return Integer.MAX_VALUE;

        if(dp[n][m] != -1)
            return dp[n][m];

        int right =  minPath(n + 1, m, arr, dp);
        int down = minPath(n, m + 1, arr, dp);
        
        return dp[n][m] = arr[n][m] + Math.min(right, down);
    }
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr=new int[n][m];
        for(int i=0; i<n; ++i)
            for(int j=0; j<m; ++j)
                arr[i][j] = sc.nextInt();
            
        int[][] dp=new int[n][m];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(minPath(0, 0, arr, dp));
    }
}
