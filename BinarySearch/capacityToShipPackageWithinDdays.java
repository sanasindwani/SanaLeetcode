// TC - > O(n log(sum - max))
// SC -> O(1)
class Solution {
    boolean pos(int cap, int[] weights, int days){
        int adj = 0;
        // two options either start from count = 1 or check adj after iteration
        // let's say we have 4 5 6 3 and our capacity is 9 at first we start from 4 then take 5 now capacity is 9 we complete day 1 then next day we iterate to 6 then add 3 as(adj + wt <= cap) but now iteration ended we never added the last package formed 
        int count = 1;

        for(int wt : weights){
            if(adj + wt <= cap){
                adj += wt;
            } else {
                count++;
                adj = wt;
            }
        }
        if(count <= days) return true;
        return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int max = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }

        int l = max, r = sum;

        while(l <= r){
            int mid = (l + r)/2;

            if(pos(mid, weights, days)){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}