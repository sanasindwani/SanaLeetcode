// this question is of priority queue 
// this is a trick ques where we need a sorted list and if we try to sort it manually using sort function or anything else
// the time complexicity will become O(N log N)
// even if we try binary search and add our element in middle of the array o(N log N) then also because of insertion O(N) our time complexicity will become O(N log N)
// thus we use two priority queue whose time complexicty is O(log N) for insertion and to get median we only need peek which is O(1)
class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    // TC -> O(log N)
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // size of heaps should be either equal or max a difference of 1 is allowed 
        // difference will be maximum 1 after adding elements in both heaps
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    // TC -> O(1)
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        else {
            return ((double)minHeap.peek() + maxHeap.peek())/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

     public MedianFinder() {
        
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
        else if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            int sum = maxHeap.peek() + minHeap.peek();
            return ((double)sum/2);
        } 

        return maxHeap.peek();
    }
}

// Brute force approach 
// Will give TLE because of insertion sort again and again after every element and since 5*10^4 calls are being made we can even hai O(n log n)
// thus we'll use priority queue 

/*class MedianFinder {
    List<Integer> ls = new ArrayList<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        ls.add(num);
        Collections.sort(ls);
    }
    
    public double findMedian() {
        int n = ls.size();
        if(n % 2 == 1) return ls.get(n/2);
        else           return ((double)(ls.get(n/2) + ls.get(n/2 -1))/2);
    }
}*/

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */