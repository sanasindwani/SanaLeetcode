package DP;

// contains all memoization, tabularization and recurrsion methods
class climbingStairs{
    int count(int n){
        int prev1 = 1;
        int prev2 = 1;
        for(int i = 2; i <= n; i++){
            int curri = prev1 + prev2;
            prev2 = prev1;
            prev1 = curri;
        }
        return prev1;
    }
     public int climbStairs(int n){
        return count(n);
     }
}

/*class Solution {
    int count(int n, int[] dp){
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = count(n-1, dp) + count(n-2, dp); 
    }
    public int climbStairs(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return count(n, dp);
    }
}*/
/*class Solution {
    int count(int n, int sum){
        if(sum == n) return 1;
        if(sum > n) return 0;
        int ans = count(n, sum+1) + count(n, sum+2);
        return ans;
    }
    public int climbStairs(int n) {
        int ans = count(n, 0);
        return ans;
    }
}*/
/*class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;

        int prev2 = 1; 
        int prev1 = 1; 

        for(int i = 2; i <= n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}*/
/*class Solution {
    int count(int n, int sum){
        if(sum == n) return 1;
        if(sum > n) return 0;

        int l = count(n, sum+1);
        int r = count(n, sum+2);

        return l + r;
    }
    public int climbStairs(int n) {
        return count(n,0);
    }
}*/
/*
 Recursion method
class Solution {
    int count(int n){
        if(n == 0 || n == 1) return 1;
        return count(n-1) + count(n-2);
    }
 public int climbStairs(int n){
    return count(n);
 }
}*/