import java.util.*;

class Solution {
	boolean[] dp, vis;
	
    boolean isCyclic(ArrayList<Integer>[] adjList) {
        dp = new boolean[adjList.length];
        vis = new boolean[adjList.length];
		
		for(int i = 0; i < adjList.length; ++i){
			if(traverse(i, adjList)) return true;
		}
		return false;
    }
	
	boolean traverse(int i, ArrayList<Integer>[] adjList){
		if(vis[i]) return true;
		if(dp[i]) return false;
		
		vis[i] = true;
		dp[i] = true;
		for(int x: adjList[i]){
			if(traverse(x, adjList)) return true;
		}
		
		return vis[i] = false;
	}
}