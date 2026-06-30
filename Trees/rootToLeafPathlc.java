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
// StringBuilder is better approach
// TC -> O(N)
// Sc -> O(H)
class Solution {
    List<String> ans;
    void sana(TreeNode node, StringBuilder s){
        int length = s.length();
        if(s.isEmpty()){
            s.append(node.val);
        } else{
            s.append("->");
            s.append(node.val);
        }

        if(node.left == null && node.right == null){
            ans.add(s.toString());
            //s.delete(length, s.length());
            // return;
        } else {

        if(node.left != null){
            sana(node.left, s);
        }

        if(node.right != null){
            sana(node.right, s);
        }
        }
        s.delete(length, s.length());
        return;
    }
    public List<String> binaryTreePaths(TreeNode root) {
     
        ans = new ArrayList<>();
        if(root == null) return ans;
        StringBuilder s = new StringBuilder();

        sana(root, s);
        return ans;
    }
}
// Java creates a new String.
//So unlike ArrayList, you don't need backtracking. kyonki har baari string ka naya instance pass ho raha hai thereby when we return the parent will have that string only  
/*class Solution {
    void dfs(TreeNode node, List<String> ans, String s){
        if(node == null) return;

        if(s.isEmpty()){
            s = "" + node.val;
        } else {
            s = s + "->" + node.val;
        }

        if(node.left == null && node.right == null){
            ans.add(s);
            return;
        }

        dfs(node.left, ans, s);
        dfs(node.right, ans, s);
        return;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        String s = "";
        if(root == null) return ans;
        dfs(root, ans, s);
        return ans;
    }
}*/