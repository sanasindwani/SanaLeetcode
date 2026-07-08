class NumArray {
    int[] prev;
    //int sum = 0;

    public NumArray(int[] nums) {

        int n = nums.length;
        prev = new int[n + 1];

        for(int i = 0; i < n; i++){
            // no need to cal sum then assign
            prev[i + 1] = prev[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        //if(left == 0) return prev[right];
        return (prev[right + 1] - prev[left]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */