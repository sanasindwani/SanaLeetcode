// this looks like a recursion take/not take subset/subsequence problem 
// but its essentially a greedy/observation problem not a recursion or dp problem
// toh isko solve karne ke liyae we know two things
// ya toh poori array ka xor -> non zero hoga then ans will be n 
// ya 0 hoga then ans will be either remove a non zero number as 
// xor of A^A = 0 
// and if there is only 0's you can't remove anything as 0^A = 0 thus 0^0 = 0
// abb ans will become 0 only  
// thus even if the array is A^A^A^A then xor will be 0 as A is even thus we remove one A xor will be A
// thus ham bol sakte hai ya toh ans n hai ya toh n - 1 and for the edge case if all elements are 0 then ans 0 hai

class Solution {
    public int longestSubsequence(int[] nums) {
        /*int n = nums.length;
        int val = 0;


        for(int i = 0; i < n; i++){
            val ^= nums[i];
        }

        if(val != 0) return n;
        if(val == 0){
            int cal = 0;
            for(int i = 0; i < n; i++){
                if(nums[i] == 0) cal++;
            }

            if(cal == n) return 0;
            else         return n - 1;
        }

        return -1;*/

        // even better 

        int n = nums.length;
        int val = 0;

        for(int i = 0; i < n; i++){
            val ^= nums[i];
        }

        if(val != 0) return n;

        for(int i = 0; i < n; i++){
            if(nums[i] != 0)
            return n - 1;
        }
        return 0;
    }
}

shj