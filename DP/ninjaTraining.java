package DP;
// TABULATION

/*class Solution {
    public int maximumPoints(int[][] mat) {
        int x = mat.length;
        int[][] dp = new int[x][3];
        for(int i = 0; i < 3; i++){
            dp[x-1][i] = mat[x-1][i];
        }
    
        for(int i = x-2; i >= 0; i--){
            for(int j = 0; j < 3; j++){
                int max = 0;
                for(int k = 0; k < 3; k++){
                    if(k != j){
                    int ans = mat[i][j] + dp[i+1][k];
                    max = Math.max(ans, max);
                    }
                }
                dp[i][j] = max; 
            }
        }
        //int res = Math.max(dp[0][0],Math.max(dp[0][1], dp[0][2]));
        int res = dp[0][0];
        for(int z = 0; z < 3; z++){
            if(dp[0][z] > res) res = dp[0][z];
        }
        return res;
    }
}*/

// MEMOIZATION

/*class Solution {
    int dfsMaxSum(int mat[][], int x, int y, int[][] dp){
        if(x >= mat.length) return 0;
        if(dp[x][y+1] != -2) return dp[x][y+1];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++){
            if(i != y){
              max = Math.max(dfsMaxSum(mat, x+1, i, dp)+mat[x][i],max);  
            } 
        }
        return dp[x][y+1] = max;
    }
    public int maximumPoints(int mat[][]) {
        int[][] dp = new int[mat.length][4];
        for(int i = 0; i < mat.length; i++){
            Arrays.fill(dp[i], -2);
        }
        int ans = dfsMaxSum(mat, 0, -1, dp);
        return ans;
    }
}*/
/*class Solution {
    int dfs(int[][] mat, int row, int last, int[][] dp) {
        if (row == mat.length) return 0;

        if (dp[row][last + 1] != -1) return dp[row][last + 1];

        int max = 0;

        for (int col = 0; col < 3; col++) {
            if (col != last) {
                int points = mat[row][col] + dfs(mat, row + 1, col, dp);
                max = Math.max(max, points);
            }
        }

        return dp[row][last + 1] = max;
    }

    public int maximumPoints(int[][] mat) {
        int n = mat.length;
        int[][] dp = new int[n][4];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(mat, 0, -1, dp);
    }
}*/
//REVISION
/*class Solution {
    int maxAns(int[][] mat,int x, int y, int[][] dp){
        if(x >= mat.length) return 0;
        if(dp[x][y+1] != -1) return dp[x][y+1];
        int max = 0;
        for(int i = 0; i < mat[0].length; i++){
            int sum = 0;
            if(i != y){
                sum += mat[x][i] + maxAns(mat, x+1, i, dp); 
                max = Math.max(max, sum);
            }
        }
        return dp[x][y+1] = max;
    }
    public int maximumPoints(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length+1];
        for(int j = 0; j < mat.length; j++){
            Arrays.fill(dp[j], -1);
        }
        int res = maxAns(mat, 0, -1, dp);
        return res;
    }
}*/
