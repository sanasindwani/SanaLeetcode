class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ls = new ArrayList<>();
   PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
    if (a[1] == b[1]) {
        return b[0] - a[0];
    }

    return b[1] - a[1];
});

        for(int i = 0; i < arr.length; i++){
            pq.add(new int[]{arr[i], Math.abs(x - arr[i])});

            if(pq.size() > k){
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            ls.add(curr[0]);
        }

        Collections.sort(ls);

        return ls;
    }
}