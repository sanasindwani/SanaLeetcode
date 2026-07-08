/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    void dfs(Node node, ArrayList<ArrayList<Integer>> ls, ArrayList<Integer> lst){
        if(node == null) return;
        if(node.left == null && node.right == null){
            lst.add(node.data);
            ls.add(new ArrayList<>(lst));
            lst.remove(lst.size() - 1);
            return;
        }
        
        lst.add(node.data);
        dfs(node.left, ls, lst);
        dfs(node.right, ls, lst);
        
        lst.remove(lst.size() - 1);
    }
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        ArrayList<Integer> lst = new ArrayList<>();
        dfs(root, ls, lst);
        return ls;
    }
}