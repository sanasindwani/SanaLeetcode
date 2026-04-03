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