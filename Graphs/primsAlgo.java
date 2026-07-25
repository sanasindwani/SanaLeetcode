// Intution is -> Greedy
// TC -> O(E log E)
// SC -> O(E + V)
class Solution {
    public int spanningTree(int V, int[][] edges) {
       int n = edges.length;
       ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
       
       for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
       
       for(int j = 0; j < n; j++){
           adj.get(edges[j][0]).add(new int[]{edges[j][1], edges[j][2]});
           adj.get(edges[j][1]).add(new int[]{edges[j][0], edges[j][2]});
       }
       
       // we only need sum so we can do with just wt and edges, instead of parent also
       // parent is only needed when we want to reconstruct the mst 
       int[] vis = new int[V];
       int sum = 0;
       
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
       pq.add(new int[]{0,0});
       // E
       while(!pq.isEmpty()){
        // log E
           int[] val = pq.poll();
           int wt = val[0];
           int node = val[1];
           
           if(vis[node] == 1) continue;
           
           vis[node] = 1;
           sum += wt;
           // E log E
           // E
           for(int[] i : adj.get(node)){
                                  // log E
               if(vis[i[0]] != 1) pq.add(new int[]{i[1], i[0]});
           }
       }
       return sum;
    }
}
