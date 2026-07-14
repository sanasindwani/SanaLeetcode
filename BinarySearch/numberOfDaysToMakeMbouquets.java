class Solution {
    boolean pos(int day, int[] bloomDay, int m, int k){
        int adj = 0;
        //int count = 0;
        int bouquets = 0;

// what was happening here is we stops after last index and doesn't check if including last index could make a bouquet or not 
// thus we have to check at the same time ki kya bouquet complete ho gaya hai
// tabhi after adding adj++ we check simuntaneously ki is the bouquet complete now
    for(int flower : bloomDay){

        if(flower <= day){
            adj++;

            if(adj == k){
                bouquets++;
                adj = 0;
            }

        }else{
            adj = 0;
        }
    }

    return bouquets >= m;
    }
        /*for(int i = 0; i < n; i++){

            //  if(adj == k){
            //     count += 1;
            //     adj = 0;
            // }

            if(bloomDay[i] <= day){
                adj++;

                if(adj == k){
                    count += 1;
                    adj = 0;
                }
            } else {
                adj = 0;
            }
        }

        if(count >= m) return true;
        return false;
    }*/
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m*k > n) return -1;

        int max = 0;
        //int min = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, bloomDay[i]);
            //min = Math.min(min, bloomDay[i]);
        }

        int l = 1, r = max;
        // or l = min

        while(l <= r){
            int mid = l + (r - l)/2;

            if(pos(mid, bloomDay, m, k)){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}