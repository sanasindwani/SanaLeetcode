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
class Pair{
    TreeNode node;
    int idx;

    Pair(TreeNode node, int idx){
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int width = 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            int first = q.peek().idx;
            int last = 0;
            
            for(int i = 0; i < size; i++){
                Pair p = q.poll();
                TreeNode v = p.node;
                int id = p.idx - first;
                
                if(i == size - 1) last = id;

                if(v.left != null) q.add(new Pair(v.left, 2*id + 1));
                if(v.right != null) q.add(new Pair(v.right, 2*id + 2));
            }
            width = Math.max(width, last + 1);
        }
        return width;
    }
}