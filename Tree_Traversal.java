import java.util.*;
class Solution {
	
    class Node{
        Node left, right;
        int data;
    }

    // Inorder Traversal 1
	List<Integer> getInorderTraversal(Node root) {
		List<Integer> l = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        Node cur = root;
        while(cur != null || !s.isEmpty()){
            while(cur != null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            l.add(cur.data);
            cur = cur.right;
        }

        return l;
	}

    // Inorder Traversal 2

    // List<Integer> getInorderTraversal(Node root) {
	// 	List<Integer> res = new ArrayList<>();
	// 	inOrder(root, res);
	// 	return res;
	// }
	// void inOrder(Node head, List<Integer> res){
	// 	if(head == null) return;
		
	// 	inOrder(head.left, res);;
	// 	res.add(head.data);
	// 	inOrder(head.right, res);
		
	// }


    // Pre-Order Traversal 1
    List<Integer> getPreorderTraversal(Node root) {
		List<Integer> l = new ArrayList<>();
        Stack<Node> s = new Stack<>();

        Node cur = root;
        while(cur != null || !s.isEmpty()){
            while(cur != null){
				l.add(cur.data);
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            cur = cur.right;
        }

        return l;
	}

    // Pre-Order Traversal 2

    // List<Integer> ans = new ArrayList<>()
    // public List<Integer> preorderTraversal(Node root) {
    //     traverse(root);
    //     return ans;
    // }

    // public void traverse(Node root) {
    //     if (root == null) return;
    //     ans.add(root.data);
    //     traverse(root.left);
    //     traverse(root.right);
    // }


    // Post-Order Traversal 1
    List<Integer> getPostorderTraversal(Node root) {
    	List<Integer> l = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        
        Node cur = root;
        while(cur != null || !s.isEmpty()){
            while(cur != null){
				l.add(cur.data);
                s.push(cur);
                cur = cur.right;
            }
            cur = s.pop();
			cur = cur.left;
        }
		Collections.reverse(l);
        return l;
	}
}