package Graphs;

public class ReplaceOwithX {
   //GFG code same as Leetcode
    class Solution {
    void dfs(int i, int j, int[][] vis, char[][] grid, int[] delRow, int[] delCol){
        vis[i][j] = 1;
        int m = grid.length;
        int n = grid[0].length;
        for(int k = 0; k < 4; k++){
            int nRow = i + delRow[k];
            int nCol = j + delCol[k];
            
            if(nRow < m && nRow >= 0 && nCol < n && nCol >= 0 && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 'O'){
                dfs(nRow, nCol, vis, grid, delRow,delCol);
            }
        }
    }
    public void fill(char[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int[] delRow = {0,1,0,-1};
        int[] delCol = {1,0,-1,0};
        
        for(int j = 0; j < n; j++){
            if(vis[0][j] == 0 && grid[0][j] == 'O'){
                dfs(0,j,vis,grid,delRow,delCol);
            }
            if(vis[m-1][j]==0 && grid[m-1][j] == 'O'){
                dfs(m-1,j,vis,grid,delRow,delCol);
            }
        }
        for(int i = 0; i < m; i++){
            if(vis[i][0] == 0 && grid[i][0] == 'O'){
                dfs(i,0,vis,grid,delRow,delCol);
            }
            if(vis[i][n-1]==0 && grid[i][n-1] == 'O'){
                dfs(i,n-1,vis,grid,delRow,delCol);
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                } 
            }
        }
    }
}

}
