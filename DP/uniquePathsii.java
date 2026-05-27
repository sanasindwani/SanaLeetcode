package DP;

public class uniquePathsii {
    // My methods
// Space optimization
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        if(obstacleGrid[x-1][y-1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[] prev = new int[y];
        prev[0] = 1;
        for(int i = 0; i < x; i++){
            int[] temp = new int[y];
            for(int j = 0; j < y; j++){
                if(j == 0 && obstacleGrid[i][j] != 1) temp[j] = prev[j];
                else if(obstacleGrid[i][j] != 1){
                    temp[j] = prev[j] + temp[j-1];
                }
                else temp[j] = 0;
            }
            prev = temp;
        }
        return prev[y-1];
    }
}

// Tabulation
/*class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        if(obstacleGrid[x-1][y-1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[x][y];
        for(int i = 0; i < x; i++){
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 1;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                int up = 0, left = 0;
                if(i == 0 && j == 0) dp[i][j] = 1;
                else if(obstacleGrid[i][j] != 1){
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];

                    dp[i][j] = up + left;
                }
                else dp[i][j] = 0;
             }
        }
        return dp[x-1][y-1];
   }
}*/

// Recursion and Memoization 
/*class Solution {
    int sana(int x, int y, int[][] obstacleGrid, int[][] dp){
        if(x < 0 || y < 0) return 0;
        if(obstacleGrid[x][y] == 1) return 0;
        if(x == 0 && y == 0) return 1;
        if(dp[x][y] != -1) return dp[x][y];
        int up = sana(x-1, y, obstacleGrid, dp);
        int left = sana(x, y-1, obstacleGrid, dp);

        return dp[x][y] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        int[][] dp = new int[x][y];
        for(int i = 0; i < x; i++){
            Arrays.fill(dp[i], -1);
        }
        return sana(x-1,y-1, obstacleGrid, dp);
    }
}*/
