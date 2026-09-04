// isme ham prefix or max element ko saath me conatin karke chal rahe hai because hame purane max ki need nahi thus instead of making another array and increasing space complexicity by O(n) we can just use a variable O(1)
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] right=new int[n];
        right[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
         right[i]=Math.min(right[i+1],nums[i]);
        }
        int left=0;
        for(int i=0;i<n;i++){
            left=Math.max(left,nums[i]);
            if(left-right[i]<=k){
                return i;
            }
        }
        return -1;
    }

}

/*class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] pref = new int[n];
        pref[0] = nums[0];
        int[] suf = new int[n];
        suf[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++){
            pref[i] = Math.max(nums[i], pref[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--){
            suf[i] = Math.min(nums[i], suf[i + 1]);
        }

        for(int i = 0; i < n; i++){
            if(pref[i] - suf[i] <= k) return i;
        }
        return -1;
    }
}*/

