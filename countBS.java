import java.util.*;
public class Main {
	public static long count(char prev, int cou, int n, long[] dp){
        if(cou == n)
            return 1;
        
        long _0 = 0;
        long _1 = 0;

		if(prev == '0' || prev == ' ')
            _1 = count('1', cou + 1, n, dp);

		if(dp[cou] != -1)
			return dp[cou] + _1;
		else
        	_0 = dp[cou] = count('0', cou + 1, n, dp);

        return _0 + _1;

    }
    public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();

		while(t-- > 0){
			int n=sc.nextInt();

			long[] dp=new long[n];
			Arrays.fill(dp, -1);

			System.out.println(count(' ', 0, n, dp));
		}
    }
}