import java.util.*;
public class Main {
    public static int countWays(int ci, int sum, int[] arr, int[][] dp){

        if(sum == 0){
            return 1;
        }
        
        if(ci == -1  || sum < 0)
            return 0;

        if(dp[sum][ci] != -1)
            return dp[sum][ci];

        int inc = countWays(ci , sum - arr[ci], arr, dp);
        int exc = countWays(ci - 1, sum, arr, dp);

        return dp[sum][ci] = inc  + exc;
    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();

        String[] temp = sc.nextLine().split(" ");
        // int n=10;
        // int m=4;
        // String temp[]="2 5 3 6".split(" ");

        int[] arr=new int[temp.length];
        for(int i=0; i<arr.length; ++i)
            arr[i] = Integer.valueOf(temp[i]);

        int[][] dp=new int[n + 1][m  + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(countWays(arr.length - 1, n, arr, dp));
    }
}
