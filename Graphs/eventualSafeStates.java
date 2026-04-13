package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class eventualSafeStates {
    // Leetcode
    // extra space used for reversal of graph 
    // extra time for sorting
    public List<Integer> eventualSafeNodes(int[][] graph) {
      int m = graph.length;
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for(int i = 0; i < m; i++) adj.add(new ArrayList<Integer>());
      for(int j = 0; j < m; j++){
        for(int k : graph[j]){
            adj.get(k).add(j);
        }
      }

      int[] inDegree = new int[m];
      for(int i = 0; i < m; i++){
        inDegree[i] = graph[i].length;
      }
      Queue<Integer> q = new LinkedList<>();
      for(int i = 0; i < m; i++){
        if(inDegree[i] == 0)q.add(i);
      }
      List<Integer> lst = new ArrayList<>();
      while(!q.isEmpty()){
        int node = q.poll();
        lst.add(node);
        for(int n : adj.get(node)){
            inDegree[n]--;
            if(inDegree[n] == 0)q.add(n);
        }
      }
      Collections.sort(lst);
      return lst;
    }

    //GFG -> code
    /*
    class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
     for(int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
     for(int j = 0; j < edges.length ; j++){
        adj.get(edges[j][1]).add(edges[j][0]);
     }
     int[] inDegree = new int[V];
     for(int i = 0; i < V; i++){
         for(int j : adj.get(i)){
             inDegree[j]++;
         }
     }
     Queue<Integer> q = new LinkedList<>();
     for(int k = 0; k < V; k++){
         if(inDegree[k] == 0)q.add(k); 
     }
     ArrayList<Integer> ans = new ArrayList<>();
     while(!q.isEmpty()){
         int node = q.poll();
         ans.add(node);
         
         for(int i : adj.get(node)){
             inDegree[i]--;
             if(inDegree[i] == 0) q.add(i);
         }
     }
     return ans;
    }
} */
}
