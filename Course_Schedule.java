// https://leetcode.com/problems/course-schedule/description/

import java.util.*;

class Solution {
    boolean[] dp, vis;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; ++i)
            graph[i] = new ArrayList<>();

        for(int[] x: prerequisites)
           graph[x[1]].add(x[0]);

         dp = new boolean[numCourses];
         vis = new boolean[numCourses];

        for(int i=0; i < numCourses; ++i){
            if(isCycle(i, graph)) return false;
        }

        return true;
    }

    boolean isCycle(int i, ArrayList<Integer>[] graph){
		if(vis[i]) return true;
		if(dp[i]) return false;
		
		vis[i] = true;
		dp[i] = true;
		for(int x: graph[i]){
			if(isCycle(x, graph)) return true;
		}
		
		return vis[i] = false;
	}
}