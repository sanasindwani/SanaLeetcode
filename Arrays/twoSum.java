import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public int[] TwoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(mp.containsKey(target - nums[i])) return new int[] {i,mp.get(target - nums[i])};
            mp.put(nums[i],i);
        }
        return new int[]{};

       /*  Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){

            if(mp.containsKey(target - nums[i])){
                return new int[]{i, mp.get(target - nums[i])};
            }

            mp.put(nums[i], i);
        }

        return new int[]{};
        */
    }
}
