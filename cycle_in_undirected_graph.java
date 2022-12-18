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

	// Find Cycle using union-find method
	// https://www.youtube.com/watch?v=mHz-mx-8lJ8

	// boolean isCyclic(int n, int edges[][]) {
    //     int[] parent = new int[501];
	// 	for(int i = 0; i < 501; ++i) parent[i] = i;
		
	// 	for(int[] edge: edges){
	// 		int aParent = findParent(edge[0], parent);
	// 		int bParent = findParent(edge[1], parent);
			
	// 		if(aParent == bParent) return true;
	// 		parent[aParent] = bParent;
	// 	}
		
	// 	return false;
    // }
	
	// int findParent(int n, int[] parent){
	// 	if(n != parent[n]){
	// 		parent[n] = findParent(parent[n], parent);
	// 	}
		
	// 	return parent[n];
	}
}