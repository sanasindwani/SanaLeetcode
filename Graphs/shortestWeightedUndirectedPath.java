package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class shortestWeightedUndirectedPath {
    //Forgot no path case initially
    //return lst.add(-1); returns a boolean not a list 
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<Pair>());
        for(int j = 0; j < m; j++){
            adj.get(edges[j][0]).add(new Pair(edges[j][1],edges[j][2]));
            adj.get(edges[j][1]).add(new Pair(edges[j][0],edges[j][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist -b.dist);
        int[] dis = new int[n+1];
        int[] parent = new int[n+1];
        for(int i = 0; i <= n; i++){
            dis[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        dis[1] = 0;
        pq.add(new Pair(1,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int cnode = curr.node;
            int cdist = curr.dist;
            if(cdist > dis[cnode]) continue; // optimises the code a lil faster.. not necessary 
            for(Pair ni : adj.get(cnode)){
                if(cdist + ni.dist < dis[ni.node]){
                    dis[ni.node] = cdist + ni.dist;
                    parent[ni.node] = cnode;
                    pq.add(new Pair(ni.node,cdist + ni.dist));
                }
            }
        }
        List<Integer> lst = new ArrayList<>();
        if(dis[n] == Integer.MAX_VALUE){
            lst.add(-1);
            return lst;
        }
        lst.add(dis[n]);
        int node = n;
        while(parent[node] != node){
           lst.add(node);
           node = parent[node];
        }
        lst.add(1);
        Collections.reverse(lst.subList(1, lst.size()));
        return lst;
    }
}
