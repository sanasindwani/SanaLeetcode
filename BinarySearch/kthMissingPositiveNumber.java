// this is not very intutive
// here we try to use binary search in order two index in which missing number range lies 
// and use binary search on missing numbers 
// as 1 2 3 4 5.. will be the series when no number is missing 
// thus now abb yeah BS ho gaya hai thus O(log n)

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        int l = 0, r = n - 1;

        while(l <= r){
            int mid = (l + r)/2;

            int missing = arr[mid] - (mid + 1);

            if(missing < k) l = mid + 1;
            else            r = mid - 1;
        }

        // this formula came from the derivation as we want to return      arr[high] + more  and more -> k - missing 
        // missing = arr[idx] - (idx + 1) 
        // thus arr[high] + k - (arr[high] - (high + 1))
        // which will become high + 1 + k
        // and low is high - 1 thus low + k 
        //return (r + k + 1);
        return (l + k);
    }
}

// Tc -> O(N)
// Sc -> O(1)
/*class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        for(int i = 0; i < n; i++){
            if(arr[i] <= k) k++;
            else            break;
        }

        return k;
    }
}*/


// basic iterative approach 
//TC -> O(N)

/*class Solution {
    public int findKthPositive(int[] arr, int k) {

        int num = 1;
        int i = 0;
        int n = arr.length;

        while (i < n) {
            if (arr[i] == num) {
                i++;
            } else {
                k--;
                if (k == 0) {
                    return num;
                }
            }
            num++;
        }

        while (k > 0) {
            k--;
            if (k == 0) {
                return num;
            }
            num++;
        }

        return -1;
    }
}*/