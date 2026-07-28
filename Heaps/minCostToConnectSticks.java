class Solution {
    public static int minCost(int[] arr) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < n; i++){
            pq.add(arr[i]);
        }
        int sum = 0;
        while(pq.size() != 1){
            int r1 = pq.poll();
            int r2 = pq.poll();
            
            sum += r1 + r2;
            pq.offer(r1 + r2);
        }
        
        return sum;
    }
}