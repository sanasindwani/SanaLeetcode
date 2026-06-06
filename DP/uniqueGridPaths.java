package DP;
//Using combinatrics 
class uniqueGridPaths {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int r = m - 1; // or I can do n-1
        long res = 1;
        for(int i = 1; i <= r; i++){
            res = res*(N - r + i)/i;
        }
        return (int)res;
    }
}


// Solved using DP
// Space Optimization
/*class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        prev[0] = 1;
        for(int i = 0; i < m; i++){
                int[] temp = new int[n];
            for(int j = 0; j < n; j++){
                if(j > 0)temp[j] = prev[j] + temp[j-1];
                else temp[j] = prev[j];
            }
            prev = temp;
        }
        return prev[n-1];
    }
}*/
// Tabulation
/*class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int up = 0, left = 0;
                if( i == 0 && j == 0) dp[i][j] = 1;
                else{
                    if (i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];

                dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}*/
// Memoization
/*class Solution {
    int ans(int m, int n, int[][] dp){
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
    
        int up = ans(m - 1, n, dp);
        int left = ans(m, n - 1, dp);

        return dp[m][n] = up + left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        int res = ans(m-1,n-1, dp);
        return res;
    }
}*/
// Recursion
/*class Solution {
    int ans(int m, int n){
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        
        int up = ans(m - 1, n);
        int left = ans(m, n - 1);

        return up + left;
    }
    public int uniquePaths(int m, int n) {
        int res = ans(m-1,n-1);
        return res;
    }
}*/
// My methods 
//Tabulation
/*class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int k = 0; k < n; k++){
            dp[0][k] = 1;
        }
        for(int k = 0; k < m; k++){
            dp[k][0] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}*/
// Memoization
/*class Solution {
    int ans(int x, int y,int m, int n, int[][] dp){
        if(x == m || y == n) return 1;
        if(dp[x][y] != 0) return dp[x][y];
        int left = ans(x+1, y, m, n, dp);
        int right = ans(x, y+1, m, n, dp);

        return dp[x][y] = left+right;

    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        return ans(1,1,m,n,dp);
    }
}*/