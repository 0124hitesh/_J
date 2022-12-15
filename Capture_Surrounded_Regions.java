// Surrounded Regions

class Solution {
	boolean[][] vis;
	
	char[][] getFinalBoard(char[][] board) {
    	int r = board.length;
        int c = board[0].length;
        vis = new boolean[board.length][board[0].length];

        for(int i = 0; i < r; ++i){
            if(!vis[i][0] && board[i][0] == 'O')
                check(i, 0, board);

            if(!vis[i][c - 1] && board[i][c - 1] == 'O')
                check(i, c - 1, board);
        }

        for(int j = 0; j < c; ++j){
            if(!vis[0][j] && board[0][j] == 'O')
                check(0, j, board);

            if(!vis[r - 1][j] && board[r - 1][j] == 'O')
                check(r - 1, j, board);
        }

        for(int i = 0; i < r; ++i)
            for(int j = 0; j < c; ++j){
                if(!vis[i][j] && board[i][j] =='O') board[i][j] = 'X';
            }
		
		return board;
	}
	
	void check(int x, int y, char[][] board){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) return;

        if(board[x][y] == 'X' || vis[x][y]) return;

        vis[x][y] = true;;

        check(x - 1, y, board);
        check(x, y - 1, board);
        check(x + 1, y, board);
        check(x, y + 1, board);
    }
}