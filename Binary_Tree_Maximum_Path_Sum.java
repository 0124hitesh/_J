
class Solution {

    class TreeNode{
        TreeNode left, right;
        int val;
    }
    
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        mp(root);
        return res;
    }

    int mp(TreeNode root){
        if(root == null) return 0;

        int left = mp(root.left);
        int right = mp(root.right);

        int sum = root.val;
        if(left > 0) sum += left;
        if(right > 0) sum += right;
        if(sum > res) res = sum;

        int temp = Math.max(left, right);
        return temp > 0 ? root.val + temp : root.val;
    }
}