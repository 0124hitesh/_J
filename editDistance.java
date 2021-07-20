import java.util.*;
import java.util.regex.*;
public class Main {
	public static int codeWar(int i1, int i2, String s1, String s2, int[][] dp){
        if(i1 == 0 && i2 == 0)
            return 0;
        
        if(i1 == 0)
            return i2; 

        if(i2 == 0)
            return i1;
        
        if(dp[i1][i2] != -1)
            return dp[i1][i2];

        if(s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
            return codeWar(i1 - 1, i2 - 1, s1, s2, dp);

        int ins = codeWar(i1, i2 - 1, s1, s2, dp);
        int rep = codeWar(i1 - 1, i2 - 1, s1, s2, dp);
        int del = codeWar(i1 - 1, i2, s1, s2, dp);

        return dp[i1][i2] = 1 + Math.min(ins, Math.min(rep, del));
    }
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc=new Scanner(System.in);

        int i = 0;
        String s=sc.nextLine();
		// String s2 = sc.nextLine();
        String[] arr=new String[2];
        Pattern pattern = Pattern.compile("\"(.*?)\"");
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()) {
           arr[i] = matcher.group();
           ++i;
        }

		int[][] dp=new int[ arr[0].length() + 1][ arr[1].length() + 1];
		for(int[] row : dp)
			Arrays.fill(row, -1);
        System.out.println(codeWar(arr[0].length(), arr[1].length(), arr[0], arr[1], dp));
    }
}
