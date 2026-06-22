package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class iterativePreOrder {
    // TC -> O(N)
// SC -> O(H) height of tree
 // iterative approach
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
 class Solution{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        //ls.add(root.val);

        Stack<TreeNode> s = new Stack<>();
        //if(root.right != null) s.push(root.right);
        //if(root.left != null) s.push(root.left);
        s.push(root);
        
        while(!s.isEmpty()){
            TreeNode v = s.pop();

            ls.add(v.val);

            if(v.right != null) s.push(v.right);
            if(v.left != null) s.push(v.left);
        }
        return ls;
    }
 }
}
