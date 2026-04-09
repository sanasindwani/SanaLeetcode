package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class kahnAlgo {
      public ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        int E = edges.length;
        
        for(int i = 0; i < E; i++){
            int node = edges[i][0];
            adj.get(node).add(edges[i][1]);
        }
        
        int[] inDegree = new int[V];
        for(int i = 0; i < V; i++){
        for(int node : adj.get(i)){
          inDegree[node]++;  
        }
        } 
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < V; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int i : adj.get(node)){
                inDegree[i]--;
                
                if(inDegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return ans;
    }
}
