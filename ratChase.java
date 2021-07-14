import java.util.*;
public class Main {

    static boolean isPath = false;

    public static void printPath(int cc, int cr, String[] arr, int[][] out){
        if(cc < 0 || cc >= arr[0].length() || cr < 0 || cr >= arr.length || arr[cr].charAt(cc) == 'X' || out[cr][cc] == 1){
            return;
        }

        if(cc == arr[0].length() -1 && cr == arr.length-1){
            out[cr][cc] = 1;
            for(int[] row : out){
                for(int x : row)
                    System.out.print(x + " ");
                System.out.println();

                isPath = true;
            }
            return;
        }

        out[cr][cc] = 1;

        printPath(cc - 1, cr, arr, out); // L
        printPath(cc + 1, cr, arr, out); // R
        printPath(cc, cr - 1 , arr, out); // U
        printPath(cc, cr + 1 , arr, out); // D

        out[cr][cc]= 0;

    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();

        String[] arr=new String[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextLine();
        
        int[][] out=new int[n][m];

        printPath(0, 0, arr, out);
        System.out.println(isPath ? "":"NO PATH FOUND");
    }
}
