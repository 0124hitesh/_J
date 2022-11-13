// Serialization is converting a data structure or object into a sequence of bits 
// so that it can be stored in a file or memory buffer, 
// or transmitted across a network connection link to be reconstructed later in the same or 
// another computer environment.

// Design an algorithm to serialize and deserialize a binary search tree. 
// There is no restriction on how your serialization/deserialization algorithm should work. 
// You need to ensure that a binary search tree can be serialized to a string, and 
// this string can be deserialized to the original tree structure.

// The encoded string should be as compact as possible.
import java.util.*;

class Codec {

    class TreeNode{
        TreeNode left, right;
        int val;

        TreeNode(int val){
            this.val = val;
        }
    }

    public String serialize(TreeNode root) {
        StringBuffer s = new StringBuffer();
        serialize(root, s);
        return s.toString();
    }

    private void serialize(TreeNode root, StringBuffer s){
        if(root == null) return;

        s.append(root.val).append(",");
        serialize(root.left, s);
        serialize(root.right, s);
    }

    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserialize(Queue<String> q, int l, int h){
        if(q.isEmpty()) return null;

        int val = Integer.valueOf(q.peek());
        if(val < l || val > h) return null;

        TreeNode root = new TreeNode(val);
        q.poll();
        root.left = deserialize(q, l, val);
        root.right = deserialize(q, val, h);

        return root;
    } 
}