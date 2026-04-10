package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class courseScheduleii {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
     for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<Integer>());
     for(int j = 0; j < prerequisites.length ; j++){
        adj.get(prerequisites[j][1]).add(prerequisites[j][0]);
     }
     int[] inDegree = new int[numCourses];
     for(int i = 0; i < numCourses; i++){
        for(int j : adj.get(i)){
            inDegree[j]++;
        }
     }
     int[] ans = new int[numCourses];
     Queue<Integer> q = new LinkedList<>();
     for(int k = 0; k < numCourses; k++){
        if(inDegree[k] == 0) q.add(k);
     }
     int j = 0;
     while(!q.isEmpty()){
        int node = q.poll();
        ans[j++] = node;
        for(int i : adj.get(node)){
            inDegree[i]--;
            if(inDegree[i] == 0) q.add(i);
        }
     }
      if(j < numCourses) return new int[]{};

      return ans;
    }
}
