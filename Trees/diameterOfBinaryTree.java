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

// TC -> O(N)
// SC -> O(N)
// we can make dia a global variable or we can pass it as array reference int[] dia = {0}; and then our height function will become height(node, dia) and then return dia
class Solution {
    int diameter = 0;

    int height(TreeNode node){
        if(node == null) return 0;

        int lh = height(node.left);
        int rh = height(node.right);

        diameter = Math.max(diameter, lh + rh);

        return Math.max(lh, rh) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
}