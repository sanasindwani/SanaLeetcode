package Trees;

import java.util.ArrayList;
import java.util.List;

public class levelOrderTraversal {
// Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
 
 
 // recursive approach
 // TC -> O(N)
 // SC -> O(N)

 class Solution {
    void traverse(TreeNode node, int level, List<List<Integer>> ls){
        if(node == null) return;

        if(ls.size() == level){
            ls.add(new ArrayList<>());
        }

        ls.get(level).add(node.val);
        traverse(node.left, level+1, ls);
        traverse(node.right, level+1, ls);

        return;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        traverse(root, 0, ls);

        return ls;
    }
 }

/*class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> lst = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode n = q.poll();
                lst.add(n.val);
        
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            ls.add(lst);
        }

        return ls;
    }
}*/

/*class Solution {
    void traverse(TreeNode node, List<List<Integer>> ls){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> lst = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode n = q.poll();
                lst.add(n.val);
        
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            ls.add(lst);
        }

        return;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        traverse(root, ls);

        return ls;
    }
}*/
}
