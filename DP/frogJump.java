package DP;

public class frogJump {
    // SPACE OPTIMIZED
    // FINAL CODE
  int minCost(int[] height){
      int n = height.length;
      if(n == 1) return 0;
      if(n == 2) return Math.abs(height[1] - height[0]);
      int prev2 = 0;
      int prev1 = Math.abs(height[1] - height[0]);
      for(int i = 2; i < n; i++){
          int curri = Math.min(
              prev1 + Math.abs(height[i] - height[i-1]),
              prev2 + Math.abs(height[i] - height[i-2]));
            prev2 = prev1;
            prev1 = curri;
      }
    return prev1;  
  }
}
// TABULATION
/*class Solution {
    int cost(int[] height, int n, int[] dp){
        dp[0] = 0;
        dp[1] = Math.abs(height[1] - height[0]);
        
        for(int i = 2; i < n; i++){
            dp[i] = Math.min(
                dp[i-1] + Math.abs(height[i] - height[i-1]),
                dp[i-2] + Math.abs(height[i] - height[i-2]));
        }
        return dp[n-1];
    }
    int minCost(int[] height){
        int n = height.length;
        if(n == 1) return 0;
        int[] dp = new int[n];
        return cost(height, n, dp);
    }
}*/
/*class Solution{
    int minCost(int[] height){
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            int fs = dp[i - 1] + Math.abs(height[i] - height[i-1]);
            int ss = Integer.MAX_VALUE; // handles when n = 1
            if(i > 1) ss = dp[i - 2] + Math.abs(height[i] - height[i-2]);
            dp[i] = Math.min(fs,ss);
        }
        return dp[n-1];
    }
}*/
// MEMOIZATION
// Now the recursion is self sufficient and is not dependent on DP 
/*class Solution {
    int cost(int[] height, int n, int[] dp){
        if(n == 0) return 0;
        if(n == 1) return Math.abs(height[1] - height[0]);
        if(dp[n] != -1) return dp[n];
        int totalSum1 = cost(height, n-1, dp) + Math.abs(height[n] - height[n-1]);
        int totalSum2 = cost(height, n-2, dp) + Math.abs(height[n] - height[n-2]);
        dp[n] = Math.min(totalSum1, totalSum2);
        return dp[n];
    }
    int minCost(int[] height){
        int n = height.length;
        if(n == 1) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return cost(height, n-1, dp);
    }
}*/

// but dp recursion here is dependent on dp we have to make some changes such that recursion is independent 
/*class Solution {
    int cost(int[] height, int n, int[] dp){
        if(n == 0) return 0;
        dp[1] = Math.abs(height[1] - height[0]); // now n == 0 and dp[1] checks for out of bounds 
        if(dp[n] != -1) return dp[n];
        int totalSum1 = cost(height, n-1, dp) + Math.abs(height[n] - height[n-1]);
        int totalSum2 = cost(height, n-2, dp) + Math.abs(height[n] - height[n-2]);
        dp[n] = Math.min(totalSum1, totalSum2);
        return dp[n];
    }
    int minCost(int[] height){
        int n = height.length;
        if(n == 1) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return cost(height, n-1, dp);
    }
}*/

/*class Solution {
    int cost(int[] height, int n, int[] dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int totalSum1 = cost(height, n-1, dp) + Math.abs(height[n] - height[n-1]);
        int totalSum2 = cost(height, n-2, dp) + Math.abs(height[n] - height[n-2]);
        dp[n] = Math.min(totalSum1, totalSum2);
        return dp[n];
    }
    int minCost(int[] height){
        int n = height.length;
        if(n == 1) return 0; // this was the issue with my code it tend to go out of bounds when n == 1
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[1] = Math.abs(height[1] - height[0]);
        return cost(height, n-1, dp);
    }
}*/


//BASIC RECURSION 
 // recursive approach very time consuming henceforth not preffered
/*class Solution {
    //test cases passes -> 1010/1115 beacuse of time complexixity
    int cost(int[] height, int n){
        if(n == 0) return 0;
        if(n == 1) return Math.abs(height[1] - height[0]);
        int totalSum1 = cost(height, n-1) + Math.abs(height[n] - height[n-1]);
        int totalSum2 = cost(height, n-2) + Math.abs(height[n] - height[n-2]);
        
        int min = Math.min(totalSum1, totalSum2);
        
        return min;
    }
    int minCost(int[] height) {
        int n = height.length - 1;
        int ans = cost(height, n);
        return ans;
    }
}*/