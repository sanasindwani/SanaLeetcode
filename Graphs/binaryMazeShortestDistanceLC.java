package Graphs;

import java.util.LinkedList;
import java.util.Queue;
/*  2 Base case -> 1) If both the source and destination is at the same 
position return 1 (contains only 1 element)
2-> if any one of them consists of 1 return -1;
3) if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
   if(m == 1 && n == 1) return 1;
   first check for 1 then location of source and destinition because
   for[[1]] it will return 1 otherwise.
   [[0]] , [[1]] and [[1,0][0,1]] 3 base cases 
*/
public class binaryMazeShortestDistanceLC {
    class Pair{
        int x;
        int y; 
        int dist;

        Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        if(m == 1 && n == 1) return 1;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,1));
        vis[0][0] = true;
        while(!q.isEmpty()){
        Pair curr = q.poll();
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                int nx = curr.x + i;
                int ny = curr.y + j;
                if(nx == m-1 && ny == n-1) return curr.dist+1;
                if(nx < m && ny < n && nx >= 0 && ny >= 0 && vis[nx][ny] == false && grid[nx][ny] == 0){
                     vis[nx][ny] = true;
                     q.add(new Pair(nx,ny,curr.dist+1));
                }
            }
        }
        }
        return -1;
    }
}
