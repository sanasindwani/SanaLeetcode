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