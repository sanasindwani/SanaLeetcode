package Graphs;
import java.util.*;
//Declared size outside while loop..must update each level
//Forgot boundary check before grid[nx][ny]
//Incremented count every loop..should only when queue not empty
//Forgot multi-source BFS should count all rotten oranges first
//Tried running BFS separately instead of level-wise
class rottingOranges {
    int bfs(Queue<int[]> q, int[][] grid, int ffruit){

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int count = 0;
    while(!q.isEmpty()){
        int size = q.size();
        for(int i = 0; i < size; i++){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int  k = 0; k < 4; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1){
                    ffruit--;
                    grid[nx][ny] = 2;
                    q.add(new int[]{nx,ny});
                }
                }
            }
        if(!q.isEmpty()) count++;
        }

        if(ffruit == 0) return count;
        else            return -1;
    }
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int ffruit = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1) ffruit++;
            }
        }
        int ans = bfs(q,grid,ffruit);
        return ans;
    }    
}