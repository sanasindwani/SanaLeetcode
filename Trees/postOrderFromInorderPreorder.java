
// Tc -> O(N)
// Sc -> O(N) -> map + O(N) -> recursion stack space = O(N)
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    
    void solve(int[] p, int ps, int pend, int[] in, int ins, int inend,int[] id, int[] res){
        if(ps > pend || ins > inend) return;
        
        
        int root = p[ps];
        int idx = map.get(root);
        
        res[id[0]--] = root;
        
        int leftSize = idx - ins;
        
        solve(p, ps + leftSize + 1, pend, in, idx + 1, inend, id, res); // for right sub-tree
        solve(p, ps+1, ps + leftSize, in, ins, idx - 1, id, res); // for left subtree

        
        return;
    }
    public int[] getPostorder(int[] inorder, int[] preorder) {
        
        
        int[] res = new int[inorder.length];
        int[] id = {inorder.length - 1};
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        solve(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, id, res);
        
    
        return res;
    }
}

// first method pass an index array with only one element since arrays are pass by reference not value
/*class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    
    void solve(int[] p, int ps, int pend, int[] in, int ins, int inend, int[] id, int[] res){
        if(ps > pend || ins > inend) return;
        
        int root = p[ps];
        int idx = map.get(root);
        
        int leftSize = idx - ins;
        
        solve(p, ps+1, ps + leftSize, in, ins, idx - 1, id, res); // for left subtree
        solve(p, ps + leftSize + 1, pend, in, idx + 1, inend, id, res); // for right sub-tree
        
        res[id[0]++] = root;
        
        return;
    }
    public int[] getPostorder(int[] inorder, int[] preorder) {
        
        
        int[] res = new int[inorder.length];
        int[] id = {0};
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        solve(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, id, res);
        
    
        return res;
    }
}*/

/*class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> ls = new ArrayList<>();
    
    void solve(int[] p, int ps, int pend, int[] in, int ins, int inend){
        if(ps > pend || ins > inend) return;
        
        int root = p[ps];
        int idx = map.get(root);
        
        int leftSize = idx - ins;
        
        solve(p, ps+1, ps + leftSize, in, ins, idx - 1); // for left subtree
        solve(p, ps + leftSize + 1, pend, in, idx + 1, inend); // for right sub-tree
        
        ls.add(root);
        
        return;
    }
    public int[] getPostorder(int[] inorder, int[] preorder) {
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        solve(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        
        int[] res = new int[inorder.length];
        for(int i = 0; i < inorder.length; i++){
            res[i] = ls.get(i);
        }
        
        return res;
    }
}*/

/*class Solution {
    void solve(int[] p, int ps, int pend, int[] in, int ins, int inend, List<Integer> ls, HashMap<Integer, Integer> map){
        if(ps > pend || ins > inend) return;
        
        int root = p[ps];
        int idx = map.get(root);
        
        int leftSize = idx - ins;
        
        solve(p, ps+1, ps + leftSize, in, ins, idx - 1, ls, map); // for left subtree
        solve(p, ps + leftSize + 1, pend, in, idx + 1, inend, ls, map);
        
        ls.add(root);
        
        return;
    }
    public int[] getPostorder(int[] inorder, int[] preorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        solve(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, ls, map);
        
        int[] res = new int[inorder.length];
        for(int i = 0; i < inorder.length; i++){
            res[i] = ls.get(i);
        }
        
        return res;
    }
}*/