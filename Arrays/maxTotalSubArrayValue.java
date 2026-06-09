public class maxTotalSubArrayValue {
   class Solution {
    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;
        
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            m1 = Math.min(m1, nums[i]);
            m2 = Math.max(m2, nums[i]);
        }

        return (long)(m2 - m1)*k;
    }
} 
}
