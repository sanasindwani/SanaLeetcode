package DP;

public class partitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int x = nums.length;
        if(x == 1) return false;

        int sum = 0;
        for(int i = 0; i < x; i++) sum += nums[i];
        if(sum % 2 == 1) return false;

        int target = sum/2;
        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        if(nums[0] <= target) prev[nums[0]] = true;

        for(int num : nums){
            if(num > target)
            return false;
        }

        for(int i = 1; i < x; i++){
            boolean[] curr = new boolean[target+1];
            curr[0] = true;
            for(int t = 1; t <= target; t++){
                boolean groupB = prev[t];
                boolean groupA = false;
                if(nums[i] <= t) groupA = prev[t-nums[i]];

                curr[t] = groupA || groupB;
            }
            prev = curr;
        }  
    return prev[target];
    }
}

// Tabulation
/*class Solution {
    public boolean canPartition(int[] nums) {

        int x = nums.length;
        if(x == 1) return false;

        int sum = 0;
        for(int i = 0; i < x; i++) sum += nums[i];
        if(sum % 2 == 1) return false;

        int target = sum/2;
        boolean[][] dp = new boolean[x][target+1];
        for(int i = 0; i < x; i++) dp[i][0] = true;
        if(nums[0] <= target) dp[0][nums[0]] = true;

        for(int i = 1; i < x; i++){
            for(int t = 1; t <= target; t++){
                boolean groupB = dp[i-1][t];
                boolean groupA = false;
                if(nums[i] <= t) groupA = dp[i-1][t-nums[i]];

                dp[i][t] = groupA || groupB;
            }
        }  
    return dp[x-1][target];
    }
}*/

// Recursion + Memoization
/*class Solution {
    boolean f(int n, int sum, int[] nums, int[][] dp){
        if(sum == 0) return true;
        if(n == 0) return nums[0] == sum;

        if(dp[n][sum] != -1) return dp[n][sum] == 1;
    
        boolean groupB = f(n-1, sum, nums, dp);
        boolean groupA = false;
        if(nums[n] <= sum)
            groupA = f(n-1, sum - nums[n], nums, dp);

        dp[n][sum] = (groupA || groupB) ? 1 : 0;
        return (groupA || groupB);
    }
    public boolean canPartition(int[] nums) {
        int x = nums.length;
        int sum = 0;
        for(int i = 0; i < x; i++) sum += nums[i];
        if(sum % 2 == 1) return false;
        sum = sum/2;

        int[][] dp = new int[x][sum+1];
        for(int i = 0; i < x; i++) Arrays.fill(dp[i], -1);
   
        return f(nums.length-1, sum, nums, dp);
    }
}*/

/*class Solution {
    public boolean canPartition(int[] nums) {
        
        int x = nums.length;
        if(x == 1) return false;

        int sum = 0;
        for(int i = 0; i < x; i++) sum += nums[i];
        if(sum % 2 == 1) return false;

        sum = sum/2;
        boolean[][] dp = new boolean[x][sum+1];
        
        for(int i = 0; i < x; i++) dp[i][0] = true;
        if(nums[0] <= sum) dp[0][nums[0]] = true;

        for(int i = 1; i < x; i++){
            for(int j = 1; j <= sum; j++){
                    boolean notAdd = dp[i-1][j];
                    boolean add = false;
                    if(nums[i] <= j && j-nums[i] >= 0) add = dp[i-1][j-nums[i]];

                    dp[i][j] = notAdd || add;
            }
        }

        return dp[x-1][sum];
    }
}*/

// memory explodes
// TC -> O(n * S²)
// SC -> O(n * S²)
/*class Solution {
    public boolean canPartition(int[] nums) {
        
        int x = nums.length;
        if(x == 1) return false;
        int sum = 0;
        for(int i = 0; i < x; i++) sum += nums[i];
        if(sum % 2 == 1) return false;
        sum = sum/2;
        boolean[][][] dp = new boolean[x][sum+1][sum+1];
        if(nums[0] <= sum)dp[0][nums[0]][0] = true;
        if(nums[0] <= sum)dp[0][0][nums[0]] = true;

        for(int i = 1; i < x; i++){
            for(int j = 0; j <= sum; j++){
                for(int k = 0; k <= sum; k++){
                    if(dp[i-1][j][k] == true && j+nums[i] < sum+1) dp[i][j+nums[i]][k] = true;
                    if(dp[i-1][j][k] == true && k+nums[i] < sum+1) dp[i][j][k + nums[i]] = true;

                }
            }
        }

        return dp[x-1][sum][sum];
    }
}*/

/*class Solution {
    boolean f(int n, int sum1, int sum2, int[] nums, int[][][] dp){
        if(n == 0){
            if(sum1 + nums[0] == sum2 || sum1 == sum2 + nums[0]) return true;
            else return false;
        }
        if(dp[n][sum1][sum2] != -1) return dp[n][sum1][sum2] == 1;

        boolean groupA = f(n-1, sum1+nums[n], sum2, nums, dp);
        boolean groupB = f(n-1, sum1, sum2+nums[n], nums, dp);

        dp[n][sum1][sum2] = (groupA || groupB) ? 1 : 0;
        return (groupA || groupB);
    }
    public boolean canPartition(int[] nums) {
        int x = nums.length;
        int sum = 0;
        for(int i = 0; i < x; i++) sum += nums[i];
        sum = sum/2;
        int[][][] dp = new int[x][sum+1][sum+1];
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < sum; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(nums.length-1, 0, 0, nums, dp);
    }
}*/
