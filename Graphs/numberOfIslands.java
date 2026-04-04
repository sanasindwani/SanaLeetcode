package Graphs;

public class numberOfIslands {
    //forgot to check grid[i][j] == '1'
//Wrong 2D array dimensions..used new int[n][m] instead of new int[m][n]
/*class Solution {
    void dfs(int i, int j, char[][]grid,int[][] vis){
        if(i >= grid.length || j>= grid[0].length || i < 0 || j < 0) return;
        if(grid[i][j] == '1' && vis[i][j] == 0){
            vis[i][j] = 1;
            dfs(i+1, j, grid, vis);
            dfs(i-1, j, grid, vis);
            dfs(i, j+1, grid, vis);
            dfs(i, j-1, grid, vis);
        }
        return;
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] vis = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    dfs(i, j, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }
}
*/
// no extra visited array space thus space optimized version
    void dfs(int i, int j, char[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(grid[i][j] == '0') return;

        grid[i][j] = '0'; // marked as visited

        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
}
