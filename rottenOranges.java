import java.util.*;

class Solution {
    public int orangesRotting(int[][] g) {
        if(g.length == 0 || g[0].length == 0) return 0;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, n = g.length, m = g[0].length;
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j){
                if(g[i][j] == 1) {++fresh;}
                else if(g[i][j] == 2) {q.offer(new int[]{i, j});}
            }

        if(fresh == 0) return 0;
        int r = 0;
        int[][] M = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        while(!q.isEmpty()){
            ++r;
            int s = q.size();
            for(int i = 0; i < s; ++i){
                int[] cur = q.poll();
                for(int[] t: M){
                    int x = cur[0] + t[0];
                    int y = cur[1] + t[1];
                    if(x < n && x > -1 && y < m && y > -1 && g[x][y] == 1){
                        g[x][y] = 2;
                        q.offer(new int[]{x, y});
                        --fresh;
                    }
                }
            }
        }

        return fresh == 0 ? r-1 : -1;
    }
}