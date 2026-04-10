package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class directedCycleusingKahn {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
         for(int j = 0; j < edges.length; j++){
             adj.get(edges[j][0]).add(edges[j][1]);
         }
         Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int j : adj.get(i)){
                inDegree[j]++;
            }
        }
        for(int k = 0; k < V; k++){
            if(inDegree[k] == 0){
               q.add(k); 
            }
        }
        ArrayList<Integer> ls = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ls.add(node);
            for(int n : adj.get(node)){
                inDegree[n]--;
                
                if(inDegree[n] == 0) q.add(n);
            }
        }
        if(ls.size() != V) return true;
        
        return false;
    }
}
