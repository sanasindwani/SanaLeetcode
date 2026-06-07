package DP;

public class coinChange {
    // Infinite supply || multiple use -> take stand at same index f(idx)
// Greedy fails because of non-uniformity 
// Space Optimization
// 1 - Array method
    public int CoinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[] prev = new int[amount+1];
        for(int i = 1; i <= amount; i++){
            if(i % coins[0] == 0) prev[i] = i/coins[0];
            else                  prev[i] = (int)1e8;
        }
//take needs the current row value because we can reuse the same coin again
        for(int idx = 1; idx < n; idx++){
            for(int amt = 0; amt <= amount; amt++){ //is correct only if prev is being updated from left to right in the same iteration.
                int notTake = prev[amt];
                int take = (int)1e8;
                if(coins[idx] <= amt) take = 1 + prev[amt - coins[idx]]; 

                prev[amt] = Math.min(take, notTake);
            }
        }

        if(prev[amount] == 1e8) return -1;
        return prev[amount];
    }
}


// Space optimization
// 2 - array method
/*class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[] prev = new int[amount+1];
        for(int i = 1; i <= amount; i++){
            if(i % coins[0] == 0) prev[i] = i/coins[0];
            else                  prev[i] = (int)1e8;
        }

        for(int idx = 1; idx < n; idx++){
            int[] curr = new int[amount+1];
            for(int amt = 0; amt <= amount; amt++){
                int notTake = prev[amt];
                int take = (int)1e8;
                if(coins[idx] <= amt) take = 1 + curr[amt - coins[idx]]; 

                curr[amt] = Math.min(take, notTake);
            }
            prev = curr;
        }

        if(prev[amount] == 1e8) return -1;
        return prev[amount];
    }
}*/


// Tabulation
/*class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount+1];
        for(int i = 1; i <= amount; i++){
            if(i % coins[0] == 0) dp[0][i] = i/coins[0];
            else                  dp[0][i] = (int)1e8;
        }

        for(int idx = 1; idx < n; idx++){
            for(int amt = 0; amt <= amount; amt++){
                int notTake = dp[idx-1][amt];
                int take = (int)1e8;
                if(coins[idx] <= amt) take = 1 + dp[idx][amt - coins[idx]]; // we can stay at same index because we can take a single coin multiple times

                dp[idx][amt] = Math.min(take, notTake);
            }
        }

        if(dp[n - 1][amount] == 1e8) return -1;
        return dp[n - 1][amount];
    }
}*/

// Memoization TC -> O(N*T)
// SC -> O(N*T) + O(T)
// Recursion + Memoization
// Recursion have exponential time complexicity  TC -> >> O(2^n)
// SC -> O(target) >> O(n) maybe coins are 1 thus -1 -> -1 target
/*class Solution {
    int count(int n, int amount, int[] coins, int[][] dp){
        if(amount == 0) return 0;
         
        if(n == 0){
            if(amount % coins[0] == 0) return amount/coins[0];
            else                       return (int)1e8;
        }

        if(dp[n][amount] != -1) return dp[n][amount];

        int notTake = count(n-1, amount, coins, dp);
        int take = (int)1e8;
        if(amount >= coins[n]) take = 1 + count(n, amount - coins[n], coins, dp);

        return dp[n][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        int ans = count(n-1, amount, coins, dp);

        if(ans == (int)1e8) return -1;
        return ans; 
    }
}*/
