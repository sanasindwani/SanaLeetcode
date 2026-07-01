/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    int sana(Node node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return node.data;
        
        int left = sana(node.left);
        int right = sana(node.right);
        
        if(left == -1 || right == -1) return -1;
        
        if(node.data != left + right) return -1;
        
        return node.data;
    }
    public boolean isSumProperty(Node root) {
        if(root == null) return true;
        if(sana(root) == -1) return false;
        return true;
    }
}