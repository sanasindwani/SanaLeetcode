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
/*
class Pair{
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
    class Solution {
    void bfs(char[][] ans, int x, int y){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        ans[x][y] = 'W';  

        int m = ans.length;
        int n = ans[0].length;

        while(!q.isEmpty()){                 
            Pair p = q.remove();

            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++){

                    int ni = p.x + i;      
                    int nj = p.y + j;

                    if(ni >= 0 && nj >= 0 && ni < m && nj < n 
                       && ans[ni][nj] == 'L'){

                        ans[ni][nj] = 'W';
                        q.add(new Pair(ni,nj));
                    }
                }
            }
        }
    }

    public int countIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        char[][] ans = grid; 
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j= 0; j < n; j++){
                if(ans[i][j] == 'L'){
                    bfs(ans,i,j);
                    count++;
                }
            }
        }
        return count;
    }
} */
