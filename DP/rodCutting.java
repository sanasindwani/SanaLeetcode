package DP;
// 1 array optimization
class rodCutting {
    public int cutRod(int[] price) {
        int n = price.length;
        
        int[] prev = new int[n+1];
        for(int i = 1; i <= n; i++) prev[i] = price[0]*i;
        
        
        for(int i = 2; i <= n; i++){
            
            for(int s = 1; s <= n; s++){
                
                int notTake = prev[s];
                int take = 0;
                if(s >= i) take = price[i-1] + prev[s - i];
                
                prev[s] = Math.max(take, notTake);
            }
        }
        
        return prev[n];
    }
}


// Space optimization
/*class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        
        int[] prev = new int[n+1];
        for(int i = 1; i <= n; i++) prev[i] = price[0]*i;
        
        
        for(int i = 2; i <= n; i++){
            int[] curr = new int[n+1];
            for(int s = 1; s <= n; s++){
                
                int notTake = prev[s];
                int take = 0;
                if(s >= i) take = price[i-1] + curr[s - i];
                
                curr[s] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[n];
    }
}*/


// Tabulation
/*class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) dp[1][i] = price[0]*i;
        
        
        for(int i = 2; i <= n; i++){
            for(int s = 1; s <= n; s++){
                
                int notTake = dp[i-1][s];
                int take = 0;
                if(s >= i) take = price[i-1] + dp[i][s - i];
                
                dp[i][s] = Math.max(take, notTake);
            }
        }
        return dp[n][n];
    }
}*/
// Recursion -> TC : exponential SC: O(N) where N is rod length
// Memoization -> TC : O(N*N) + O(N) SC-> O(N*N)
// Memoization + Recursion
/*class Solution {
    int val(int n, int s, int[] price, int[][] dp){
        if(s == 0) return 0;
        
        if(n == 1) return (price[0]*s);
        if(dp[n][s] != -1) return dp[n][s];
        
        int notTake = val(n-1, s, price, dp);
        int take = 0;
        if(s >= n) take = price[n-1] + val(n, s - n, price, dp);
        
        return dp[n][s] = Math.max(take, notTake);
    }
    public int cutRod(int[] price) {
       int n = price.length;
       
       int[][] dp = new int[n+1][n+1];
       for(int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);
       
       return val(n, n, price, dp); 
    }
}*/