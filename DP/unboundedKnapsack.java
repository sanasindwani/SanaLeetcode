package DP;


public class unboundedKnapsack {
    public static int UnboundedKnapsack(int n, int w, int[] profit, int[] weight) {
       int[] dp = new int[w+1];
		
			for(int j =1; j<=w;j++){
		for(int i  = 0;i<n;i++){
				if(j>= weight[i]){
					dp[j] = Math.max(dp[j] , profit[i] + dp[j - weight[i]]);
				}
			}
		}
		return dp[w];
    }
}

/*public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[] dp = new int[w+1];
        if(weight[0] <= w) dp[weight[0]] = profit[0];

        for(int i = 0; i < n; i++){
            for(int wt = weight[i]; wt <= w; wt++){
                dp[wt] = Math.max(profit[i] + dp[wt - weight[i]], dp[wt]);
            }
        }
        return dp[w];
    }
}*/

// 1 array space optimization
/*public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

        int[] prev = new int[w+1];

        for(int i = weight[0]; i <= w; i++){
            prev[i] = (i/weight[0])*profit[0];
        }

        for(int i = 1; i < n; i++){
            for(int wt = 0; wt <= w; wt++){
                int notTake = prev[wt];

                int take = 0;
                if(weight[i] <= wt) take =profit[i] + prev[wt - weight[i]];

                prev[wt] = Math.max(take, notTake);
            }
        }
        return prev[w];
    }
}*/


// Space optimization
/*public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

        int[] prev = new int[w+1];

        for(int i = weight[0]; i <= w; i++){
            prev[i] = (i/weight[0])*profit[0];
        }

        for(int i = 1; i < n; i++){
            int[] curr = new int[w+1];
            for(int wt = 0; wt <= w; wt++){
                int notTake = prev[wt];

                int take = 0;
                if(weight[i] <= wt) take =profit[i] + curr[wt - weight[i]];

                curr[wt] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[w];
    }
}*/

// Tabulation
/*public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

        int[][] dp = new int[n][w+1];

        for(int i = weight[0]; i <= w; i++){
            dp[0][i] = (i/weight[0])*profit[0];
        }

        for(int i = 1; i < n; i++){
            for(int wt = 0; wt <= w; wt++){
                int notTake = dp[i-1][wt];

                int take = 0;
                if(weight[i] <= wt) take =profit[i] + dp[i][wt - weight[i]];

                dp[i][wt] = Math.max(take, notTake);
            }
        }
        return dp[n-1][w];
    }
}*/

// Recursion + Memoization
/*public class Solution {
    static int count(int n, int W, int[] pft, int[] wt, int[][] dp){

        if(W == 0) return 0;

        // or we can write if(n == 0) return (W/w[0])*pft[0];

        if(n == 0){
            if(wt[0] <= W) return (W/wt[0])*pft[0];
            else           return 0;
        }

        if(dp[n][W] != -1) return dp[n][W];

        int notTake = count(n-1, W, pft, wt, dp);

        int take = 0;
        if(wt[n] <= W) take = pft[n] + count(n, W - wt[n], pft, wt, dp);

        return dp[n][W] = Math.max(notTake, take);
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

        int[][] dp = new int[n][w+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return count(n-1, w, profit, weight, dp);
    }
}*/
