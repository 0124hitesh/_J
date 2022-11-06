import java.util.*;

class Solution {
    List<List<String>> res;
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        board = new char[n][n];
        for(char[] c: board){
            Arrays.fill(c, '.');
        }
        solveQ(0);
        return res;
    }

    void solveQ(int r){
        if(r == board.length){
            res.add(ans());
            return;
        }

        for(int c = 0; c < board.length; ++c){
            if(check(r, c)){
                board[r][c] = 'Q';
                solveQ(r + 1);
                board[r][c] = '.';
            }
        }
    }
    
    private boolean check(int r, int c) {
        for(int i = 0; i < r; i++) {
            if(board[i][c] == 'Q') return false;
        }
        for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }
        
        for(int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
        
        return true;
    } 
    
    List<String> ans(){
        List<String> l = new ArrayList<>();
        for(char[] c: board){
            l.add(new String(c));
        }
        return l;
    }

    public static void main(String...args){
        int n = 4;
        Solution o = new Solution();
        o.solveNQueens(n);
        for(List<String> l: o.res)
            System.out.println(l);
    }
}