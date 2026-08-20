class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        if(n <= 2) return nums;
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2  = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        int l1 = nums[0], l2 = nums[1];

        for(int i = 2; i < n; i++){
            if(l1 > l2){
                arr1.add(nums[i]);
                l1 = nums[i];
            } else {
                arr2.add(nums[i]);
                l2 = nums[i];
            }
        }

        int[] res = new int[n];
        int idx = 0;
        for(int i = 0; i < arr1.size(); i++){
            res[idx++] = arr1.get(i);
        }
        for(int j = 0; j < arr2.size(); j++){
            res[idx++] = arr2.get(j);
        }

        return res;
    }
}