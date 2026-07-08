/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// here when we are standing at a node we can't go back to its parent and thereby we can't iterate on nodes above it
// thus we save parents node (creates an iterator) using hashmap 
class Solution {
    void dfs(TreeNode node, HashMap<TreeNode, TreeNode> parent){
        if(node == null) return;
        //if(node.left == null && node.right == null) return; not needed 
        
        if(node.left != null) parent.put(node.left, node);
        if(node.right != null) parent.put(node.right, node);

        dfs(node.left, parent);
        dfs(node.right, parent);
        return;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        // parent child iterator bana rahe hai
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(root, parent);

        HashSet<TreeNode> vis = new HashSet<>();
        int dis = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.add(target);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
            TreeNode v = q.poll();

            if(dis == k){
                ls.add(v.val);
            } else{
                if(v.left != null && vis.contains(v.left) == false){
                    q.add(v.left);
                    vis.add(v.left);
                }
                if(v.right != null && vis.contains(v.right) == false){
                     q.add(v.right);
                     vis.add(v.right);
                }
                if(parent.get(v) != null && !vis.contains(parent.get(v))){
                    q.add(parent.get(v));
                    vis.add(parent.get(v));
                } 
            }
            }
            if(dis == k) break;
            dis++;
        }
        return ls;
    }
}