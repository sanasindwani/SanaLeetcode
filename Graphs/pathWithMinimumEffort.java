package Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class pathWithMinimumEffort {
    //E log V
    // m * n * 4 log m * n
    // since its a graph it has m*n cells with 4 directions plus n*m vertices
    class Pair{
        int dist;
        int x;
        int y;
        Pair(int dist, int x, int y){
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dis = new int[m][n];
        for(int i = 0; i < m; i++){
           Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        dis[0][0] = 0;
        pq.add(new Pair(0,0,0));
        int[] delX = {1,0,-1,0};
        int[] delY = {0,1,0,-1};
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.x == m-1 && curr.y == n-1) return curr.dist;
            for(int i = 0; i < 4; i++){
                int nx = curr.x + delX[i];
                int ny = curr.y + delY[i];
                if(nx < m && ny < n && nx >= 0 && ny >=0){
                    int ndist = Math.abs(heights[curr.x][curr.y] - heights[nx][ny]);
                    int nm = Math.max(ndist, curr.dist);
                    if(nm < dis[nx][ny]) {
                        dis[nx][ny] = nm;
                        pq.add(new Pair(nm, nx, ny));
                }
            }
        }
    }
    return 0;
}
}
