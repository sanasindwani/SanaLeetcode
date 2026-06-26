/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/
// TC -> O(3N)
// SC -> O(N)
class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}
class Solution {
    List<List<Integer>> treeTraversal(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        for(int i = 0; i < 3; i++){
            ls.add(new ArrayList<>());
        }

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while(!st.isEmpty()){
            Pair v = st.pop();

            if(v.num == 1){
                ls.get(1).add(v.node.data);
                v.num++;
                st.push(v);
                if(v.node.left != null) st.push(new Pair(v.node.left, 1));
            } 
            else if(v.num == 2){
                ls.get(0).add(v.node.data);
                v.num++;
                st.push(v);
                if(v.node.right != null) st.push(new Pair(v.node.right, 1));
            }
            else{
                ls.get(2).add(v.node.data);
            }
        }
        return ls;
    }
}