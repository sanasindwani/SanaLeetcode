package Graphs;

import java.util.ArrayList;

public class cycleinDirectedDFS {
    
    boolean dfs(int node, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(int i : adj.get(node)){
            if(vis[i] == 0){
                if(dfs(i,vis, pathVis,adj)) return true;//mistake
            }
            if(vis[i] == 1 && pathVis[i] == 1) return true;
        }
        pathVis[node] = 0;//mistake
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
         for(int j = 0; j < edges.length; j++){
             adj.get(edges[j][0]).add(edges[j][1]);
         }
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                if(dfs(i, vis, pathVis, adj)) return true;
            }
        }
        return false;
    }
}
