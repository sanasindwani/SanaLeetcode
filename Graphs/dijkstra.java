package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkstra {
    // added PriorityQueue without comparator
    // in java we can use comparator to tell function -> how to compare
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<Pair>());
        for(int j = 0; j < edges.length; j++){
            adj.get(edges[j][0]).add(new Pair(edges[j][1], edges[j][2]));
            adj.get(edges[j][1]).add(new Pair(edges[j][0], edges[j][2]));
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.dist - b.dist); 
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        q.add(new Pair(src,0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int dist = p.dist;
            for(Pair l : adj.get(node)){
            int ndist = dist + l.dist;
                if(ndist < dis[l.node]){
                    q.add(new Pair(l.node,ndist));
                    dis[l.node] = ndist;
                }
            }
        }
        return dis;
    }
}