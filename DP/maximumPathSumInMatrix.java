package DP;

public class maximumPathSumInMatrix {
    // Space optimization
    public int maximumPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] front = new int[m];
        
        for(int i = 0; i < m; i++){
            front[i] = mat[n-1][i];
        }
        
        for(int i = n-2; i >= 0; i--){
            int[] curr = new int[m];
            for(int j = 0; j < m; j++){
                int dgr = 0, dgl = 0;
                int same = mat[i][j] + front[j];
                if(j > 0) dgl = mat[i][j] + front[j-1];
                if(j < m-1) dgr = mat[i][j] + front[j+1];
                
                curr[j] = Math.max(same, Math.max(dgl,dgr));
            }
            front = curr;
        }
        int max = 0;
        for(int k = 0; k < m; k++){
            if(front[k] > max) max = front[k];
        }
        return max;
    }
}

// Tabularization
/*class Solution {
    public int maximumPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < m; i++){
            dp[n-1][i] = mat[n-1][i];
        }
        
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j < m; j++){
                int dgr = 0, dgl = 0;
                int same = mat[i][j] + dp[i+1][j];
                if(j > 0) dgl = mat[i][j] + dp[i+1][j-1];
                if(j < m-1) dgr = mat[i][j] + dp[i+1][j+1];
                
                dp[i][j] = Math.max(same, Math.max(dgl,dgr));
            }
        }
        int max = 0;
        for(int k = 0; k < m; k++){
            if(dp[0][k] > max) max = dp[0][k];
        }
        return max;
    }
}*/

// Recursion + Memoization
/*class Solution {
    int sana(int i, int j, int n,int m, int[][] mat, int[][] dp){
        if(i == n-1) return mat[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int same = mat[i][j] + sana(i+1, j, n, m, mat, dp);
        int dgl = 0, dgr = 0;
        if(j > 0){
            dgl = mat[i][j] + sana(i+1, j-1, n, m, mat, dp);
        }
        if(j < m-1) {
            dgr = mat[i][j] + sana(i+1, j+1, n, m, mat, dp);
        }
        
        return dp[i][j] = Math.max(same, Math.max(dgl,dgr));
    }
    public int maximumPath(int[][] mat) {
        int x = mat.length;
        int y = mat[0].length;
        int[][] dp = new int[x][y];
        for(int i = 0; i < x; i++) Arrays.fill(dp[i], -1);
        int max = 0;
        for(int i = 0; i < x; i++){
            int res = sana(0,i,x,y,mat, dp);
            max = Math.max(res,max);
        }
        return max;
    }
}*/
