// bucket sort use kiya hai
// it is using an array whose indexes represent frequency  
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < n; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

 // bucket.get(i) = elements haveing i frequency
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for(int i = 0; i <= n; i++) bucket.add(new ArrayList<>());

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int val = entry.getValue();
            int key = entry.getKey();

            bucket.get(val).add(key);
        }
        // abb result banana hai
        // pick elements from right to left from bucket 

        // top k
        int[] ans = new int[k];
        int idx = 0;

        for(int i = n; i >= 0; i--){
            if(bucket.get(i).size() == 0) continue;

            int ptr = 0;
            while(ptr < bucket.get(i).size() && k > 0){
                ans[idx++] = bucket.get(i).get(ptr);
                ptr++;
                k--;
            }
        }

        return ans;
    }
}


// TC -> O(n log k)
// SC -> O(n + k)
// min heap
/*class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            pq.add(new int[]{val, key});

            if(pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        int idx = 0;

        while(!pq.isEmpty()){
            int[] val = pq.poll();
            int key = val[1];
            ans[idx++] = key;
            k--;
        }
        return ans;
    }
}*/

// max heap
/*class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            pq.add(new int[]{val, key});
        }

        int[] ans = new int[k];
        int idx = 0;

        while(k > 0){
            int[] val = pq.poll();
            int key = val[1];
            ans[idx++] = key;
            k--;
        }
        return ans;
    }
}*/