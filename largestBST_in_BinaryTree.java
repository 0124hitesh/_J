// Given a binary tree containing one or more BSTs, find the size of the the largest BST subtree.

// Size of the Largest BST in a Binary Tree

// PREMIUM
class Solution {

    class Node{
        Node left, right;
        int data;
    }

	int getLargestBstSize(Node root) {
	     int[] res = isBST(root);
        return res[0];
	}
	
	 private static int[] isBST(Node root){
        if(root == null){
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        
        int[] left = isBST(root.left);
        int[] right = isBST(root.right);
        
        if(root.data > left[2] && root.data < right[1]){
            int size = left[0] + right[0] + 1;
            return new int[]{size, Math.min(left[1],root.data), Math.max(right[2], root.data)};
        }
     
        return new int[]{Math.max(left[0], right[0]), Integer.MIN_VALUE, Integer.MAX_VALUE};
    }
	
}