package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class shortestpathweightedDAG {
// all nodes are processed based on reachability and thus everything is updated optimally 
// if we used dfs only we can't include vis cause if vis other optimal distances couldn't be found
// if vis is not used in dfs it'll be very slow and thus a bad approach and hence topo
    class Pair{
        int n;
        int wt;
        Pair(int n, int wt){
            this.n = n;
            this.wt = wt;
        }
    }
    void dfs(int node,int[] vis, Stack<Integer> st,  ArrayList<ArrayList<Pair>> adj){
        vis[node] = 1;
        for(Pair i : adj.get(node)){
            if(vis[i.n] == 0)dfs(i.n, vis, st, adj); // here i forgot vis[i.n]
        } 
        st.push(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<Pair>());
        for(int j = 0; j < edges.length; j++){
            adj.get(edges[j][0]).add(new Pair(edges[j][1], edges[j][2]));
        }
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, vis, st, adj);
            }
        }
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            for(Pair i : adj.get(node)){
                if(dis[node] != Integer.MAX_VALUE) dis[i.n] = Math.min(dis[i.n] , i.wt + dis[node]);
                } 
            }
            for(int i = 0; i < V; i++) if(dis[i] == Integer.MAX_VALUE) dis[i] = -1;
            return dis;
    }
}