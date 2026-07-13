// Way 2
// whenever we see a pattern where we see a monotonic quantity 
// we have to return a num and we can check if the particular ans is valid 
// and the range is given and the search is monotonic 
// we apply binary search instead of linear search using for loop
// TC -> O(N) * log(max)
class Solution {
     long reqTime(int[] arr, int speed) {
    long time = 0;

    for (int pile : arr) {
        time += (pile + speed - 1L) / speed;
    }

    return time;
}
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, piles[i]);
        }

        int l = 1, r = max;

        while(l <= r){
            int mid = (l + r)/2;

            if(reqTime(piles, mid) <= h){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}


// Way 1 using linear search
// cieling formula -> time += (arr[i] + n - 1) / n;
// gives TLE as TC -> O(max * O(n))
/*class Solution {
    long reqTime(int[] arr, int speed) {
    long time = 0;

    for (int pile : arr) {
        time += (pile + speed - 1L) / speed;
    }

    return time;
}
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, piles[i]);
        }

        for(int i = 1; i <= max; i++){
            long ans = reqTime(piles, i);

            if(ans <= h) return i;
        }

        return 0;
    }
}*/