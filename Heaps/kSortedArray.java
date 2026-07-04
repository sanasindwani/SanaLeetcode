// BINARY SEARCH
// we can also use Binary search after we copy the array and then iterate
// and look for each element afterwards 
// binary search can find the sorted index of that element and when we iterate
// we know the actual index thus we can subtract and check for difference if
// its >k or not

// HASH-MAP
// Map every value to its sorted indices (stored as a queue).
// For each original element, fetch its corresponding sorted position and
// verify that the displacement from its original index is at most k.
// if dublicate elements make PriorityQueue<Integer, Queue<Integer>>

// TC -> O(n logx)
// this is a min heap solution
class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        int idx = 0;
        
        for(int i = 0; i < n; i++){
            pq.add(new int[]{arr[i], i});
            
            if(pq.size() > k+1){
                int[] curr = pq.poll();
                
                if(Math.abs(curr[1] - idx) > k){
                    return "No";
                }
                idx++;
            }
        }
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            if(Math.abs(curr[1] - idx) > k){
                return "No";
            }
            
            idx++;
        }
        
        return "Yes";
    }
}

// TC -> O(n log n)
// reverse of min heap here at first we pop out biggest element and compare its index
// max heap solution
/*
class Solution {
    static String isKSortedArray(int arr[], int n, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]); // larger value first
                }
                return Integer.compare(b[1], a[1]);     // larger index first
            }
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{arr[i], i});
        }

        int exp = n - 1;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (Math.abs(curr[1] - exp) > k) {
                return "No";
            }

            exp--;
        }

        return "Yes";
    }
}*/

// WRONG APPROACH
// The reason is that the heap algorithm can still fully sort some 
// arrays that are not k-sorted. It was designed to sort arrays that are 
// already guaranteed to be k-sorted, not to verify that property.

// eg -> 50, 24, 43 and k = 1 should give No but returns Yes
/*class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        List<Integer> ls = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        
        while(i < n){
            pq.add(arr[i]);
            
            if(pq.size() > k){
                ls.add(pq.poll());
            }
            
            i++;
        }
        
        while (!pq.isEmpty()) {
            ls.add(pq.poll());
        }
        
        for(int j = 1; j < n; j++){
            if(ls.get(j-1) > ls.get(j)) return "No";
        }
        
        return "Yes";
    }
}*/

/*class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        
        StringBuilder s = new StringBuilder();
        if(n == 1) return s.append(arr[0]).toString();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 0;
        
        while(i < n){
            pq.add(arr[i]);
            
            if(pq.size() > k){
                s.append(pq.poll());
            }
            
            i++;
        }
        return s.toString();
    }
}*/