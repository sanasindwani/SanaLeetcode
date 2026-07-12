// was giving TLE because I was iterating over array instead of set 
// thus {1,2,3,4,1,1,1} array has multiple starting points has 4
// whilst set {1,2,3,4} only 1
/*class Solution {
    int count(int i, HashSet<Integer> hs){
        int c = 1;
        while(true){
            if(hs.contains(i + 1)){
                i++;
                c++;
            } else {
                break;
            }
        }
        return c;
    }
    public int longestConsecutive(int[] nums) {
        int max = 0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for(int num : set){
            if(set.contains(num - 1)) continue;
            else                      max = Math.max(max, count(num, set));
        }
        return max;
    }
}*/

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : set) {

            // Only start from the beginning of a sequence
            if (set.contains(num - 1))
                continue;

            int curr = num;
            int len = 1;

            while (set.contains(curr + 1)) {
                curr++;
                len++;
            }

            max = Math.max(max, len);
        }

        return max;
    }
}