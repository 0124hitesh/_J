import java.util.*;

// ### important

public class Main {
    // public static int longestSub(int ci, int pi, int[] arr, int[][] dp){

    //     if(ci  == arr.length )
    //         return 0;
        
    //     if(dp[ci][pi + 1] != -1)
    //         return dp[ci][pi+1];

    //     int inc = 0;
    //     if(pi == -1 || arr[pi] < arr[ci])
    //         inc = 1 + longestSub(ci + 1, ci, arr, dp);
            
    //     int exc = longestSub(ci + 1, pi, arr, dp);
    //     return dp[ci][pi + 1] = Math.max(inc , exc);

    // }

    // Method - 2
    // public int longestSub2(int[] nums) {
    //     int max = 1;

    //     int[] s = new int[nums.length+1];
    //     s[1] = nums[0];
        
    //     for (int a : nums) {
    //         if (a > s[max]) {
    //             max++;
    //             s[max] = a;
    //         }
    //         else {
    //             int x = max;
    //             while(--x > 0) {
    //                 if (a > s[x]) break;
    //             }
    //             s[x+1] = a;
    //         }
    //     }
    //     return max;
    // }

    // Method - 3
    int lengthOfLIS(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;

        int res = 0;
        for(int i = 0; i < dp.length; ++i){
            int max = 0;

            for(int j = 0; j < i; ++j){
                if(arr[j] < arr[i]){
                    if(dp[j] > max) max = dp[j];
                }
            }

            dp[i] = 1 + max;
            if(res < dp[i]) res = dp[i];
        }

        return res;
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);

        int arr[]={10, 22, 9, 33, 21, 50, 41, 60, 80}; //6
        // int[][] dp=new int[arr.length + 1][arr.length + 1];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        System.out.println(new Main().lengthOfLIS(arr));
    }
}