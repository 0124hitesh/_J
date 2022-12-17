// Is Graph Bipartite

// Solve using M-coloring Problem, where m = 2

import java.util.*;
class Solution {
    public boolean isBipartite(ArrayList<Integer>[] adjList) {
		int[] color = new int[adjList.length];
		Arrays.fill(color, -1);
		
		for(int i = 0; i < adjList.length; ++i){
			if(color[i] == -1 && !canFill(i, color, adjList)){
				return false;
			}
		}
		
		return true;
    }
	
	boolean canFill(int in, int[] color, ArrayList<Integer>[] adjList){
		if(color[in] == -1){
			color[in] = 1;
		}
		
		for(int x: adjList[in]){
			if(color[x] == -1){
				color[x] = 1 - color[in];
				if(!canFill(x, color, adjList)) return false;
			}
			else if(color[x] == color[in]) 
				return false;
		}
		
		return true;
			
	}
}