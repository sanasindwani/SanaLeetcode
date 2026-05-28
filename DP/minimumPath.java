package DP;

public class minimumPath {
    // Space optimization
// My methods
// TC -> O(N*M)
// SC -> O(N)
    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[] prev = new int[y];
        for(int i = 0; i < y; i++) prev[i] = 100000000;
        prev[0] = 0;
        for(int i = 0; i < x; i++){
            int[] temp = new int[y];
            for(int j = 0; j < y; j++){
                if(j == 0) temp[j] = prev[j] + grid[i][j];
                else {
                    temp[j] = Math.min(prev[j]+grid[i][j],temp[j-1]+grid[i][j]);
                }
            }
            prev = temp;
        }
        return prev[y-1];
    }
}
// Tabulation
// TC -> O(N*M)
// SC -> O(N*M)
/*class Solution {
    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(i == 0 && j == 0) dp[i][j] = grid[0][0];
                else {
                    int up = 100000000, left = 100000000;
                    if(i > 0) up = grid[i][j] + dp[i-1][j];
                    if(j > 0) left = grid[i][j] + dp[i][j-1];

                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[x-1][y-1];
    }
}*/
// Recursion + Memoization
// TC -> O(N*M)
// SC -> O(N*M) + O(N+M) { as M-1 + N-1 is path sum recusrion stack space}
/*class Solution {
    int sana(int x, int y, int[][] grid, int[][] dp){
        if(x == 0 && y == 0) return grid[0][0];
        if(x < 0 || y < 0) return 100000000;
        if(dp[x][y] != -1) return dp[x][y];
        int up = grid[x][y] + sana(x-1, y, grid, dp);
        int left = grid[x][y] + sana(x, y-1, grid, dp);

        return dp[x][y] = Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x][y];
        for(int i = 0; i < x; i++){
            Arrays.fill(dp[i], -1);
        }
        return sana(x-1, y-1, grid, dp);
    }
}*/
