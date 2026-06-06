// 1 array
//TC = O(n * W)
//SC = O(W)
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[] prev = new int[W+1];
        
        for(int i = wt[0]; i <= W; i++) prev[i] = val[0];
        
        for(int i = 1; i < n; i++){
            for(int wi = W; wi >= 0; wi--){
                int notTake = prev[wi];
                int take = 0;
                if(wt[i] <= wi) take = val[i] + prev[wi-wt[i]];
                
                prev[wi] = Math.max(take, notTake);
            }
        }
        return prev[W];
    }
}

// Space optimization
/*class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[] prev = new int[W+1];
        
        for(int i = wt[0]; i <= W; i++) prev[i] = val[0];
        
        for(int i = 1; i < n; i++){
            int[] curr = new int[W+1];
            for(int wi = 0; wi <= W; wi++){
                int notTake = prev[wi];
                int take = 0;
                if(wt[i] <= wi) take = val[i] + prev[wi-wt[i]];
                
                curr[wi] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[W];
    }
}*/

// Tabulation
/*class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][W+1];
        
        if(wt[0] > W) dp[0][W] = 0;
        else{
        for(int i = wt[0]; i <= W; i++) dp[0][i] = val[0];
        }
        
        for(int i = 1; i < n; i++){
            for(int wi = 0; wi <= W; wi++){
                int notTake = dp[i-1][wi];
                int take = 0;
                if(wt[i] <= wi) take = val[i] + dp[i-1][wi-wt[i]];
                
                dp[i][wi] = Math.max(take, notTake);
            }
        }
        return dp[n-1][W];
    }
}*/

// Memoization with updates Recursion
/*class Solution {
    int ans(int n, int W, int[] val, int[] wt, int[][] dp){
        
        if(n == 0){
            if(W >= wt[0]) return val[0];
            else return 0;
        }
        
        if(dp[n][W] != -1) return dp[n][W];
        
        int notTake = ans(n-1, W, val, wt, dp);
        int take = 0;
        if(wt[n] <= W) take = val[n] + ans(n-1, W - wt[n], val, wt, dp);
        
        return dp[n][W] = Math.max(take, notTake);
    }
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return ans(n-1, W, val, wt, dp);
    }
}*/

/*class Solution {
    int ans(int n, int W, int V, int[] val, int[] wt){
        
        if(n == 0){
            if(W >= wt[0]) return V + val[0];
            else return V;
        }
        
        int notTake = ans(n-1, W, V, val, wt);
        int take = 0;
        if(wt[n] <= W) take = ans(n-1, W - wt[n], V + val[n], val, wt);
        
        return Math.max(take, notTake);
    }
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        
        return ans(n-1, W, 0, val, wt);
    }
}*/
