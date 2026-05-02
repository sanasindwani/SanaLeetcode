package DP;
import java.util.Arrays;

public class houseRobber {
     /*int findMaxSum(List<Integer> a) {
        int n = a.size();
        if(n == 1) return a.get(0);
        int prev2 = a.get(0);
        int prev1 = Math.max(a.get(0), a.get(1));
        for(int i = 2; i < n; i++){
           int curri = Math.max(prev1, prev2 + a.get(i));
           prev2 = prev1;
           prev1 = curri;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i != n-1) a1.add(nums[i]);
            if(i != 0) a2.add(nums[i]);
        }
        return Math.max(findMaxSum(a1), findMaxSum(a2));
    }
}*/
     int maxSum(int[] nums, int n, int k, int[] dp){
        if(n > k) return 0;
        if(dp[n] != -1) return dp[n];
        int l = maxSum(nums, n+1, k, dp);
        int r = maxSum(nums, n+2, k, dp) + nums[n];
        dp[n] = Math.max(l, r);
        return dp[n];
    }
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1)return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int ans1 = maxSum(nums, 0, len-2, dp);
        Arrays.fill(dp, -1);
        int ans2 = maxSum(nums, 1, len-1, dp);
        return Math.max(ans1, ans2);
    }
}
