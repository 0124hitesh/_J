// https://workat.tech/problem-solving/practice/word-search-board

class Solution {
	int r, c;
	
	boolean wordExists(char[][] board, String word) {
		r = board.length;
		c = board[0].length;
		
		char[] w = word.toCharArray();
		
		for(int i = 0; i < r; ++i){
			for(int j = 0; j < c; ++j){
				if(check(i, j, 0, w, board)) return true;
			}
		}
		return false;
	}
	
	boolean check(int x, int y, int i, char[] word, char[][] board){
		if(i == word.length) return true;
		if(x < 0 || x == r || y < 0 || y == c) return false;
		
		
		if(board[x][y] == word[i]){
			if(check(x + 1, y, i + 1, word, board)) return true;
			if(check(x, y + 1, i + 1, word, board)) return true;
			if(check(x - 1, y, i + 1, word, board)) return true;
			if(check(x, y - 1, i + 1, word, board)) return true;
		}
		
		return false;
	}
}