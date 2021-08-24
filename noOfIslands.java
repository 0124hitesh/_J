import java.util.*;
public class Main {
	boolean[][] ba;
    static int count;
    
    public int numIslands(char[][] grid) {
        ba = new boolean[grid.length][grid[0].length];
        count = 0;
        for(int i=0; i<grid.length; ++i){
            for(int j=0; j<grid[0].length; ++j){
                if(!ba[i][j] && grid[i][j] == '1'){
                    visit(ba, grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }
    
    void visit(boolean[][] ba, char[][] grid , int i, int j){
                if(!ba[i][j] && grid[i][j] == '1'){
                    
                    ba[i][j] = true;
                    if(j < ba[0].length-1 && grid[i][j+1] == '1'){
                        visit(ba, grid, i, j+1);
                    }
                    
                    if(j > 0 && grid[i][j-1] == '1')
                        visit(ba, grid, i, j-1);
                    
                    if(i > 0 && grid[i-1][j] == '1')
                        visit(ba, grid, i-1, j);
                    
                    if(i < ba.length-1 && grid[i+1][j] == '1')
                        visit(ba, grid, i+1, j);
                    
    	}
	}
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        Main ob = new Main();

        char[][] ar = new char[n][m];
        for(int i=0; i<n; ++i){
            String s = sc.nextLine();
            char[] ca = s.toCharArray();

            ar[i] = ca;
        }
		System.out.println(ob.numIslands(ar));
	}
}