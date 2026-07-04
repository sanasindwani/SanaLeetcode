class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;
        List<Integer> ls = new ArrayList<>();

        while(low < high){
            int mid = (low + high)/2;
// yahan pe math.abs nahi lagana
//The comparison is not comparing distances
            if(x - arr[mid] > arr[mid + k] - x){
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        for(int i = low; i < low + k; i++){
            ls.add(arr[i]);
        }

        return ls;
    }
}