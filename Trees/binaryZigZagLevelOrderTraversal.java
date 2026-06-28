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
// even better solution
class Solution {
    void traverse(TreeNode node, int level, List<List<Integer>> ls){
        if(node == null) return;

        if(ls.size() == level){
            ls.add(new ArrayList<>());
        }

        if(level % 2 == 0){
            ls.get(level).add(node.val);
        } else {
            ls.get(level).add(0, node.val);
        }

        traverse(node.left, level+1, ls);
        traverse(node.right, level+1, ls);
        return;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;

        traverse(root, 0, ls);
        return ls;
    }
}
 
// can do it using a switch or a flip-flop, no other data structure required
/*class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true; // true -> left to right & false -> right to left 

        while(!q.isEmpty()){
            int size = q.size();
            //List<Integer> lst = new ArrayList<>();
            List<Integer> row = new ArrayList<>(Collections.nCopies(size, 0));
            for(int i = 0; i < size; i++){
                TreeNode v = q.poll();
                int idx = flag ? i : size - i - 1;

                row.set(idx, v.val);

                if(v.left != null) q.add(v.left);
                if(v.right != null) q.add(v.right);
            }
            ls.add(row);
            flag = !flag;
        }
        return ls;
    }
}*/

// well can be optimized no need for Deque

/*class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;

        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            ls.add(new ArrayList<>());

            Deque<Integer> dq = new ArrayDeque<>();

            for(int i = 0; i < size; i++){
                if(level%2 == 0){
                    TreeNode v = q.poll();
                    ls.get(level).add(v.val);
                    if(v.left != null) q.add(v.left);
                    if(v.right != null) q.add(v.right);
                } else {
                    TreeNode v = q.poll();
                    dq.addFirst(v.val);
                    if(v.left != null) q.add(v.left);
                    if(v.right != null) q.add(v.right);
                }
            }
            ls.get(level).addAll(dq);
            level++;
        }
        return ls;
    }
}*/