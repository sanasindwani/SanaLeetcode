package Graphs;
import java.util.*;

public class numberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] vis = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = 1;

                while(!q.isEmpty()){
                    int node = q.poll();

                    for(int j = 0; j < n; j++){
                        if(isConnected[node][j] == 1 && vis[j] == 0){
                            vis[j] = 1;
                            q.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
//Using DFS
/*class Solution {
    void dfs(int[][] isConnected, int node, boolean[] vis){
        vis[node] = true;
        for(int i = 0; i < isConnected.length; i++){
            if(isConnected[node][i] == 1 && !vis[i]){
                dfs(isConnected, i, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                count++;
                dfs(isConnected, i, vis);
            }
        }
        return count;
    }
} */

// Using BFS 
/*class Solution {
    static void bfs(ArrayList<ArrayList<Integer>> adjl, int V, int[] vis, int start){
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start]=1;
        
        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);
            for(int i : adjl.get(node)){
                if(vis[i] == 0){
                    vis[i] = 1;
                    q.add(i);
                }
            }
        }
    return;
    }
   public int findCircleNum(int[][] isConnected){
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adjl = new ArrayList<>();
            for(int i = 0; i < V ; i++){
                adjl.add(new ArrayList<>());
            }
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjl.get(i).add(j);
                    adjl.get(j).add(i);
                }
            }
        }
        int[] vis = new int[V];
        int count = 0;
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                bfs(adjl, V, vis, i);
                count += 1;
            }
        }
        return count;
    }
}*/