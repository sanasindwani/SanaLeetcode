package Graphs;

import java.util.ArrayList;

public class courseSchedule {
    boolean dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 2;
        for(int i : adj.get(node)){
            if(vis[i] == 0){
                if(dfs(i,vis,adj) == true) return true;
            }
            if(vis[i] == 2) return true;
        }
        vis[node] = 1;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int j = 0; j < numCourses; j++) adj.add(new ArrayList<>());
        for(int k = 0; k < prerequisites.length; k++){
            adj.get(prerequisites[k][0]).add(prerequisites[k][1]);
        }
        int[] vis = new int[numCourses];
        for(int i = 0 ; i < numCourses; i++){
            if(vis[i] == 0){
                if(dfs(i,vis,adj) == true) return false;
            }
        }
        return true;
    }
}
