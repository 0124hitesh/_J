import java.util.*;

class Main{
    private static boolean isPlaced(int mid, int cows, int[] stalls){
		int cp = stalls[0];
        int cowsPlaced = 1;

        for(int i=1; i<stalls.length; ++i){

            if(stalls[i] - cp >= mid){
                cowsPlaced++;
                cp = stalls[i];
            }

            if(cowsPlaced == cows)
                return true;
        }

        return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// int n = sc.nextInt();
		// int c = sc.nextInt();

		// int[] stalls = new int[n];
		// for(int i=0;i<n;i++)
		// 	stalls[i] = sc.nextInt();
		// Arrays.sort(stalls);

        int n = 5;
        int c = 3;
        int[] stalls = {1,2,4,8,9};

		int l = 0;
        int r = stalls[n - 1] - stalls[0];

        while(r > l+1){
            int mid = (l + r)/2;
            
            if(isPlaced(mid, c, stalls))
                l = mid;
            else
                r = mid;
        }
        System.out.println(l);
	}
}