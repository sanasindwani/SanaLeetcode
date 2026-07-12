// TABULATION IS THE IDEAL SOLUTION FOR THIS QUESTION
// we make a preferable DP tabel for this question and check the diagonal 
// for max value

// one array space optimization
class Solution {
    public int longCommSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int[] prev = new int[m+1];
        int ans = 0;
        
        for(int i = 1; i <= n; i++){
            int diag = 0;
            for(int j = 1; j <= m; j++){
                int temp = prev[j];
                // matching
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    prev[j] = 1 + diag;
                    ans = Math.max(ans, prev[j]);
                } else {
                    // not matching
                    prev[j] = 0;
                }
                diag = temp;
            }
        }
        return ans;
    }
}

// Space optimization using 2 arrays
/*class Solution {
    public int longCommSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int[] prev = new int[m+1];
        int ans = 0;
        
        for(int i = 1; i <= n; i++){
            int[] curr = new int[m + 1];
            for(int j = 1; j <= m; j++){
                // matching
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    curr[j] = 1 + prev[j - 1];
                    ans = Math.max(ans, curr[j]);
                } else {
                    // not matching
                    curr[j] = 0;
                }
            }
             prev = curr;
        }
        return ans;
    }
}*/

// Tabulation
/*class Solution {
    public int longCommSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                // matching
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    // not matching
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}*/

// memoization and recursion that we wrote was using global variable but without it 
// we have to pass it as a parameter and it has so many odds against it
// as first -> java passes primitives as values thus int is passed by value
// and max will be passed by values and while returnig will be lost
// we can't solve it by using return 1

// and if we use max as parameter we have 3 changing states and thus our DP will 
// become 3D complex DP which is too complex to solve thereby we use only TABULATION instead
// standard recursion + memoization technique
/*class Solution {
    int max = 0;
    int maxLen(int i, int j, String s1, String s2,int[][] dp){
        if(i < 0 || j < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)){
           int curr = 1 + maxLen(i - 1, j - 1, s1, s2, dp);
           max = Math.max(curr, max);
           
            maxLen(i - 1, j, s1, s2, dp);
            maxLen(i, j - 1, s1, s2, dp);
            
           return dp[i][j] = curr;
        }
        
        maxLen(i - 1, j, s1, s2, dp);
        maxLen(i, j - 1, s1, s2, dp);
        
        return dp[i][j] = 0;
    }
    public int longCommSubstr(String s1, String s2) {
        int i = s1.length();
        int j = s2.length();
        
        int[][] dp = new int[i][j];
        for(int k = 0; k < i; k++) Arrays.fill(dp[k], -1);
        
        maxLen(i - 1, j - 1, s1, s2, dp);
        return max;
    }
}*/