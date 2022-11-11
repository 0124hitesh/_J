// 1. Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree

// 2. Once the node is found, have to handle the below 4 cases

// * node doesn't have left or right - return null
// * node only has left subtree- return the left subtree
// * node only has right subtree- return the right subtree
// * node has both left and right - find the minimum value in the right subtree, 
//   set that value to the currently found node, 
//   then recursively delete the minimum value in the right subtree

class Solution {
    class TreeNode{
        TreeNode left, right;
        int val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode min = min(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val); 
        }

        return root;
    }

    private TreeNode min(TreeNode node){
		while(node.left != null){
            node = node.left;
        }
        return node;
	}
}