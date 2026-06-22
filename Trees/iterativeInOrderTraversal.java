package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class iterativeInOrderTraversal {

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
      //Iterative approach
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;

        Stack<TreeNode> st = new Stack<>();
        //st.push(root);

        // we can't do this because then we'll get stuck at one node and keep on iterating it again and again
        // as input root = [1,2] at first we add 1 in stack then 2
        // now stack -> {1,2} -> we'll pop 2 then of(st.peek().left != null) we be true again and 2 will be entered again
            /*while(!st.isEmpty()){
            if(st.peek().left != null) st.push(st.peek().left);
            else{
                TreeNode v = st.pop();
                ls.add(v.val);
                if(v.right != null) st.push(v.right);
            }
        }*/
        // we'll use a pointer -> curr
        // we are checking curr != null and not curr.left != null 
        // because when we traverse curr it'll reach null 
        TreeNode curr = root;
        /*while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
                } else {
                    curr = st.pop();
                    ls.add(curr.val);
                    curr = curr.right;
                }
        }*/


// if i'll do curr.left != null then i'll stop at last index and not iterate it or put it into stack thus its imp to use curr != null
        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            ls.add(curr.val);
            curr = curr.right;
        }
        return ls;
    }
}
}
 