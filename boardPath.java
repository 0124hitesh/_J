import java.util.*;
public class Main {
	public static void printWays(String s, int ci, int sum, int n){
        
        if(sum > n)
            return;

        if(sum == n){
            System.out.println(s);
            return;
        }
        
        for(int i=1; i <= n; ++i){
            printWays(s + i, i, sum + i, n);
        }
    }
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc=new Scanner(System.in);
		// int n = sc.nextInt();
		// int m = sc.nextInt();

        int n = 3;
        int m = 3;

		printWays("", 0, 0, 4);
    }
}
