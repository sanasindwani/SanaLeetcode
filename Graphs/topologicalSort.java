package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class topologicalSort {
    // SC - O(N)
    // TC - O(V+E)
    void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = 1;
        
        for(int j : adj.get(node)){
            if(vis[j] == 0){
                dfs(j, vis, adj, st);
            }
        }
        st.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        int E = edges.length;
        
        for(int i = 0; i < E; i++){
            int node = edges[i][0];
            adj.get(node).add(edges[i][1]);
        }
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, vis, adj, st);
            }
        }
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i = 0; i < V; i++){
            lst.add(st.pop());
        }
        return lst;
    }
}
