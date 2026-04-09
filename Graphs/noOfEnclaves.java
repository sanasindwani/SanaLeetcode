package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class noOfEnclaves {
    class Solution {
        //My Code
    int bfs(Queue<int[]> q, int[][] vis, int[][] grid){
        int[] delX = {1,0,-1,0};
        int[] delY = {0,1,0,-1};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        while(!q.isEmpty()){
            int[] a = q.poll();
            int x = a[0];
            int y = a[1];
            count++;
            for(int i = 0; i < 4; i++){
                int nx = x + delX[i];
                int ny = y + delY[i];
                if(nx < m && ny < n && nx >= 0 && ny >= 0 && vis[nx][ny] == 0 && grid[nx][ny] == 1){
                    q.add(new int[]{nx,ny});
                    vis[nx][ny] = 1;
                }
            }
        }
        return count;
    }

    int numberOfEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int j = 0; j < n ; j++){
            if(vis[0][j] == 0 && grid[0][j] == 1){
                q.add(new int[]{0,j});
                vis[0][j] = 1;
            }
            if(vis[m-1][j] == 0 && grid[m-1][j] == 1){
                q.add(new int[]{m-1,j});
                vis[m-1][j] = 1;
            }
        }
         for(int i = 0; i < m ; i++){
            if(vis[i][0] == 0 && grid[i][0] == 1){
                q.add(new int[]{i,0});
                vis[i][0] = 1;
            }
            if(vis[i][n-1] == 0 && grid[i][n-1] == 1){
                q.add(new int[]{i,n-1});
                vis[i][n-1] = 1;
            }
        }
        /*for(int i = 0; i < n; i++){
    for(int j = 0; j < m; j++){
        // first row, first col, last row, last col
        if(i == 0 || j == 0 || i == n-1 || j == m-1){
            
            }
          }
        } */
        int ans = bfs(q,vis,grid);
        int res = 0;
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) res++;
            }
        }
        return res-ans;
    }
}
}
