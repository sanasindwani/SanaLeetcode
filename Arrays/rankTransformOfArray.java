// for -> ranking, Replace values by ranks, Compress values, Normalize values, Relative ordering matters
// co-ordinate compression
// uses SORTING + HASHMAP

/*class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] res = arr.clone();
        Arrays.sort(res);

        int val = 1;

        for(int i = 0; i < n; i++){
            if(map.containsKey(res[i])){
                continue;
            } else {
                map.put(res[i], val);
                val++;
            }
        }

        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}*/

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n= arr.length;
        int sort[] = new int[n];

        for(int i=0 ; i<n ; i++){
            sort[i] = arr[i];
        }
        Arrays.sort(sort);
        HashMap<Integer , Integer> map = new HashMap<>();
        int i=1;
        for(int ele : sort){
            if(!map.containsKey(ele)){
                map.put(ele , i++);
            }
        }
        for(int k=0 ; k<n ; k++){
            arr[k] = map.get(arr[k]);
        }
        return arr;
    }
}