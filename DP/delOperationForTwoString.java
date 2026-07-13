// same LCS code for two strings then subtract the LCS from both's strings length
// then add the remaining len and return it
class Solution {
    public int minDistance(String word1, String word2) {
         int n = word1.length();
         int m = word2.length();

        int[]prev = new int[m+1];

        for(int i = 1; i <= n; i++){
            int dia = 0;
            for(int j = 1; j <= m; j++){
                int temp = prev[j];
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    prev[j] = 1 + dia;
                } else {
                    prev[j] = Math.max(prev[j], prev[j - 1]);
                }
                dia = temp;
            }
        }

        int ans = (n - prev[m]) + (m - prev[m]);
        return ans;
    }
}