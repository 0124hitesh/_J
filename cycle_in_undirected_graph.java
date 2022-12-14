import java.util.*;

class Solution {
	boolean[] vis;
	
    boolean isCyclic(ArrayList<Integer>[] adjList) {
		vis = new boolean[adjList.length];
		
        for(int i = 0; i < adjList.length; ++i)
			if(!vis[i] && isCyclic(i, -1, adjList))
				return true;
		
		return false;
    }
	
	boolean isCyclic(int i, int parent, ArrayList<Integer>[] adjList){
		
		vis[i] = true;
		
		for(int x: adjList[i]){
			if(!vis[x]){
				if(isCyclic(x, i, adjList)) return true;
			}
			else if(x != parent) return true;
		}
		
		return false;
	}
}