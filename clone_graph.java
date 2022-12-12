// https://leetcode.com/problems/clone-graph/description/

import java.util.*;

class Solution {
    Node[] vis;

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        vis = new Node[101];
        return dfs(node);
    }

    Node dfs(Node node){
        int val = node.val;
		if(vis[val] != null) return vis[val];
		
		Node res = new Node(val);
        vis[val] = res;
		ArrayList<Node> l = new ArrayList<>();
		
		for(Node x: node.neighbors){
			Node ans = dfs(x);
			if(ans != null)
				l.add(ans);
		}
		res.neighbors = l;
		
		return res;
	}
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}