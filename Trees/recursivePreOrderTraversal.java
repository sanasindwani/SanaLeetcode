package Trees;

import java.util.ArrayList;
import java.util.List;

public class recursivePreOrderTraversal {
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


 // TC -> O(N)
 // SC -> O(N)
 // recursive approach
class Solution {
    void traverse(TreeNode root, List<Integer> ls){
        if(root == null) return;

        ls.add(root.val);
        traverse(root.left, ls);
        traverse(root.right, ls);

        return;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();

        traverse(root, ls);
        return ls;
    }
}
}
