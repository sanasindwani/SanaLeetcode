package DP;

public class cherryPickupii {
    // space optimization
    public int cherryPickup(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;

        int[][] front = new int[y][y];
        for(int i = 0; i < y; i++){
            for(int j = 0; j < y; j++){
               if(i != j) front[i][j] = grid[x-1][i] + grid[x-1][j];
               else       front[i][j] = grid[x-1][i];
            }
        }
        for(int i = x-2; i >= 0; i--){
            int[][] curr = new int[y][y];
            for(int j = 0; j < y; j++){
                for(int k = 0; k < y; k++){
                    int max = 0;

                    for(int m = -1; m < 2; m++){
                        for(int n = -1; n < 2; n++){
                           if(j + m >= 0 && j + m < y && k + n >= 0 && k + n < y) max = Math.max(max, front[j+m][k+n]);
                        }
                    }

                    if(j != k) curr[j][k] = grid[i][j] + grid[i][k] + max;
                    else       curr[j][k] = grid[i][j] + max;
                }
            }
            front = curr;
        }
        return front[0][y-1];
    }
}

// Tabulation
//my solution
/*class Solution {
    public int cherryPickup(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;

        int[][][] dp = new int[x][y][y];
        for(int i = 0; i < y; i++){
            for(int j = 0; j < y; j++){
               if(i != j) dp[x-1][i][j] = grid[x-1][i] + grid[x-1][j];
               else       dp[x-1][i][j] = grid[x-1][i];
            }
        }
        for(int i = x-2; i >= 0; i--){
            for(int j = 0; j < y; j++){
                for(int k = 0; k < y; k++){
                    int max = 0;

                    for(int m = -1; m < 2; m++){
                        for(int n = -1; n < 2; n++){
                           if(j + m >= 0 && j + m < y && k + n >= 0 && k + n < y) max = Math.max(max, dp[i+1][j+m][k+n]);
                        }
                    }

                    if(j != k) dp[i][j][k] = grid[i][j] + grid[i][k] + max;
                    else       dp[i][j][k] = grid[i][j] + max;
                }
            }
        }
        return dp[0][0][y-1];
    }
}*/

// my solution
// recursion + memoization
/*class Solution {
    int sum(int row, int col1, int col2, int[][] grid, int[] dx, int[] dy, int[][][] dp){
        if(col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length) return (int)-1e8;
        if(row == grid.length-1 && col1 != col2) return grid[row][col1] + grid[row][col2];
        if(row == grid.length-1 && col1 == col2) return grid[row][col1];
        if(dp[row][col1][col2] != -1) return dp[row][col1][col2];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
            if(col1 != col2){
                int dl = grid[row][col1] + grid[row][col2] + sum(row+1, col1+dx[i], col2+dy[j], grid, dx, dy, dp);
                max = Math.max(max, dl);
            } 
            else{
                int dl = grid[row][col1] + sum(row+1,col1+dx[i],col2+dy[j], grid, dx, dy, dp);
                max = Math.max(max,dl);
            }
            }
        }
        return dp[row][col1][col2] = max;

    }
    public int cherryPickup(int[][] grid) {
        int[] dx = {0,+1,-1};
        int[] dy = {0,+1,-1};
        int x = grid.length;
        int y = grid[0].length;

        int[][][] dp = new int[x][y][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return sum(0,0,y-1,grid,dx,dy,dp);
    }
}*/
