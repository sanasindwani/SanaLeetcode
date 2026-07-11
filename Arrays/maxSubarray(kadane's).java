// Kadane's algorithm
// TC -> O(N)
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int x : nums){
            currSum += x;
            maxSum = Math.max(maxSum, currSum);

            if(currSum <= 0){
                currSum = 0;
            } 
        }
        return maxSum;
    }
}