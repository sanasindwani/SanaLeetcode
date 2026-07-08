class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;

        while(l <= r){
            int mid = l + (r - l)/2;

            if(nums[mid] < target){
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }

        if(l >= n) return n;
        else if(nums[l] == target) return l;
        return l;
    }
}