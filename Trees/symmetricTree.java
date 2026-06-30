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

// Tc -> O(N)
// Sc -> O(H) recursion stack
class Solution {
    boolean sana(TreeNode l, TreeNode r){
        if(l == null || r == null){
            return l == r;
        }

        if(l.val != r.val) return false;
        // wrong condition things should be mirrored 
        // if so opposite conditions should match
        /*boolean lef = sana(l.left, r.left);
        boolean rig = sana(l.right,r.right);*/
        boolean lef = sana(l.left, r.right);
        boolean rig = sana(l.right,r.left);
        return (lef && rig);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return sana(root.left, root.right);
    }
}