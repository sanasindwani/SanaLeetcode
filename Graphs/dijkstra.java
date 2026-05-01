package Graphs;

import java.util.*;

class dijkstra {
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
    
    public int[] Dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<Pair>());
        for(int j = 0; j < edges.length; j++){
            adj.get(edges[j][0]).add(new Pair(edges[j][1], edges[j][2]));
            adj.get(edges[j][1]).add(new Pair(edges[j][0], edges[j][2]));
        }
        /*PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.dist - b.dist); 
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
}*/

       TreeSet<Pair> st = new TreeSet<>(
            (a, b) -> {
                if(a.dist != b.dist) return a.dist - b.dist;
                return a.node - b.node;
            }
        );

        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);

        dist[src] = 0;
        st.add(new Pair(src, 0));

        while(!st.isEmpty()) {
            Pair curr = st.pollFirst();

            int currNode = curr.node;
            int currDist = curr.dist;

            for(Pair adjacent : adj.get(currNode)) {

                int adjNode = adjacent.node;
                int adjDist = adjacent.dist;

                if(currDist + adjDist < dist[adjNode]) {

                    if(dist[adjNode] != (int)1e9) {
                        st.remove(new Pair(adjNode, dist[adjNode]));
                    }

                    dist[adjNode] = currDist + adjDist;
                    st.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
    return dist;
    }
}
