class Solution {
    public int[] frequencySort(int[] nums) {
        int[] ans = new int[nums.length];
        int idx = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // wrong syntax
        /*PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]
       
        if(a[0] == b[0]){
            b[1] - a[1]
        });*/
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
            return b[1] - a[1];
        }
            return a[0] - b[0];
        });
        
        for(int i = 0; i < nums.length; i++){
            /*if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i] + 1));
            } else {
                map.put(nums[i], 1);
            }*/
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            pq.add(new int[]{freq, num});
        }

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int freq = curr[0];
            int num = curr[1];

            while(freq-- > 0){
                ans[idx++] = num;
            }
        }
        return ans;
    }
}

// another valid approach 
// here we solve with the help of Arrays.sort and since arrays(int[]) can't take a comparator we used Integer[] 

/*
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return b - a;
            }
            return freq.get(a) - freq.get(b);
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}*/