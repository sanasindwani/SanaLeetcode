// brute force mein har baar sort karna padega and uske baad ans nikalna padega
// will consume O(n log n) sorting requires a lot of time
// another approach is ki ham binary search se number ki position dekh le which will need O(log n) time but fir hame insert karne mein lag jayega O(n log n)
// thus ese case mein when we want a number at a particularly sorted position without using TC of O(n log n) we'll use prioirty queue 

class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);

            if(pq.size() > k){
                pq.poll();
            }
        }
    }
    public int add(int val) {
        pq.add(val);

        if(pq.size() > k) pq.poll();

        return pq.peek();
    }
}



/*class KthLargest {
    int k;
    int[] nums;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;

        for(int i = 0; i < nums.length; i++){
            if(pq.isEmpty() || pq.size() < k || nums[i] > pq.peek()){
                pq.add(nums[i]);
            }

            if(pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        if(pq.size() < k){
            pq.add(val);
            return pq.peek();
        }
        if(!pq.isEmpty() && val <= pq.peek()){
            return pq.peek();
        } else {
            pq.add(val);
            if(pq.size() > k) pq.poll();

            return pq.peek();
        }
    }
}*/

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */