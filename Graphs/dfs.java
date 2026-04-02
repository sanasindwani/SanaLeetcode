package Graphs;

import java.util.ArrayList;

public class dfs {
    class Solution {
    
    static void tdfs(int node, boolean[] vis, ArrayList<Integer> ls, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        ls.add(node);
        
        for(int it : adj.get(node)){
            if(vis[it] == false){
                tdfs(it,vis,ls,adj);
            }
        }
    }
    public ArrayList<Integer> Dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[adj.size()];
        ArrayList<Integer> ls = new ArrayList<>();
        tdfs(0,vis,ls,adj);
        return ls;
    }
}
    
}