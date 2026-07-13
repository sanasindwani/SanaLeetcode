// space optimization using 1- array and 2 variables
class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String res = sb.toString();

        int[]prev = new int[n + 1];

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

        return n - prev[n];
    }
}

// Space optimization using 2- array
/*class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String res = sb.toString();

        int[]prev = new int[n + 1];

        for(int i = 1; i <= n; i++){
            int[] curr = new int[n + 1];
            for(int j = 1; j <= n; j++){

                if(s.charAt(i - 1) == res.charAt(j - 1)){
                    curr[j] = 1 + prev[j-1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }

        return n - prev[n];
    }
}*/

// Tabulation
/*class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String res = sb.toString();

        int[][] dp = new int[n+ 1][n + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){

                if(s.charAt(i - 1) == res.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return n - dp[n][n];
    }
}*/

// recursion + memoization
/*class Solution {
    int f(int i, int j, String s1, String s2, int[][] dp){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + f(i - 1, j - 1, s1, s2, dp);
        }

        return dp[i][j] = Math.max(f(i - 1, j, s1, s2, dp), f(i, j - 1, s1, s2, dp));
    }
    public int minInsertions(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String res = sb.toString();

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        int ans = f(n - 1, n - 1, s, res, dp);

        return n - ans;
    }
}*/