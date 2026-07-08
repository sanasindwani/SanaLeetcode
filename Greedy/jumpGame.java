class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;

        int jc = nums[0];

        for(int i = 1; i < n; i++){
            if(jc == 0) return false;
            jc--;

            if(nums[i] > jc) jc = nums[i];

            if(nums[i] - (n - 1 - i) >= 0) return true;
        }

        return false;
    }
}