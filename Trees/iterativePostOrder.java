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
// SC -> O(2N)

// this is a two stack approach where I used two stacks to reverse the Root->Right->Left to Left->Right->Root thus postorder 
// or I can simply use Collections.reverse()
/*class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while(!s1.isEmpty()){
            TreeNode v = s1.pop();
            s2.push(v);
            if(v.left != null) s1.push(v.left);
            if(v.right != null) s1.push(v.right);
        }

        while(!s2.isEmpty()){
            ls.add(s2.pop().val);
        }

        return ls;
    }
}*/

// TC -> O(2N)
// SC -> O(N)
//this is a one stack approach where I used a single stack to form postorder thus I just need one while loop to reverse the order
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;

        while(!st.isEmpty() || curr != null){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    ls.add(temp.val);

                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        ls.add(temp.val);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return ls;
    }
}
