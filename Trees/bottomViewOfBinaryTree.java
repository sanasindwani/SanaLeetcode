/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/

// TC -> O(N)
// Sc -> O(N)
class Pair{
    Node node;
    int col;
    Pair(Node node, int col){
        this.node = node;
        this.col = col;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int minCol = 0;
        int maxCol = 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node v = p.node;
            int c = p.col;
            
            minCol = Math.min(minCol, c);
            maxCol = Math.max(maxCol, c);
            
            map.put(c, v.data);
            
            
            if(v.left != null) q.add(new Pair(v.left, c - 1));
            if(v.right != null) q.add(new Pair(v.right, c + 1));
        }
        
        for(int i = minCol; i <= maxCol; i++){
            ls.add(map.get(i));
        }
        return ls;
    }
}

// can't use DFS as when we use DFS we might encounter earlier values of a coloumn and add them 
// even if you do right -> right then when right = null left
// TC -> O(N log N)
// SC -> O(N)
// could have used stack but it would be unnecessary as over write is much simpler and easier
/*class Pair{
    Node node;
    int col;
    
    Pair(Node node, int col){
        this.node = node;
        this.col = col;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
       ArrayList<Integer> ls = new ArrayList<>();
       if(root == null) return ls;
       
       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(root, 0));
       
       TreeMap<Integer, Integer> map = new TreeMap<>();
       
       while(!q.isEmpty()){
           // here we are doing col wise thus we don't need size of queue 
           Pair p = q.poll();
           Node v = p.node;
           int c = p.col;
           // hamesha later hi hoga see in the note section
           // same as top view with the only diff is that here we are overwrite
           // just one change of overwrite and we get botton lining
           map.put(c, v.data);
           
           if(v.left != null) q.add(new Pair(v.left, c-1));
           if(v.right != null) q.add(new Pair(v.right, c+1));
       }
       ls.addAll(map.values());
       return ls;
    }
}*/