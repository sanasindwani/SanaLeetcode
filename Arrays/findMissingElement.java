// iski time complexicity ho jayegi O(n log n + k)
// sort then loop then while loop for diff O(n log n + n + k) ~ O(n log n + k)
// not optimal
/*class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];

            while (diff > 1) {
                ans.add(nums[i - 1] + 1);
                nums[i - 1]++;
                diff--;
            }
        }

        return ans;
    }
}*/

// yeah ham max and min element nikal lenge then we create a frequency array arr and then we loop across the freq array and put the elements with zero freqency in the ans
// TC -> O(n) better/optimal
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];

        for(int i : nums){
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        int[] arr = new int[max + 1];
        for(int i : nums){
            arr[i]++;
        }

        for(int i=min;i<max;i++){
            if(arr[i] == 0)
                ans.add(i);
        }
        return ans;


    }
}