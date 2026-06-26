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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }
}
/*class Solution {
    int depth(TreeNode node){
        if(node == null) return 0;

        int l = 0, r = 0;

        l = 1 + depth(node.left);
        r = 1 + depth(node.right);

        return Math.max(l,r);
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return depth(root);
    }
}*/