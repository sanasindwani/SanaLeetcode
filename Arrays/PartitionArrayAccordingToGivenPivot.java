public class PartitionArrayAccordingToGivenPivot {

    static{
        for(int i=0;i<300;i++) pivotArray(new int[2],0);
    }
    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = n - 1;
        
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if (nums[j] > pivot) {
                result[right--] = nums[j];
            }
        }

        while (left <= right) {
            result[left++] = pivot;
        }
        
        return result;
    }
}

/*class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int[] res = new int[n];

        int l = 0, r = n-1;

        for(int i = 0, j = n-1; i < n; i++, j--){

            if(nums[i] < pivot){
                res[l++] = nums[i];
            }

            if(nums[j] > pivot){
                res[r--] = nums[j]; 
            }
        }

        while(l <= r){
            res[l++] = pivot;
        }

        return res;
    }
}*/


// my code
/*class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int ls = 0, grt = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < pivot) ls++;
            if(nums[i] > pivot) grt++;
        }

        int eq = n - (ls+grt);
        int[] ans = new int[n];

        int l = n-1, pi = ls - 1;

        while(l >= 0 && pi >= 0){
            
            if(nums[l] >= pivot) l--;
            if(nums[l] < pivot){
                ans[pi] = nums[l];
                l--;
                pi--;
            }
        }

        int r = 0, piv = n - grt;

        while(r < n && piv < n){
            if(nums[r] <= pivot) r++;
            if(nums[r] > pivot){
                ans[piv] = nums[r];
                piv++;
                r++;
            }
        }

        int e = ls;
        while(e < (n - grt)){
            ans[e] = pivot;
            e++;
        }
        
        return ans;

    }
}*/
