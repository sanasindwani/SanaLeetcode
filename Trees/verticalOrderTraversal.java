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
// my code + approach
// DFS -> O(N) and every insertion into TreeMap/PriorityQueue is O(log N)
// Therefore overall complexicity -> O(N log N)
// SC -> O(3N + N) = O(4N) = O(N)
class Solution {
    void DFS(TreeNode node, int col, int row, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map){
        if(node == null) return;

        if(!map.containsKey(col)){
            map.put(col, new TreeMap<>());
        }
        if(!map.get(col).containsKey(row)){
            map.get(col).put(row, new PriorityQueue<Integer>());
        }
        map.get(col).get(row).offer(node.val);

        DFS(node.left, col-1, row+1, map);
        DFS(node.right, col+1, row+1, map);
        return;
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        DFS(root, 0, 0, map);

        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){
            ls.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : ys.values()){
                while(!pq.isEmpty()){
                    ls.get(ls.size()-1).add(pq.poll());
                }
            }
        }
        return ls;
    }
}

// striver's approach
// BFS to traverse all nodes and store them in a Queue and then poll them and store them in a TreeMap of TreeMap<Integer, PriorityQueue> 
// as TreeMap will store everything in sorted order and so is Priority Queue

/*class Tuple{
    TreeNode node;
    int row;
    int col;

    Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>(); 

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode node = t.node;
            int r = t.row;
            int c = t.col;

            if(!map.containsKey(r)){
                map.put(r, new TreeMap<>());
            }

            if(!map.get(r).containsKey(c)){
                map.get(r).put(c, new PriorityQueue<>());
            }

            map.get(r).get(c).offer(node.val); // offer is similar to add but it also checks the space like if you can take it please add it

            if(node.left != null){
                q.offer(new Tuple(node.left, r - 1, c + 1));
            }

            if(node.right != null){
                q.offer(new Tuple(node.right, r + 1, c + 1));
            }
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){ // map.values() returns a collection of all the values stored in the map only values 

        ls.add(new ArrayList<>());
        for(PriorityQueue<Integer> nodes : ys.values()){
            while(!nodes.isEmpty()){
                ls.get(ls.size()-1).add(nodes.poll());
            }
        }
        }
        return ls;
    }
}*/