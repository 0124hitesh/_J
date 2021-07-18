import java.util.*;
public class Main {
    public static int longestSub(int ci, int pi, int[] arr, int[][] dp){

        if(ci  == arr.length )
            return 0;
        
        if(dp[ci][pi + 1] != -1)
            return dp[ci][pi+1];

        int inc = 0;
        if(pi == -1 || arr[pi] < arr[ci])
            inc = 1 + longestSub(ci + 1, ci, arr, dp);
            
        int exc = longestSub(ci + 1, pi, arr, dp);
        return dp[ci][pi + 1] = Math.max(inc , exc);

    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();

        // int[] arr=new int[n];
        // for(int i=0; i<n; ++i)
        //     arr[i]=sc.nextInt();

        int arr[]={4,10,4,3,8,9}; //3
        // int arr[]={10, 22, 9, 33, 21, 50, 41, 60, 80}; //6
        int[][] dp=new int[7][7];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(longestSub(0, -1, arr, dp));
    }
}