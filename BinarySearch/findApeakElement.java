// bs because well here we are guranteed a solution on the larger side because ->
// it can be all increasing or all decreasing or mix
// if it's all increasing it'll be at last if all decreasing mid is the ans
// if mix we will find a possible in between 
// thus we can discard one side based on what that abb the discarded side may or may not contains the ans 
// abb Tc -> O(log n)

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        int l = 0, r = n - 1;

        while(l <= r){
            int mid = (l + r)/2;
            // large arrays mein integer flow se bachane ke liyae we use mid = l + (r - l)/2

            if(mid < n - 1 && nums[mid] < nums[mid+1]){
                l = mid + 1;
            }
            else if(mid > 0 && nums[mid] < nums[mid - 1]){
                r = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
sana