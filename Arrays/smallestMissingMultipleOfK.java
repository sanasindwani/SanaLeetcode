/*class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }

        for(int i = 1; i <= n; i++){
            int val = k*i;

            if(set.contains(val)) continue;
            else return val;
        }

        return k*(n+1);
    }
}*/

/*class Solution {
    public int missingMultiple(int[] nums, int k) {
        for(int multiple=k;;multiple+=k){
            boolean found=false;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==multiple){
                    found=true;
                    break;
                }
            }
            if(!found){
            return multiple;
            }
        }
        
    }
}*/

class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            if(nums[i]%k==0){
                set.add(nums[i]);
            }
        }
        for(int j=1;j<=set.size()+1;j++){
            if(!set.contains(k*j)){
                return k*j;
            }
        }
        return 0;
    }
}