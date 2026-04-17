package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class cheapestFlightsWithinKStops {
    /*class Solution {
    class Pair {
        int node, cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    class Tuple {
        int stops, node, cost;
        Tuple(int stops, int node, int cost){
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] f : flights){
            adj.get(f[0]).add(new Pair(f[1], f[2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while(!q.isEmpty()){
            Tuple curr = q.poll();

            int stops = curr.stops;
            int node = curr.node;
            int cost = curr.cost;

            if(stops > k) continue;

            for(Pair it : adj.get(node)){
                int adjNode = it.node;
                int price = it.cost;

                if(cost + price < dist[adjNode]){
                    dist[adjNode] = cost + price;
                    q.add(new Tuple(stops + 1, adjNode, cost + price));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}*/
//TC ->
    class Pair{
        int node; 
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    class Tuple{
        int k;
        int dist;
        int node;
        Tuple(int k, int dist, int node){
            this.k = k; 
            this.dist = dist;
            this.node = node;
        }
    }
     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
         for(int i = 0; i < n; i++) adj.add(new ArrayList<Pair>());
         for(int i = 0; i < flights.length; i++){
             adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
         }
         int[] dis = new int[n];
         Arrays.fill(dis, Integer.MAX_VALUE);
         Queue<Tuple> q = new LinkedList<>();
         dis[src] = 0;
         q.add(new Tuple (0,0,src));
         while(!q.isEmpty()){
             Tuple curr = q.poll();
             if(curr.k > k) continue;
             for(Pair i : adj.get(curr.node)){
                 int newDist = curr.dist + i.dist;
                 if(newDist < dis[i.node]){
                     dis[i.node] = newDist;
                     q.add(new Tuple(curr.k+1, newDist, i.node));
                 }
             }
               
         }
         if(dis[dst] == Integer.MAX_VALUE) return -1;
         return dis[dst];
     }
    
}
