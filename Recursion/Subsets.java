package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    void totalSubsets(List<List<Integer>> lst, List<Integer> ls, int n, int[] nums, int k){
        if(n >= k){
        lst.add(new ArrayList<>(ls));
        return;
        } 
        ls.add(nums[n]);
        totalSubsets(lst, ls, n+1, nums, k);
        ls.remove(ls.size() - 1);
        totalSubsets(lst, ls, n+1, nums, k);
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        int k = nums.length;
        totalSubsets(lst, ls, 0, nums, k);
        return lst;
    }
}
