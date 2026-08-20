class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        
        int[][] dp = new int[len1 + 1][len2 + 1];

// yeah bangaya hmara lcs ka table 
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

// abb do options hai ya toh lcs + uncommon part form both the strings 
// ya toh seedha backtrack karke from the lcs table bhi we can create the scs 
        StringBuilder st = new StringBuilder();
        int i = len1, j = len2;

        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                st.append(str1.charAt(i - 1));
                i--;
                j--;
            }

            else if(dp[i - 1][j] > dp[i][j - 1]){
                st.append(str1.charAt(i - 1));
                i--;
            }

            else{
                st.append(str2.charAt(j - 1));
                j--;
            }
        }

        while(i > 0){
            st.append(str1.charAt(i - 1));
            i--;
        }
        while(j > 0){
            st.append(str2.charAt(j - 1));
            j--;
        }
        return st.reverse().toString();
    }
}