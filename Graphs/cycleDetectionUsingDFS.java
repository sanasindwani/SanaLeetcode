package Graphs;

import java.util.ArrayList;

public class cycleDetectionUsingDFS {
     //Mistake -> Didn't store my last returned true
    
    boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,int[]vis){
        vis[node] = 1;
        
        for(int i : adj.get(node)){
            if(vis[i] == 0){
                if(dfs(i, node, adj, vis)) return true; 
            }
            else if(i != parent) return true;
        }
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
           ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
           for(int i= 0; i < V; i++) adj.add(new ArrayList<Integer>());
           
           for(int[] e : edges){
               int u = e[0];
               int v = e[1];
               
               adj.get(u).add(v);
               adj.get(v).add(u);
           }
           
           int[] vis = new int[V];
           for(int i = 0; i < V; i++){
               if(vis[i] == 0){
                   if(dfs(i, -1, adj, vis)) return true;
               }
           }
           return false;
    }
}