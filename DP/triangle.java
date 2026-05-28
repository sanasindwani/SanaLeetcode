package DP;

import java.util.List;

public class triangle {
    // Space Optimization
// TC -> O(N*N)
// SC -> O(N)
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] front = new int[n];
        for(int i = 0; i < n; i++){
           front[i] = triangle.get(n-1).get(i);
        }

        for(int i = n-2; i >= 0; i--){
            int[] curr = new int[n];
            for(int j = 0; j <= i; j++){
                int d = triangle.get(i).get(j) + front[j];
                int dg = triangle.get(i).get(j) + front[j+1];

                curr[j] = Math.min(d,dg);
            }
            front = curr;
        }
        return front[0];
    }
}

// Tabulation sir's method
/*class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
           dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                int d = triangle.get(i).get(j) + dp[i+1][j];
                int dg = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(d,dg);
            }
        }
        return dp[0][0];
    }
}*/

// Tabulation 
/*class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int s = triangle.size();
        int[][] dp = new int[s][s];
        dp[0][0] = triangle.get(0).get(0);

        for(int l = 1; l < s; l++){
            for(int i = 0; i < triangle.get(l).size(); i++){
               
                int same = 100000000, next = 100000000;
                if(i != triangle.get(l).size() - 1)same = triangle.get(l).get(i) + dp[l-1][i];
                if(i > 0) next = triangle.get(l).get(i) + dp[l-1][i-1];
                dp[l][i] = Math.min(same, next); 
    
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < s; i++){
        if(dp[s-1][i] < min) min = dp[s-1][i];
        }
        return min;
    }
}*/


/*class Solution {
    int sanae(int x,int l, int s, List<List<Integer>> triangle, int[][] dp){
        if(l == s) return triangle.get(l-1).get(x);
        if(dp[l-1][x] != -1) return dp[l-1][x];
        int same = triangle.get(l-1).get(x) + sanae(x, l+1, s, triangle, dp);
        int next = triangle.get(l-1).get(x) + sanae(x+1, l+1, s, triangle, dp);

        return dp[l-1][x] = Math.min(same,next);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int s = triangle.size();
        int[][] dp = new int[s][s];
        for(int i = 0; i < s; i++) Arrays.fill(dp[i], -1);
        return sanae(0,1,s,triangle,dp);
    }
}*/
// 2ms solution
/*class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();

        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }

        return sanaa(n,0,0,triangle,dp);

    }

    private int sanaa(int n, int i, int j, List<List<Integer>> triangle, int[][] dp){
        if(i==n-1){
            return triangle.get(i).get(j);
        }

        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int pick = triangle.get(i).get(j) + fun(n,i+1,j,triangle,dp);
        int picknot = triangle.get(i).get(j) + fun(n,i+1,j+1,triangle,dp);

        return dp[i][j] = Math.min(pick,picknot);

    }
}*/
