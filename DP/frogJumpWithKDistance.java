package DP;
import java.util.Arrays;

public class frogJumpWithKDistance {
    // SPACE OPTIMIZATION (vaguely)
    // TC -> O(N * K)
    // SC -> O(K)
    /*class Solution {
    public int frogJump(int[] heights, int k) {
        List<Integer> ls = new ArrayList<>();
        int n = heights.length;
        ls.add(0);
        for(int i = 1; i < n; i++){
            int minSum = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++){
                if(i-j >= 0){
                    int totalSum = ls.get(ls.size() - j) + Math.abs(heights[i] - heights[i-j]);
                    minSum = Math.min(minSum, totalSum);
                }
            }
            if(ls.size() > k) ls.remove(0);
            ls.add(minSum);
        }
        return ls.get(ls.size()-1);
    }
} */
    // TABULATION
    // TC -> O(N*K)
    // SC -> O(N)
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= k; j++){
                if(i-j >= 0){
                    int totalSum = dp[i-j] + Math.abs(heights[i] - heights[i-j]);
                    dp[i] = Math.min(dp[i], totalSum);
                }
            }
        }
        return dp[n-1];
    }
}
//Memoization
// TC -> O(N*K)
// SC -> O(N) + O(N)
    /*class Solution {
    int count(int[] heights, int k, int[] dp, int n){
        if(n == 0) return 0;
        if(dp[n] != Integer.MAX_VALUE) return dp[n];
        for(int i = 1; i <= k; i++){
            if(n - i >= 0){
                int totalSum = count(heights, k, dp, n-i) + Math.abs(heights[n] - heights[n-i]);
            dp[n] = Math.min(dp[n], totalSum);
            }
        }
        return dp[n];
    }
    public int frogJump(int[] heights, int k) {
       int n = heights.length;
       if(n == 1) return 0;
       int[] dp = new int[n];
       Arrays.fill(dp, Integer.MAX_VALUE);
       count(heights, k, dp, n-1);
       return dp[n-1];
    }
}*/
