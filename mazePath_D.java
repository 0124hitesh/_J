import java.util.*;
public class Main {
    static void printPath(int col, int row, String s, int lr, int lc){
        if(row >= lr || col >= lc)
            return;
        
        if(row == lr-1 && col == lc-1){
            System.out.print(s + " ");
            return;
        }

        printPath(col, row + 1, s + "V", lr, lc);
        printPath(col + 1, row, s + "H", lr, lc);
        printPath(col + 1, row + 1, s + "D", lr, lc);

    }
    
    static int countPath(int col, int row, int lr, int lc){
        if(row >= lr || col >= lc)
            return 0;
        
        if(row == lr-1 && col == lc-1)
            return 1;

        return 
        countPath(col, row + 1, lr, lc) +
        countPath(col + 1, row, lr, lc) +
        countPath(col + 1, row + 1, lr, lc);

    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();

        printPath(0, 0, "", row, col);
        System.out.println("\n" + countPath(0, 0, row, col));
    }
}
