package DP;


public class countSubsetsWithSumK {


/*Time  : O(n * target)
  Space : O(target)*/
    public static int findWays(int num[], int tar) {
        int MOD = 1000000007;
        int n = num.length;
        int[] prev = new int[tar+1];
        prev[0] = (num[0] == 0) ? 2 : 1;
        if(num[0] != 0 && num[0] <= tar) prev[num[0]] = 1;

        for(int i = 1; i < n; i++){
            for(int t = tar; t >= 0; t--){
                int notTake = prev[t];
                int take = 0;
                if(num[i] <= t) take = prev[t-num[i]];

                prev[t] =  (int)(((long)take + notTake)%MOD);
            }
        }
        return prev[tar];
    }
}

// TC -> O(n*tar)
// SC -> O(tar)
/*public class Solution {
    public static int findWays(int num[], int tar) {
        int MOD = 1000000007;
        int n = num.length;
        int[] prev = new int[tar+1];
        prev[0] = (num[0] == 0) ? 2 : 1;
        if(num[0] != 0 && num[0] <= tar) prev[num[0]] = 1;

        for(int i = 1; i < n; i++){
            int[] curr = new int[tar+1];
            for(int t = 0; t <= tar; t++){
                int notTake = prev[t];
                int take = 0;
                if(num[i] <= t) take = prev[t-num[i]];

                curr[t] =  (int)(((long)take + notTake)%MOD);
            }
            prev = curr;
        }
        return prev[tar];
    }
}*/

// Tabulation
/*public class Solution {
    public static int findWays(int num[], int tar) {
        int MOD = 1000000007;
        int n = num.length;
        int[][] dp = new int[n][tar+1];

        //dp[0][0] = (num[0] == 0) ? 2 : 1;

        //if(num[0] != 0 && num[0] <= tar)
        //dp[0][num[0]] = 1;

        for(int i = 0; i < n; i++) dp[i][0] = 1;
        if(num[0] <= tar) dp[0][num[0]] += 1;

        for(int idx = 1; idx < n; idx++){
            for(int t = 0; t <= tar; t++){
                int notTake = dp[idx-1][t];
                int take = 0;
                if(num[idx] <= t) take = dp[idx-1][t-num[idx]];

                dp[idx][t] = (int)(((long)take + notTake) % MOD);
            }
        }
        return dp[n-1][tar];
    }
}*/

// Recursion + Memoization
/*public class Solution {
    static final int MOD = 1000000007;
    static int count(int n,int tar, int[] num, int[][] dp){
        
        if(n < 0) return tar == 0 ? 1 : 0;

        if(dp[n][tar] != -1) return dp[n][tar];

        int take = 0;
        if(num[n] <= tar) take = count(n-1, tar-num[n], num, dp);
        int notTake = count(n-1, tar, num, dp);

        return dp[n][tar] = (int)(((long)take + notTake) % MOD);
    }
    public static int findWays(int num[], int tar) {
       int x = num.length;
       int[][] dp = new int[x][tar+1];
       for(int i = 0; i < x; i++){
           Arrays.fill(dp[i], -1);
       }
       return count(x-1, tar, num, dp);
    }
}*/

// my code but gives wrong initialization
/*public class Solution {
    static int count(int n,int tar, int[] num, int[][] dp){
        if(tar == 0) return 1;
        if(n == 0) {
            if(tar == num[0]) return 1;
            else              return 0;
        }
        if(dp[n][tar] != -1) return dp[n][tar];

        int take = 0;
        if(num[n] <= tar) take = count(n-1, tar-num[n], num, dp);
        int notTake = count(n-1, tar, num, dp);

        return dp[n][tar] = take+notTake;
    }
    public static int findWays(int num[], int tar) {
       int x = num.length;
       int[][] dp = new int[x][tar+1];
       for(int i = 0; i < x; i++){
           Arrays.fill(dp[i], -1);
       }
       return count(x-1, tar, num, dp);
    }
}*/
