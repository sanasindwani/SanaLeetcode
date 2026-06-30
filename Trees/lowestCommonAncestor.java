/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// TC -> O(N)
// SC -> O(H)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q) return root; 

        if(root == p || root == q) return root; 

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        return left != null ? left : right;


        
    }
}
/*class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p || root == q) return root;

         TreeNode left = lowestCommonAncestor(root.left, p, q);
         TreeNode right = lowestCommonAncestor(root.right, p, q);

         if(left != null && right != null) return root;
         // there are 4 cases if left and right != null
         // if left != null or right != null whichever is not null simply return it
         // last if both are null then left != null is false and it returns right which is null therefore tertiary operator is fine
         return left != null ? left : right;
    }
}*/

/*class Solution {
    TreeNode sana(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return null;

        if(node == p || node == q) return node;

        TreeNode l = sana(node.left, p, q);
        TreeNode r = sana(node.right, p, q);

        if( l != null && r != null) return node;

        if(l != null) return l;
        if(r != null) return r;

        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        return sana(root, p, q);
    }
}*/