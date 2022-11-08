import java.util.*;
class Solution {
	class Node{
		Node left, right;
		int data;
	}

	// #############
	// Level Order of Tree
	List<Integer> getLevelOrderTraversal(Node root) {
		Queue<Node> q = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		
		q.offer(root);
		while(!q.isEmpty()){
			for(int i = 0; i < q.size(); ++i){
				if(q.peek().left != null) q.offer(q.peek().left);
				if(q.peek().right != null) q.offer(q.peek().right);
				res.add(q.poll().data);
			}
		}
		
		return res;
	}
	// List<Integer> getLevelOrderTraversal(Node root) {
	// 	Queue<Node> q = new LinkedList<>();
	// 	List<Integer> res = new ArrayList<>();
		
	// 	q.offer(root);
	// 	while(!q.isEmpty()){
	// 		Node cur = q.poll();
	// 		res.add(cur.data);
	// 		if(cur.left != null) q.offer(cur.left);
	// 		if(cur.right != null) q.offer(cur.right);
				
	// 	}
		
	// 	return res;
	// }


	// #########
	// Depth of Binary Tree

	int getMaxDepth(Node root) {
    	if(root == null) {
			return 0;
		}
		int leftSubtreeDepth = getMaxDepth(root.left);
		int rightSubtreeDepth = getMaxDepth(root.right);
		return Math.max(leftSubtreeDepth, rightSubtreeDepth) + 1;
	}


	// ############
	// Diameter of Binary Tree

	int dia;
	int getDiameter(Node root) {
		dia = 0;
		dfs(root);	
		return dia;
	}
	
	int dfs(Node root){
		if(root == null) return 0;
		
		int a = dfs(root.left);
		int b = dfs(root.right);
		dia = Math.max(dia, a + b);
		
		return Math.max(a, b) + 1;
	}
	

	// ########
	// Symentic Binary tree

	boolean isSymmetric(Node root) {
		return root == null || dfs(root.left, root.right);
	}
	
	boolean dfs(Node left, Node right){
		if(left == null || right == null)
			return left == right;
		
		if(left.data != right.data) return false;
	
		return dfs(left.left, right.right) && dfs(left.right, right.left);
	}

	// ######
	// Invert Binary Tree
	void invertTree(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()){
			Node n = q.poll();
			Node l = n.left;
			n.left = n.right;
			n.right = l;
			
			if(n.left != null) q.offer(n.left);
			if(n.right != null) q.offer(n.right);
		}
	}


	// ######## LCA - Lowest Common Ancestor of a Binary Tree

	public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null || root == p || root == q) return root;
		
		Node l = lowestCommonAncestor(root.left, p, q);
		Node r = lowestCommonAncestor(root.right, p, q);
		
		if(l != null && r != null) return root;
		
		return l != null ? l: r;
    }
}