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
/*
// TC -> O(N)
// SC -> O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(i > max) return false;

            max = Math.max(max, i + nums[i]);
            if(max >= n) return true;
        }

        return true;
    }
} */