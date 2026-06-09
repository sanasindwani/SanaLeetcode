package DP;
// Best solution
class coinChangeii {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];

        dp[0] = 1;

        for(int coin : coins){
            for(int amt = coin; amt <= amount; amt++){
                dp[amt] += dp[amt - coin]; 
            }
        }
        return dp[amount];
    }
}


// 1 array level 
/*class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[] prev = new int[amount+1];
        for(int am = 0; am <= amount; am++){
            if(am % coins[0] == 0) prev[am] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int amt = 0; amt <= amount; amt++){
                int notTake = prev[amt];
                int take = 0;
                if(coins[i] <= amt) take = prev[amt - coins[i]];

                prev[amt] = take+notTake;
            }
        }
        return prev[amount];
    }
}
*/
// Space optimization
/*class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[] prev = new int[amount+1];
        for(int am = 0; am <= amount; am++){
            if(am % coins[0] == 0) prev[am] = 1;
        }

        for(int i = 1; i < n; i++){
            int[] curr = new int[amount+1];
            for(int amt = 0; amt <= amount; amt++){
                int notTake = prev[amt];
                int take = 0;
                if(coins[i] <= amt) take = curr[amt - coins[i]];

                curr[amt] = take+notTake;
            }
            prev = curr;
        }
        return prev[amount];
    }
}*/

// Tabulation
/*class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount+1];
        for(int am = 0; am <= amount; am++){
            if(am % coins[0] == 0) dp[0][am] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int amt = 0; amt <= amount; amt++){
                int notTake = dp[i-1][amt];
                int take = 0;
                if(coins[i] <= amt) take = dp[i][amt - coins[i]];

                dp[i][amt] = take+notTake;
            }
        }
        return dp[n-1][amount];
    }
}*/

// Recursion + Memoization
/*class Solution {
    int count(int n, int amt, int[] coins, int[][] dp){
        if(amt == 0) return 1;
        if(n < 0) return 0;
        if(dp[n][amt] != -1) return dp[n][amt];

        int notTake = count(n-1, amt, coins, dp);
        int take = 0;
        if(coins[n] <= amt) take = count(n, amt - coins[n], coins, dp);

        return dp[n][amt] = take+notTake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return count(n-1, amount, coins, dp);
    }
}*/