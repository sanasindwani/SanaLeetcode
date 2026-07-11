class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int r = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        // dq.add(0); loop won't run for 0 and res will remain empty 

       //while(i <= n - k){ -> not good approach as monotonic dequeue don't approach window as a whole but every element 1 by 1 
       // and it will stop at window's first element 

       for(int i = 0; i < n; i++){

// check if the front element is still a part of window else remove it 
            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.removeFirst();
            }

// then deque from the back if number is larger than the back
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.removeLast();
            }

            dq.addLast(i);

            if(i >= k - 1){
                res[r] = nums[dq.peekFirst()];
                r++;
            }

       }
       return res;
    }
}