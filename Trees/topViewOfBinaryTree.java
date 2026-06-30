/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}*/

// Java's TreeMap use O(log n) complexicity to insert as it uses Red Black trees for sorting
// but hashmap uses O(1) thereby we'll use hashmap and inserting in hashmap is O(1)
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
    public ArrayList<Integer> topView(Node root) {
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
            
            if(!map.containsKey(c)){
                map.put(c, v.data);
            }
            
            if(v.left != null) q.add(new Pair(v.left, c - 1));
            if(v.right != null) q.add(new Pair(v.right, c + 1));
        }
        
        for(int i = minCol; i <= maxCol; i++){
            ls.add(map.get(i));
        }
        return ls;
    }
}

// TC -> O(N log N)
// SC -> O(N)
/*class Pair{
    Node node;
    int col;
    Pair(Node node, int col){
        this.node = node;
        this.col = col;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node v = p.node;
            int c = p.col;
            
            if(!map.containsKey(c)){
                map.put(c, v.data);
            }
            
            if(v.left != null) q.add(new Pair(v.left, c - 1));
            if(v.right != null) q.add(new Pair(v.right, c + 1));
        }
        
        ls.addAll(map.values());
        return ls;
    }
}*/