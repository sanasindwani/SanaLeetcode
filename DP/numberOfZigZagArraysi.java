// better way is using dp with 2 states -> index + prevState(up/down) direction
// thus tabulation is preffered 
//A valid ZigZag array cannot have two consecutive UP moves or two consecutive down.. Therefore directions must alternate: up -> down -> up.. like this
class Solution {
    // mod bana lo pehle toh final means won't be changed after assignment
        static final int MOD = 1_000_000_007; // underscores are just for readability 
    public int zigZagArrays(int n, int l, int r) {
        int m = r-l+1;

        if(n == 1) return m; // return all m possible 

        long[][] dp = new long[m][2]; // previous row of dp 
        long[][] ndp = new long[m][2]; // yeah new length update karega  

        // this is for n = 2 we update dp 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(i == j) continue;

                if(i < j) dp[j][1]++;
                else      dp[j][0]++;
            }
        }

// here we actually calculate all possible arrays
        for(int len = 3; len <= n; len++){ // length 3 to n tak iteration karni and calculate karna dp and ndp

// set ndp to 0 after assigning dp = ndp
            for(int k = 0; k < m; k++){
                ndp[k][1] = 0;
                ndp[k][0] = 0;
            }
// prefix up and prefix down banayenge
            long[] pfUp = new long[m+1];
            long[] pfDown = new long[m+1];

// we'll calculate prefix so that complexixity O(n^2) hi rahe not O(n^3)
            for(int i = 0; i < m; i++){
                pfUp[i+1] = (pfUp[i] + dp[i][1]) % MOD;
                pfDown[i+1] = (pfDown[i] + dp[i][0]) % MOD;
            }
            // now we'll calculate new ndp
// ndp har possible ending value of i ke liyae calculate hoga
            for(int i = 0; i < m; i++){

                // if this move is up.. previous down hoga
                ndp[i][1] = pfDown[i];

                // abb agar yeah move down hai previous up hoga
                // if we consider previous as up then this value must be down and let's say 3 so i = greater than 3 -> 4, 5, 6.. hi hona chahiyae 
                //but previous up me hame saari unn values ka sum chahiyae joh greater than 3 hogi and prev[i] = prev[i-1] + prev[i-1].. previous values ko lenge
                // thus prev[m] - prev[i+1] (to take itself as well) 

                //ndp[i][0] = (pfUp[m] - pfUp[i+1]) % MOD; // it can become negative thus we add MOD
                ndp[i][0] = (pfUp[m] - pfUp[i+1] + MOD) % MOD;
            }

            // now we assign dp to ndp 
            // we can create a new array every time we iterate but it would be slow thus ham bss refernece change kar rahi 
            long[][] temp = dp;
            dp = ndp;
            ndp = temp;
      }
      // total array sum
      long ans = 0;

      // yeah last row me jitni bhi possible values hai unka sum hoga
      // thus now dp will be pointing to last row of dp table and sabki length n hogi and we have to combine all possible ways to form an array with length n 
      for(int i = 0; i < m; i++){
        ans = (ans + dp[i][0] + dp[i][1]) % MOD;
      }

      return (int) ans; // convert ans to int from long 
    }
}

/*class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) return m;

        long[][] dp = new long[m][2];
        long[][] ndp = new long[m][2];

        // length = 2
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {
                if (a == b) continue;

                if (a < b) dp[b][1]++; // last move was up
                else dp[b][0]++;      // last move was down
            }
        }

        for (int len = 3; len <= n; len++) {

            for (int i = 0; i < m; i++) {
                ndp[i][0] = 0;
                ndp[i][1] = 0;
            }

            long[] prefUp = new long[m + 1];
            long[] prefDown = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefUp[i + 1] = (prefUp[i] + dp[i][1]) % MOD;
                prefDown[i + 1] = (prefDown[i] + dp[i][0]) % MOD;
            }

            for (int x = 0; x < m; x++) {

                // previous move was down, so next must go up
                ndp[x][1] =
                        prefDown[x];

                // previous move was up, so next must go down
                ndp[x][0] =
                        (prefUp[m] - prefUp[x + 1] + MOD) % MOD;
            }

            long[][] temp = dp;
            dp = ndp;
            ndp = temp;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + dp[i][0] + dp[i][1]) % MOD;
        }

        return (int) ans;
    }
}*/

// pick not pick is not the best option 
// gives TLE
// is forced solution
/*class Solution {
    int count(int idx, int j, int[] arr, int n, int prev1, int prev2) {

    if(idx == n) return 1;

    if(j == arr.length) return 0;

    int notPick = count(idx, j + 1, arr, n, prev1, prev2);

    int pick = 0;
    int x = arr[j];

    if(x != prev1) {

        if(prev2 == -1 ||
          !((x > prev1 && prev1 > prev2) ||
            (x < prev1 && prev1 < prev2))) {

            pick = count(idx + 1, 0, arr, n, x, prev1);
        }
    }

    return pick + notPick;
}
    public int zigZagArrays(int n, int l, int r) {
        int[] arr = new int[r-l+1];


        for(int i = 0; i < r-l+1; i++){
            arr[i] = i+1;
        }
        return count(0, 0, arr, n, -1, -1);
    }
}*/

// recursion giving TLE
// thereby memoization is not an ideal solution for this problem hence prefer tabulation
// dp[len][v][dir] -> dp[n][dir] (tabulation) therefore tabulation is optimized solution  
// can't be converted to DP as too many states -> 3D dp 
// ranges is till 2000 memory will explode
/*class Solution {
    int count(int idx, int n, int l, int r, int prev1, int prev2){
        if(idx == n) return 1;
        int ans = 0;
        for(int i = l; i <= r; i++){
            if(i != prev1){
                if(prev2 == -1)   ans += count(idx+1, n, l, r, i, prev1);

                if (prev2 != -1 && !((i > prev1 && prev1 > prev2) || (i < prev1 && prev1 < prev2))) ans += count(idx+1, n, l, r, i, prev1);
            }
        }
        return ans;
    }
    public int zigZagArrays(int n, int l, int r) {
        return count(0, n, l, r, -1, -1);
    }
}*/