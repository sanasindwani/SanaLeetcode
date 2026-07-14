// ceil(n / divisor) = (n + divisor - 1) / divisor
// TC -> O(n log(max(nums))) binary search
// min sum we can get is n(size of arr)
// for linear TC -> O(n * max)
// low and high ends up at opposite polarity thus when(l < r)
class Solution {
    boolean check(int num, int[] nums, int th){
    int count = 0;

    for(int n : nums){
        count += (n + num - 1)/num;
    }

    if(count <= th) return true;
    return false;
    }
    public int smallestDivisor(int[] nums, int threshold) {
// can include if the n(size of array) > threshold -> not possible
         int n = nums.length;

        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }

        int l = 1, r = max;

        while(l <= r){
            int mid = (l + r)/2;

            if(check(mid, nums, threshold)){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}