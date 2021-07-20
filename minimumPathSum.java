import java.util.*;
public class Main {
	public static void printWays(String s, int sum, int m, int n){
        if(sum > n)
            return;

        if(sum == n){
            System.out.print(s + " ");
            return;
        }
        
        for(int i=1; i <= m; ++i)
            printWays(s + i, sum + i, m, n);

    }
	public static int countWays(int sum, int m, int n){
        if(sum > n)
            return 0;

        if(sum == n)
            return 1;
        
		int x = 0; 
        for(int i=1; i <= m; ++i)
            x += countWays(sum + i, m, n);

		return x;

    }
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		printWays("", 0, m, n);
		System.out.println("\n" + countWays(0, m, n));
    }
}
