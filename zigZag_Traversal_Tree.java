import java.util.*;

class Solution {

    class TreeNode{
        TreeNode left, right;
        int val;
    }
    List<List<Integer>> res;
    boolean b;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;
        b = true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            LinkedList<Integer> l = new LinkedList<>();
            int size = q.size();
            for(int i = 0; i < size; ++i){
                    TreeNode temp = q.poll();
                    if(temp.left != null) q.offer(temp.left);
                    if(temp.right != null) q.offer(temp.right);

                    if(b) l.add(temp.val);
                    else l.addFirst(temp.val);
                }
            res.add(l);
            b = !b;
        }

        return res;
    }
}