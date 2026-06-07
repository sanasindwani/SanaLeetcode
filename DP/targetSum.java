package DP;

public class targetSum {
    // Now acc to maths approach.. we can divide the whole array in positive and negative arrays 
// P - N = Target as whole array is divided into two sub arrays now these sub arrays will be subtracted to give us target
// And we can also say all elements are used atleast once thereby P + N = totalsum
// henceforth comparing these two we get an equation by adding them p = (totalsum + target)/2
// or we get N = (totalsum - target)/2
// therefor count subsets with P sum or N sum -> converted to count subset problem

// 1 array optimization
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        
        for(int i = 0; i < n; i++) sum += nums[i];

        if(Math.abs(target) > sum) return 0;
        if((sum - target) % 2 != 0) return 0;

        int p = (sum + target)/2;
        int[] prev = new int[p+1];

        prev[0] = (nums[0] == 0) ? 2 : 1;
        if(nums[0] != 0 && nums[0] <= p) prev[nums[0]] = 1;

        for(int i = 1; i < n; i++){
            for(int tar = p; tar >= 0; tar--){
                int notTake = prev[tar];
                int take = 0;
                if(nums[i] <= tar) take = prev[tar - nums[i]];

                prev[tar] = take + notTake;
            }
        }
        return prev[p];
    }
}

// Space Optimization
/*class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        
        for(int i = 0; i < n; i++) sum += nums[i];

        if(Math.abs(target) > sum) return 0;
        if((sum - target) % 2 != 0) return 0;

        int p = (sum + target)/2;
        int[] prev = new int[p+1];

        prev[0] = (nums[0] == 0) ? 2 : 1;
        if(nums[0] != 0 && nums[0] <= p) prev[nums[0]] = 1;

        for(int i = 1; i < n; i++){
            int[] curr =  new int[p+1];
            for(int tar = 0; tar <= p; tar++){
                int notTake = prev[tar];
                int take = 0;
                if(nums[i] <= tar) take = prev[tar - nums[i]];

                curr[tar] = take + notTake;
            }
            prev = curr;
        }
        return prev[p];
    }
}*/

// Tabulation
/*class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        
        for(int i = 0; i < n; i++) sum += nums[i];

        if(Math.abs(target) > sum) return 0;
        if((sum - target) % 2 != 0) return 0;

        int p = (sum + target)/2;
        int[][] dp = new int[n][p+1];

        dp[0][0] = (nums[0] == 0) ? 2 : 1;
        if(nums[0] != 0 && nums[0] <= p) dp[0][nums[0]] = 1;

        for(int i = 1; i < n; i++){
            for(int tar = 0; tar <= p; tar++){
                int notTake = dp[i-1][tar];
                int take = 0;
                if(nums[i] <= tar) take = dp[i-1][tar - nums[i]];

                dp[i][tar] = take + notTake;
            }
        }
        return dp[n-1][p];
    }
}*/



// Memoization
/*Time  = O(n * p)
  Space = O(n * p)*/
/*class Solution {
    int count(int n, int tar, int[] nums, int[][] dp){
        if(n < 0) return tar == 0 ? 1 : 0;
        if(dp[n][tar] != -1) return dp[n][tar];

        int notTake = count(n-1, tar, nums, dp);
        int take = 0;
        if(nums[n] <= tar) take = count(n-1, tar - nums[n], nums, dp);

        return dp[n][tar] = take + notTake;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) sum += nums[i];

        if(Math.abs(target) > sum) return 0;
        if((sum + target) % 2 != 0) return 0;

        int p = (sum + target)/2;

        int[][] dp = new int[n][p+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        
        int ne = (sum - target)/2;
        return count(n-1, p, nums, dp);
    }
}*/


// Recursion
/*class Solution {
    int count(int n, int tar, int[] nums){
        if(n < 0) return tar == 0 ? 1 : 0;

        int notTake = count(n-1, tar, nums);
        int take = 0;
        if(nums[n] <= tar) take = count(n-1, tar - nums[n], nums);

        return take + notTake;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) sum += nums[i];

        if((sum + target) % 2 != 0) return 0;
        if(Math.abs(target) > sum) return 0;

        int p = (sum + target)/2;
        int ne = (sum - target)/2;
        return count(n-1, p, nums);
    }
}*/

// Memoization I did because I thought that Target might get negative thereby but we can't use dp as array
/*class Solution {
    int count(int n, int T, int[] nums, HashMap<Integer, HashMap<Integer, Integer>> dp){

        if(n < 0) return T == 0 ? 1 : 0;
        
        if(dp.containsKey(n) && dp.get(n).containsKey(T)) return dp.get(n).get(T);

        int sub = count(n-1, T - nums[n], nums, dp);
        int add = count(n-1, T + nums[n], nums, dp);

        dp.putIfAbsent(n, new HashMap<>());
        dp.get(n).put(T, sub+add);

        return  sub+add;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, HashMap<Integer, Integer>> dp = new HashMap<>();
        
        return count(n-1, target, nums, dp);
    }
}*/

//Memoization my code
/*class Pair{
    int n;
    int T;
    Pair(int n, int T){
        this.n = n;
        this.T = T;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Pair)) return false;

        Pair p = (Pair) o;
        return n == p.n && T == p.T;
    }

    @Override
    public int hashCode(){
        return Objects.hash(n, T);
    }
}
class Solution {
    int count(int n, int T, int[] nums, HashMap<Pair,Integer> dp){

        if(n < 0) return T == 0 ? 1 : 0;
        
        if(dp.containsKey(new Pair(n,T))) return dp.get(new Pair(n,T));

        int sub = count(n-1, T - nums[n], nums, dp);
        int add = count(n-1, T + nums[n], nums, dp);

        dp.put(new Pair(n,T), sub+add);

        return  sub+add;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        HashMap<Pair, Integer> dp = new HashMap<>();
        
        return count(n-1, target, nums, dp);
    }
}*/


// Recursion 
/*class Solution {
    int count(int n, int T, int[] nums){
        if(n < 0) return T == 0 ? 1 : 0;

        int sub = count(n-1, T - nums[n], nums);
        int add = count(n-1, T + nums[n], nums);

        return sub+add;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return count(n-1, target, nums);
    }
}*/
