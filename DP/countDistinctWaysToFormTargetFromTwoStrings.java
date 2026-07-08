// this question inclde -> 2D prefix DP, inclusion exclusion principle, transitions, mask, 4D DP
// we were asked to give all ways in which we can form a target string from two words thus we use 3 states (2 indexes, length)
// now we were also asked ki we have to take atleast one char from both strings
// thus we used mask -> ab yeah mask joh hai voh 2D mask hai consists of 00(no word used), 01(word1 used only), 10(word2 used only), 11(both words used)
// this mask will tell us kis path se aayi hai hmari dp
// iske baad we use vahi sequence wala dp usual -> take / notTake

class Solution {
    static final int mod = 1000000007;
    public int interleaveCharacters(String word1, String word2, String target) {
        int n = word1.length();
        int m = word2.length();
        int sz = target.length();
// 1 - indexed DP banani hai
        long[][][][] dp = new long[n+1][m+1][sz+1][4];
// voh saari states jiska mask 0 hai plus length of target 0 hai voh = 1 kyonki there is only 1 way on any index to make an empty target
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j][0][0] = 1;
            }
        }
// Prefix DP + Mask + length of target = 4D DP
        for(int k = 1; k <= sz; k++){
            for(int i = 0; i <= n; i++){
                for(int j = 0; j <= m; j++){
                    for(int mask = 0; mask < 4; mask++){

                        // this code will be for not take(not taking from both word1 and word2)

                        if(i > 0){
                            dp[i][j][k][mask] += dp[i-1][j][k][mask];
                            dp[i][j][k][mask] %= mod;
                        }

                        if(j > 0){
                            dp[i][j][k][mask] += dp[i][j-1][k][mask];
                            dp[i][j][k][mask] %= mod;
                        }

                        if(i > 0 && j > 0){
                            dp[i][j][k][mask] -= dp[i-1][j-1][k][mask];
                            dp[i][j][k][mask] += mod; // we add MOD here kyonki when we subtract there is a possibility ki hmari term negative ho jaaye thus in order to prevent it ham +mod karte hai before using %
                            dp[i][j][k][mask] %= mod;
                        }

                        dp[i][j][k][mask] %= mod;

                        // now we'll write our transitions -> DP transitions
                        // or we can say take contribution

                        if(i > 0 && word1.charAt(i - 1) == target.charAt(k - 1)){
                            // ab only voh values joh & 1 = true dengi vahi jaa sakti which are 1 and 3 
                            // thus isse pehle agar 1 hi consider kiya gaya hai in String and agar dono consider kar liyae gaye hai which has mask = 3
                            // we are trying to put dp[i][j][k][mask] as dp[i-1][j][k-1][mask] kyonki abb hmari joh reccurenece hai usme we added a coloumn of a word and thus we want to know all possible ways which were there to reach the i - 1 or j - 1
                            if((mask & 1) != 0){
                                long curr = dp[i - 1][j][k - 1][mask] + dp[i - 1][j][k - 1][mask ^ 1];
                                curr %= mod;

                            // now we must've added all possible ways we could in non- take for j's varied values
                            // but here since its a prefix DP all  the values must've been added again when we added curr's [i-1][j][k-1] 
                            // thue we got to subtract the repeatative values

                            if(j > 0){
                                curr -= dp[i - 1][j - 1][k - 1][mask] + dp[i - 1][j - 1][k - 1][mask ^ 1];
                                curr = (curr + mod) % mod;
                            }
// now add curr's value in dp
                            dp[i][j][k][mask] += curr;
                            dp[i][j][k][mask] %= mod;
                        }
                    }

// repeat the same for word2 
                    if(j > 0 && word2.charAt(j - 1) == target.charAt(k - 1)){
                        if((mask & 2) != 0){
                            long curr = dp[i][j - 1][k - 1][mask] + dp[i][j - 1][k - 1][mask ^ 2];
                            curr %= mod;

                        if(i > 0){
                            curr -= dp[i - 1][j - 1][k - 1][mask] + dp[i - 1][j - 1][k - 1][mask ^ 2];
                            curr = (curr + mod) % mod;
                        }

                        dp[i][j][k][mask] += curr;
                        dp[i][j][k][mask] %= mod;

                      }
                    }
                     dp[i][j][k][mask] %= mod;
                }
            }
        }

    }

        return (int)dp[n][m][sz][3];
    }
}