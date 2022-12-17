// https://workat.tech/problem-solving/practice/m-coloring-problem

class Solution {
	
	boolean isColoringPossible(int[][] adjMatrix, int m) {
		int n = adjMatrix.length;
		for(int i = 0; i < n; i++) {
			if(adjMatrix[i][i] == 1) {
				return false;
			}
		}
		
		int[] color = new int[n];
		
		return isColoringPossible(0, m, color, adjMatrix);
	}
	
	boolean isColoringPossible(int in, int m, int[] color, int[][] adjMatrix){
		if(in == adjMatrix.length) return true;
		
		for(int i = 1; i<= m; ++i){
			if(canColor(in, i, color, adjMatrix)){
				color[in] = i;
				
				if(isColoringPossible(in + 1, m, color, adjMatrix))
					return true;
				
				color[in] = 0;
			}
		}
		
		return false;
	}
	
	boolean canColor(int in, int c, int[] color, int[][] adjMatrix){
		for(int i = 0; i < adjMatrix.length; ++i){
			if(adjMatrix[in][i] == 1 && c == color[i])
				return false;
		}
		
		return true;
	}
}