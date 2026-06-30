// Left's code will be similar except the traveral will be preorder instead of reverse preorder
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
// Sc -> O(H)/O(N)
// Reverse Pre-order Traversal
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        dfs(root, 0, ans);
        return ans;
    }

    void dfs(TreeNode node, int level, List<Integer> ans){
        if(node == null) return;

        if(level == ans.size()){
            ans.add(node.val);
        }

        dfs(node.right, level+1, ans);
        dfs(node.left, level+1, ans);
    }
}

// TC -> O(N)
// SC -> O(H) worst O(N)
/*class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int lvl = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
            TreeNode v = q.poll();
            if(i == 0) ls.add(v.val);

            if(v.right != null) q.add(v.right);
            if(v.left != null) q.add(v.left);
            }
            lvl++;
        }
        return ls;
    }
}*/