package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPathinBinaryMazeGFG {
    // can use simple BFS also -> more optimized
    // check for if they contain 0 at either source and destinition are 0 and return -1(unreachable)
    // then check if they are same return 0
    class Pair{
        int dist;
        int[] xy;
        Pair(int dist, int[]xy){
            this.dist = dist;
            this.xy = xy;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1]) return 0;
        if(grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j  = 0; j < n; j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        q.add(new Pair(0,new int[]{source[0],source[1]}));
        int[] delX = {1,0,-1,0};
        int[] delY = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int dist = curr.dist;
            int x = curr.xy[0];
            int y = curr.xy[1];
            for(int i = 0; i < 4; i++){
                int nx = x+delX[i];
                int ny = y+delY[i];
                if(nx < m && ny < n && nx >= 0 && ny >= 0 && grid[nx][ny] != 0 && dist + 1 < dis[nx][ny]){
                    dis[nx][ny] = dist+1;
                    q.add(new Pair(dist+1, new int[]{nx,ny}));
                }
                if(nx == destination[0] && ny == destination[1]) return dis[nx][ny];
            }
        }  
        if(dis[destination[0]][destination[1]] == Integer.MAX_VALUE) return -1;
        return dis[destination[0]][destination[1]];
    }
}
