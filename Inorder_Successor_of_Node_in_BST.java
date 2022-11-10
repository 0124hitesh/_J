import java.util.*;

class Solution {
	class Node{
		Node left, right, next;
	}
	Node findSuccessor(Node root, Node p) {
		Stack<Node> s = new Stack<>();
		
		Node cur = root;
		while(!s.isEmpty() || cur != null){
			while(cur != null){
				s.push(cur);
				cur = cur.left;
			}
			cur = s.pop();
			if(cur == p){
				cur = cur.right;
				while(cur != null){
					s.push(cur);
					cur = cur.left;
				}
				return s.isEmpty() ? null: s.pop();
			}
			cur = cur.right;
		}
		
		return null;
	}
}