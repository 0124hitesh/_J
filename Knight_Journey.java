import java.util.*;

// https://workat.tech/problem-solving/practice/knights-journey-chessboard

class Solution {
	int minMovesRequired(int n, Cell start, Cell end) {
    	int[][] shortPath = new int[n + 1][n + 1];
		for(int[] x: shortPath) Arrays.fill(x, -1);
		
		Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start.x, start.y});
        shortPath[start.x][start.y] = 0;

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];

            for(int i = Math.max(1, x - 2); i <= Math.min(n, x + 2); ++i){
                for(int j = Math.max(1, y - 2); j <= Math.min(n, y + 2); ++j){
                    if(shortPath[i][j] == -1 && i != x && j != y && Math.abs(x - i) + Math.abs(y - j) == 3){
                        shortPath[i][j] = shortPath[x][y] + 1;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }

        return shortPath[end.x][end.y];
	}
}

class Cell {
	public int x, y;
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}