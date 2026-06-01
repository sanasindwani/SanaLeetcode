package DP;


//Space optimization
// TC -> O(N*K)
// SC -> O(K)
public class subsetSumEqualTarget {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        if(arr[0] <= k) prev[arr[0]] = true;

        for(int i = 1; i < n; i++){
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int target = 1; target <= k; target++){
                boolean notPick = prev[target];
                boolean pick = false;
                if(arr[i] <= target) pick = prev[target - arr[i]];

                curr[target] = pick || notPick;
            }
            prev = curr;
        }
        return prev[k];
    }
}

// Tabulation
// TC -> O(N*K)
// SC -> O(N*K) 
/*public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean[][] dp = new boolean[n][k+1];
        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(arr[0] <= k) dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++){
            for(int target = 1; target <= k; target++){
                boolean notPick = dp[i-1][target];
                boolean pick = false;
                if(arr[i] <= target) pick = dp[i-1][target - arr[i]];

                dp[i][target] = pick || notPick;
            }
        }
        return dp[n-1][k];
    }
}*/

//Memoization + Recursion
// Recursion TC-> O(2^n) SC-> O(N){recursion stack space}
// Memoization TC -> O(N*K) SC-> O(N*K) + O(N) 
/*public class Solution {
    static boolean f(int n, int target, int[] arr, int[][] dp){
        if(target == 0) return true;
        if(n == 0) return(target == arr[0]);
        if(dp[n][target] != -1) return dp[n][target] == 1;

        boolean notPick = f(n-1, target, arr, dp);
        boolean pick = false;
        if(arr[n] <= target) pick = f(n-1, target - arr[n], arr, dp);

        dp[n][target] = (pick || notPick) ? 1 : 0;
        return pick || notPick;
    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return f(n-1, k, arr, dp);
    }
}/*

// my methods -> recursion and memoization
/*public class Solution {
    static int sum(int n, int s, int k, int arr[], int[][] dp){
        if(s == k) return 1;
        if(s > k) return 0;
        if(n > arr.length-1) return 0;  // because if we put it first than the last index won't be considered  
        if(dp[n][s] != -1) return dp[n][s];
         
        int pick = sum(n+1, s + arr[n], k, arr, dp);
        if(pick == 1) return dp[n][s] = 1;
        int notPick = sum(n+1, s, k, arr, dp);
        
        if(notPick == 1) return dp[n][s] = 1;
        else             return dp[n][s] = 0;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        int ans = sum(0, 0, k, arr, dp);
        if(ans == 1) return true;
        else         return false;
    }
}*/
