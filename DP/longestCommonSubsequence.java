package DP;

import java.util.Arrays;

public class longestCommonSubsequence {
    // recursion TC -> exponential SC -> O(N+M)
// memoization TC -> O(N*M) + O(N+M)

// Striver recursion
class Solution {
    int val(int n, int m, String t1, String t2, int[][] dp){
        if(n < 0 || m < 0) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        if(t1.charAt(n) == t2.charAt(m)) return dp[n][m] = 1 + val(n-1, m-1, t1, t2, dp);

        return dp[n][m] = Math.max(val(n-1, m, t1, t2, dp), val(n, m-1, t1, t2, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return val(n-1, m-1, text1, text2, dp);
    }
}

// My codes
// 1 array space optimization
/*class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m+1];
        int pi = 0;

        for(int i = 1; i <= n; i++){
            pi = 0;
            for(int j = 1; j <= m; j++){
                int pv = prev[j];
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    prev[j] = 1 + pi;
                }


                else {
                    prev[j] = Math.max(prev[j], prev[j-1]);
                }

                pi = pv;

            }

        }
        return prev[m];
    }
}*/


// Space optimization
/*class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m+1];

        for(int i = 1; i <= n; i++){
            int[] curr = new int[m+1];
            for(int j = 1; j <= m; j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else  {
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}*/


// Tabulation
/*class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else  {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}*/

/*class Solution {
    int val(int i, int j, String t1, String t2, int[][] dp){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(t1.charAt(i) == t2.charAt(j)){
            return dp[i][j] = 1 + val(i-1, j-1, t1, t2, dp);
        }

        return dp[i][j] = Math.max(val(i-1, j, t1, t2, dp), val(i, j-1, t1, t2, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return val(n-1, m-1, text1, text2, dp);
    }
}*/

//  Recursion + Memoization
/*class Solution {
    int val(int i, int j, String t1, String t2, int[][] dp){
        if(i >= t1.length() || j >= t2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(t1.charAt(i) == t2.charAt(j)){
            return dp[i][j] = 1 + val(i+1, j+1, t1, t2, dp);
        }
        
        /*if(t1.charAt(i) != t2.charAt(j)){
            int takei = val(i+1, j, t1, t2);
            int takej = val(i, j+1, t1, t2);

            return Math.max(takei, takej);
        }
       return 0;*

        return dp[i][j] = Math.max(val(i+1, j, t1, t2, dp), val(i, j+1, t1, t2, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return val(0, 0, text1, text2, dp);
    }
}*/
}
