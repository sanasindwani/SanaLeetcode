// TC -> O(n + k * log n)
// SC -> O(N)
/*class Solution {
    public int minStoneSum(int[] piles, int k) {
        int len = piles.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < len; i++){
            pq.add(piles[i]);
        }

        while(k > 0 && !pq.isEmpty()){
            int pile = pq.poll();

            int rem = (pile + 1)/2;
            pq.add(rem);
            k--;
        }
        int ans = 0;

        while(!pq.isEmpty()){
            ans += pq.peek();
            pq.poll();
        }

        return ans;
    }
}*/

class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;

        for(int i = 0; i < n; i++){
            pq.offer(piles[i]);
            sum += piles[i]; // yeah total sum calculate kar lenga before the change
        }

        for(int i = 0; i < k; i++){
            int cur = pq.poll();
            sum -= cur/2; //int division me apne aap floor ho jata hai
            pq.offer(cur - cur/2);
        }

        return sum;
    }
}