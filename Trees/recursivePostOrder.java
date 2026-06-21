package Trees;

import java.util.ArrayList;
import java.util.List;

public class recursivePostOrder {
//Definition for a binary tree node.
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
 
class Solution {
    void traverse(TreeNode node, List<Integer> ls){
        if(node == null) return;

        traverse(node.left, ls);
        traverse(node.right, ls);
        ls.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        traverse(root, ls);
        return ls;
    }
}
}
