package DP;

public class printLongestSubsequence1 {
    // DFS + Backtracking solution
// we can also use brute approach 
// TC -> O(n+m)
// SC -> O(n*m)

//import java.util.Arrays;

// Tabulation solution
    public static String findLCS(int n, int m, String s1, String s2){
       int[][] dp = new int[n+1][m+1];

       for(int i = 1; i <= n; i++){
           for(int j = 1; j <= m; j++){
               if(s1.charAt(i-1) == s2.charAt(j-1)){
                   dp[i][j] = 1 + dp[i-1][j-1];
               } else {
                 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);  
               }
           }
       }

       StringBuilder s = new StringBuilder();
       int ni = n, nj = m;

       while(ni > 0 && nj > 0){
           if(s1.charAt(ni - 1) == s2.charAt(nj - 1)){
               s.append(s1.charAt(ni-1));
               ni--;
               nj--;
           } else {
               if(dp[ni-1][nj] > dp[ni][nj-1]){
                   ni--;
               } else {
                   nj--;
               }
           }
       }
       s.reverse();
       return s.toString();
   }
}

// Memoization
/*public class Solution {
   static int LCS(int n, int m, String s1, String s2, int[][] dp){
        if(n == 0 || m == 0) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
           return dp[n][m] = 1 + LCS(n-1, m-1, s1, s2, dp);
        }

        return dp[n][m] = Math.max(LCS(n-1, m, s1, s2, dp), LCS(n, m-1, s1, s2, dp));
    }
    public static String findLCS(int n, int m, String s1, String s2){
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);
        int len = LCS(n, m, s1, s2, dp);

        int i = n, j = m;
        StringBuilder s = new StringBuilder();

        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                s.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else {
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                } else {
                    j--;
                }
            }
        }

        s.reverse();

        return s.toString();
        
    }
}*/
