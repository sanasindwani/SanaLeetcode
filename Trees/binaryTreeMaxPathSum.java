/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    int sum(TreeNode node){
        if(node == null) return 0;

        int lh = sum(node.left);
        int rh = sum(node.right);
        if(lh < 0) lh = 0;
        if(rh < 0) rh = 0;
        // we can do lh = Math.max(0, sum(node.left))
        // similarly rh = Math.max(0, sum(node.right))
        max = Math.max(lh + rh + node.val, max);

        return Math.max(lh, rh) + node.val;
    }
    public int maxPathSum(TreeNode root) {
        sum(root);
        return max;
    }
}