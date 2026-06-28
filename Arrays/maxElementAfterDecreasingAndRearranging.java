class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if(arr.length == 1) return 1;
        Arrays.sort(arr);
        arr[0] = 1;
        // boolean npos = false;
        for(int i = 1; i < arr.length; i++){
            //WRONG APPROACH 
           // if(Math.abs(arr[i] - arr[i-1]) <= 1) continue;
            //else npos = true;
            arr[i] = Math.min(arr[i], arr[i-1]+1);
            // here either the array will be formed in increasing order
            // or we can say same element is present
            // eg if i have 1 100 100 -> it will become 1 2 3
            // if i have 1 2 2 -> it will become 1 2 2 only
            // of i have 1 1 100 -> my code will make it 1 2 3 but I can't increase, i can only perform decrease operation thus
            // 1 1 100 -> should become 1 1 2
            // thus we say min of the value its holding or the value it has of prev + 1
        }
        //if(npos) return arr.length;
        return arr[arr.length-1];
    }
}