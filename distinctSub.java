import java.util.*;
public class Main{
    public static int printWays(int tl, String t, int sl, String s, int[][] dp){
        if(tl == -1)
            return 1;
        
        if(sl == -1)
            return 0;

        if(dp[tl][sl] != -1)
            return dp[tl][sl];

        int inc = 0;
        if(s.charAt(sl) == t.charAt(tl))
            inc = printWays(tl - 1, t, sl - 1, s, dp);
        
        int exc = printWays(tl, t, sl - 1, s, dp);

        return dp[tl][sl] = inc + exc;
    }
    public static void main(String...args){

        String s = "rabbbit";
        String t = "rabbit";

        int[][] dp=new int[t.length() + 1][s.length() + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(printWays(t.length() - 1, t, s.length() - 1, s, dp));
    }
}