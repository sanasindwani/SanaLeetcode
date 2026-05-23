package Arrays;
// %n will check for the last digit (nums.length-1) with first as when i = n-1 there by i+1 will be nums.length which is n -> % n will give us 0 -> first element 
// plus if count <= 1 returns true(already sorted or 1 occurence in the loop where i+1 < i)
// else return false
class Solution {
    public boolean check(int[] nums) {
        int cnt = 0;
        for (int i = 0, n = nums.length; i < n; ++i) {
            if (nums[i] > nums[(i + 1) % n]) {
                ++cnt;
            }
        }
        return cnt <= 1;
        // my code
       /* int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]) count++;
        }
        if(count == 1 && nums[nums.length - 1] <= nums[0]) return true;
        else if(count == 0)   return true;
        else return false; */
    }
}