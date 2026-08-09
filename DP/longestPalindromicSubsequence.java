// Space optimization using two variables 
// Here we reversed a string and used it as a second string and then found the Longest common subsequence between the two strings which will be the longest palindromic subsequence
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String res = sb.toString();

        int[]prev = new int[n+1];

        for(int i = 1; i <= n; i++){
            int dia = 0;
            for(int j = 1; j <= n; j++){
                int temp = prev[j];
                if(s.charAt(i - 1) == res.charAt(j - 1)){
                    prev[j] = 1 + dia;
                } else {
                    prev[j] = Math.max(prev[j], prev[j - 1]);
                }
                dia = temp;
            }
        }
        return prev[n];
    }
}


// Space optimization
/*class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String res = sb.toString();

        int[]prev = new int[n+1];

        for(int i = 1; i <= n; i++){
            int[] curr = new int[n + 1];
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == res.charAt(j - 1)){
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }
        return prev[n];
    }
}*/

// Tabulation
/*class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String res = sb.toString();

// 1 based indexing as we try to take diagonal and thus diagonal of 0,0 will be in negative so in order to prevent many (i > 0) (j > 0) checks instead we do this
        int[][] dp = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == res.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}*/

// recursion + memoization
/*class Solution {
    int LCS(int i, int j, String s1, String s2, int[][] dp){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + LCS(i - 1, j - 1, s1, s2, dp);

        return dp[i][j] = Math.max(LCS(i - 1, j, s1, s2, dp), LCS(i, j - 1, s1, s2, dp));
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String res = sb.toString();

        return LCS(n - 1, n - 1, s, res, dp);
    }
}*/


// This recursion works but will give TLE on long inputs
// Not every recursion can be memoized directly... as its states are index and a string which contains char until then
// we can't do only 1 states because in order to solve for other states we need to know what char we have carried until now
/*class Solution {
    int maxLen(int i, StringBuilder sb, String s){
        if(i < 0){
            int id = 0;
            int j = sb.length() - 1;

            while (id < j) {
                if (sb.charAt(id) != sb.charAt(j)) {
                    return 0;
                }
            id++;
            j--;
            }

            return sb.length();
        }

        int notTake = maxLen(i - 1, sb, s);

        sb.append(s.charAt(i));
        int take = maxLen(i - 1, sb, s);
        sb.deleteCharAt(sb.length() - 1);

        return Math.max(notTake, take);
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        return maxLen(n-1, sb, s);
    }
}*/
