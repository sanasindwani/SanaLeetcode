package Graphs;
import java.util.*;

class bfs {
    public ArrayList<Integer> Bfs(ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        
        Queue<Integer> q = new LinkedList<>();
        
        vis[0] = true;
        q.add(0);

        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);

            for(int n : adj.get(node)){
                if(vis[n] == false){
                    vis[n] = true;
                    q.add(n);
                }
            }
        }
        
        return bfs;
    }
}