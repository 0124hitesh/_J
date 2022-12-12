// https://workat.tech/problem-solving/practice/bfs-of-graph

import java.util.*;

class Solution {
    ArrayList<Integer> bfs(ArrayList<Integer>[] adjList) {
		ArrayList<Integer> res = new ArrayList<>();
		if(adjList.length == 0) return res;
		
        Queue<Integer> q = new LinkedList<>();
		boolean[] b = new boolean[adjList.length];
		q.add(0);
		
		while(!q.isEmpty()){
			int i = q.poll();
			if(b[i]) continue;
			res.add(i);
			b[i] = true;
			for(int x: adjList[i]){
				q.add(x);
			}
		}
		
		return res;
		
    }
}