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
class Solution {
    int height(TreeNode node){
        if(node == null) return 0;

        int l = height(node.left);
        int r = height(node.right);

        if(l == -1 || r == -1) return -1;
        if(Math.abs(l - r) > 1) return -1;

        return Math.max(l, r) + 1;
    }

    public boolean isBalanced(TreeNode root) {
       /* if(root == null) return true;
        if(height(root) == -1) return false;
        return true; */
        return height(root) != -1;
    }
}

// Two recursive calls O(N^2) time complexicity 
// there by we optimize it into one function which checks both height and return a bool
/*class Solution {
    int height(TreeNode node){
        if(node == null) return 0;

        int l = 1 + height(node.left);
        int r = 1 + height(node.right);

        return Math.max(l, r);
    }

    boolean balanced(TreeNode node){
        if(node == null) return true;

        if(Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.right) && balanced(node.left)) return true;
        return false;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return balanced(root);
    }
}*/