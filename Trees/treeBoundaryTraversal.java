/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/
// striver's code
class Solution {
    boolean isLeaf(Node node){
        if(node.left == null && node.right == null) return true;
        return false;
    }
    
    void leftBoundary(Node node, ArrayList<Integer> ls){
        Node curr = node.left;
        while(curr != null){
            if(isLeaf(curr) == false) ls.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else                  curr = curr.right;
        }
        return;
    }
    
    void addLeaves(Node node, ArrayList<Integer> ls){
        if(node == null) return;
        if(isLeaf(node)){
            ls.add(node.data);
            return;
        }
        
        addLeaves(node.left, ls);
        addLeaves(node.right, ls);
        return;
    }
    
    void rightBoundary(Node node, ArrayList<Integer> ls){
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(isLeaf(curr) == false) temp.add(curr.data);
            if(curr.right != null)    curr = curr.right;
            else                      curr = curr.left;
        }
        
        for(int i = temp.size()-1; i >= 0; i--){
            ls.add(temp.get(i));
        }
        return;
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        
        if(isLeaf(root) == false) ls.add(root.data);
        leftBoundary(root, ls);
        addLeaves(root, ls);
        rightBoundary(root, ls);
        return ls;
    }
}
// my code
/*class Solution {
    void leftBoundary(Node node, ArrayList<Integer> ls){
        if(node.right == null && node.left == null) return;
        
        ls.add(node.data);
        
        if(node.left != null) leftBoundary(node.left, ls);
        if(node.left == null && node.right != null) leftBoundary(node.right, ls);
        return;
    }
    
    void leafNodes(Node node, ArrayList<Integer> ls){
        if(node == null) return;
        
        if(node.right == null && node.left == null) ls.add(node.data);
        leafNodes(node.left, ls);
        leafNodes(node.right, ls);
        return;
    }
    
    void reverseRightNodes(Node node, ArrayList<Integer> ls){
        if(node.right == null && node.left == null) return;
        
        if(node.right != null) reverseRightNodes(node.right, ls);
        if(node.right == null && node.left != null) reverseRightNodes(node.left, ls);
        
        ls.add(node.data);
        return;
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        
        // if there will be only 1 element it would be considered twice in leaf and left
        if(root.left == null && root.right == null){
            ls.add(root.data);
            return ls;
        }
        ls.add(root.data);
         // at first I will traverse for left boundary
         if(root.left != null ) leftBoundary(root.left, ls);
         // now i'll traverse for all leaf nodes;
         leafNodes(root, ls);
         // now I'll traverse for right boundary in reverse
         if(root.right != null) reverseRightNodes(root.right, ls);
         
         return ls;
    }
}*/