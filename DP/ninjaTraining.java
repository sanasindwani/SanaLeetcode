package DP;
// SPACE OPTIMIZATION
// Bottom up
class Solution {
    public int maximumPoints(int[][] mat) {
        int x = mat.length;
        int p0 = mat[x-1][0];
        int p1 = mat[x-1][1];
        int p2 = mat[x-1][2];
        
        for(int i = x-2; i >= 0; i--){
         int curr0 = mat[i][0] + Math.max(p1,p2);
         int curr1 = mat[i][1] + Math.max(p0,p2);
         int curr2 = mat[i][2] + Math.max(p0,p1);
         
         p0 = curr0;
         p1 = curr1;
         p2 = curr2;
        }
       int max = Math.max(p0, Math.max(p1,p2));
       return max;
    }
}
// Top down 
/*class Solution {
    public int maximumPoints(int[][] mat) {

        int a = mat[0][0];
        int b = mat[0][1];
        int c = mat[0][2];

        for(int i = 1; i < mat.length; i++) {

            int na = mat[i][0] + Math.max(b, c);
            int nb = mat[i][1] + Math.max(a, c);
            int nc = mat[i][2] + Math.max(a, b);

            a = na;
            b = nb;
            c = nc;
        }

        return Math.max(a, Math.max(b, c));
    }
}*/

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
            if(i != y){
               int sum = mat[x][i] + maxAns(mat, x+1, i, dp); 
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
// Sir's methods
//Recursion + converted into memo

/*class Solution {
    int sum(int index, int day, int[][] mat, int[][] dp){
        if(index == 0){
            int max = 0;
            for(int i = 0; i < 3; i++){
                if(i != day){
                    max = Math.max(max, mat[0][i]);
                }
            }
            return max;
        }
        if(dp[index][day] != -1) return dp[index][day];
        int maxi = 0;
        for(int j = 0; j < 3; j++){
            if(j != day){
                int points = mat[index][j] + sum(index-1, j, mat, dp);
                maxi = Math.max(maxi, points);
            }
        }
        return dp[index][day] = maxi;
    }
    public int maximumPoints(int[][] mat) {
        int x = mat.length;
        int[][] dp = new int[x][4];
        for(int i = 0; i < x; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = sum(x-1, 3, mat, dp);
        return ans;
    }
}*/
// Tabulation 
/*class Solution {
    public int maximumPoints(int[][] mat) {
        int x = mat.length;
        int[][] dp = new int[x][4];
        dp[0][0] = Math.max(mat[0][1], mat[0][2]);
        dp[0][1] = Math.max(mat[0][0], mat[0][2]);
        dp[0][2] = Math.max(mat[0][0], mat[0][1]);
        dp[0][3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));
        

        for(int i = 1; i < x; i++){
            for(int j = 0; j < 4; j++){
                 int max = 0;
                for(int k = 0; k < 3; k++){
                    if(j != k){
                    int points = mat[i][k] + dp[i-1][k];
                    max = Math.max(max, points);
                }
            }
            dp[i][j] = max;
          }
        }
        return dp[x-1][3];
    }
}*/
//Space Optimization
/*class Solution {
    public int maximumPoints(int[][] mat) {
        int x = mat.length;
        int[] prev = new int[4];
        prev[0] = Math.max(mat[0][1], mat[0][2]);
        prev[1] = Math.max(mat[0][0], mat[0][2]);
        prev[2] = Math.max(mat[0][0], mat[0][1]);
        prev[3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));
        for(int i = 1; i < x; i++){
            int[] temp = new int[4];
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 3; k++){
                    if(k != j){
                        temp[j] = Math.max(temp[j], mat[i][k] + prev[k]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }
}*/