class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        // there are two ways one is prefix/suffix max and second is using a b as just prev window max option (like prev curr  array we used in DP)
        // as here we are using a space complexicity as O(N) 

        int n = nums.length;

        /*int[] pre= new int[n];
        pre[0] = nums[0];

        for(int i = 1; i < n; i++){
            pre[i] = Math.max(pre[i-1], nums[i]);
        }

        int max = 0;
        for(int j = k; j < n; j++){
            max = Math.max(max, pre[j-k] + nums[j]);
        }

        return max;*/

        int b = nums[0];
        int ans = 0;

        for(int i = k; i < n; i++){
            b = Math.max(b, nums[i-k]);
            ans = Math.max(ans, b + nums[i]);
        }
        return ans;
    }
}