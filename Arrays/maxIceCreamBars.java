// ques asks using count sort
// count sort is done using freq count
// then reconstruct the array generally has less time complexicity  
// can do using max also -> this is faster
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // such fixed space is always preffered for cp also
          //int[] freq = new int[100001];
          int max = 0;
          for(int c : costs){
              max = Math.max(max, c);
          }

          int[] freq = new int[max+1];

          for(int cost : costs){
            freq[cost]++;
          }

          int val = 0;

          //for(int i = 1; i <= 100000; i++){
          for(int i = 1; i <= max; i++){
            if(freq[i] == 0) continue;

            int amt = Math.min(freq[i], coins/i);

            val += amt;
            coins -= amt*i;

            if(coins < i) break;
          }

          return val;
    }
}



// solved using normal sort by sorting the array
// O(n log n)

/*class Solution {
    public int maxIceCream(int[] costs, int coins) {

        Arrays.sort(costs);
        int count = 0;

        for(int i = 0; i < costs.length; i++){
            if(coins >= costs[i]){
                coins -= costs[i];
                count++;
            }
            else   break;
        }

        return count;
        
    }
}*/