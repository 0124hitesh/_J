class Solution {

    class Node{
        Node left, right;
        int val;
    }
	Node pre, head;
	Node binaryTreeToDoublyLinkList(Node root) {
	   	pre = null;
		head = null;
		dll(root);
		return head;
	}
	
	void dll(Node root){
		if(root == null) return;
		
		dll(root.left);
		if(pre == null) head = root;
		else{
			root.left = pre;
			pre.right = root;
		}
		
		pre = root;
		dll(root.right);
		
		
	}
}