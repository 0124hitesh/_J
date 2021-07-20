import java.util.*;
public class Main {
    public static int maxLen(int ia, int ib, String a, String b, int[][] dp){
        if(ia == -1 || ib == -1)
            return 0;
       
        if(dp[ia][ib] != -1)
            return dp[ia][ib];
            
        int x = 0; int y = 0; int z = 0;
        if(a.charAt(ia) == b.charAt(ib))
            x = 1 + maxLen(ia - 1, ib - 1, a, b, dp);
        else{
            y = maxLen(ia, ib -1, a, b, dp);
            z = maxLen(ia - 1, ib, a, b, dp);
        }

        return dp[ia][ib] = Math.max(x, Math.max(y, z));
    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();

        int[][] dp=new int[a.length()][b.length()];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(maxLen(a.length() - 1, b.length() - 1, a, b, dp));
    }
}
