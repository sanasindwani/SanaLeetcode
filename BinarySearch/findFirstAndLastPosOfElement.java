class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int l = 0, r = n-1;

        while(l <= r){
            int mid = l + (r - l)/2;

            if(nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if(l >= n || nums[l] != target) return new int[]{-1,-1};
        int start = l;

        l = 0;
        r = n-1;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int end = l;

        return new int[]{start, end - 1};
    }
}