//Undirected Graph 
//GFG code 
package Graphs;
import java.util.*;
class detectCycleUsingBFS {

    class Pair {
        int node, parent;

        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }

    boolean detectBfs(int src, int V, boolean[] vis, ArrayList<ArrayList<Integer>> adj){

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        vis[src] = true;

        while(!q.isEmpty()){

            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();

            for(int i : adj.get(node)){
                if(!vis[i]){
                    vis[i] = true;
                    q.add(new Pair(i,node));
                }
                else if(parent != i) return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u); 
        }

        boolean[] vis = new boolean[V];

   
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(detectBfs(i, V, vis, adj))
                    return true;
            }
        }

        return false;
    }
}