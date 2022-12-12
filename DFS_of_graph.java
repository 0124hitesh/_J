// https://workat.tech/problem-solving/practice/dfs-of-acyclic-graph

import java.util.*;

class Solution {
	boolean[] b;
	
    ArrayList<Integer> dfs(ArrayList<Integer>[] adjList) {
		b = new boolean[adjList.length];
		ArrayList<Integer> res = new ArrayList<>();
		dfs(0, adjList, res);
		
		return res;
    }
	
	void dfs(int root, ArrayList<Integer>[] adjList, ArrayList<Integer> res){
		if(b[root]) return;
		
		res.add(root);
		b[root] = true;
		
		for(int x: adjList[root]){
			dfs(x, adjList, res);
		}
	}
}