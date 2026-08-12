// we can use a frq array joh store karega freq of digits seen till now 
// thus i can use a freq and iterate over the array and store freq of each digit and if any one of the digit will have i > k then i compare count of elements till now with Math.max and store it
// thus TC -> O(N) sliding window question
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        // constraints 10^9 tak hai freq array will be too long thus
        // int[] freq = new int[n + 1] can become too large
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        int l = 0, r = 0;
        int maxLen = 0;

        while(l < n && r < n){
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);

            //if(freq.get(nums[r]) > k){
                while(freq.get(nums[r]) > k){
                    freq.put(nums[l], freq.get(nums[l]) - 1);
                    l++;
                }
            //}
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}