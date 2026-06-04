package DP;


import java.util.*;

public class partitionArraysIntoTwoArraysForMinSum {
    //MEET IN THE MIDDLE ALGORITHM
// can't use dp as -> sum can be negative and we can't access negative numbers in array as index 
// so in order to manage time as well as space complexicity instead of checking / storing 2^N indexes we can use 2*n (divide the array into half)
// meet in the middle algorithm -> bitmasking, binary search, even dp

    public int minimumDifference(int[] nums) {
        // find sum of the whole array will be required to fins part2 sum
        int N = nums.length, res = (int)1e8, sum = 0;
        for(int i = 0; i < N; i++) sum += nums[i];
        // at first create left and right partitions which will store array's subsets sum of left and right respectively 
        int n = N/2;
        ArrayList<Integer>[] left = new ArrayList[n+1];
        ArrayList<Integer>[] right = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
        left[i] = new ArrayList<>();
        right[i] = new ArrayList<>();
        }
        // now mask the array using bitmasking -> calculate subsets
        for(int mask = 0; mask < (1<<n); mask++){
            int sz = 0, l = 0, r = 0;
            for(int i = 0; i < n; i++){
                if((mask&(1<<i)) != 0){
                    sz++;
           
                    l += nums[i];
                    r += nums[i+n];
                }
            }
            left[sz].add(l);
            right[sz].add(r);
        }
        // edge case calculated where all elements might be from left or right
        res = Math.min(Math.abs(sum - 2*left[n].get(0)), Math.abs(sum - 2*right[n].get(0)));
        
        // this will sort the right array/partition
        for(int sz = 0; sz <= n; sz++){
            Collections.sort(right[sz]);
        }

        //now took an a(sum of left elements) and find b using binary search and calculate res(min)
        // iterate over left part
        for(int sz = 1; sz <= n; sz++){
            for(int a : left[sz]){
                //int b = (int)Math.ceil((sum - 2.0*a)/2.0), rsz = n - sz;
                int b = (sum - 2*a)/2, rsz = n-sz; // to iterate over right and use binary search

                ArrayList<Integer> v = right[rsz];
                int l = 0, r = v.size();
                // lower bound
                while( l < r){
                    int mid = l + (r - l)/2;
                    if(v.get(mid) < b){
                        l = mid+1;
                    }
                    else{
                        r = mid;
                    }
                } 

                // check for the found value of b when l is found and not gone more than the length of array for eg -> 1,2,23,34 and we want 45 lowe bound will give l == size of array
                if(l < v.size()) res = Math.min(res, Math.abs(sum - 2 * (a+v.get(l))));
                
                // if l > 0 we can check previous value also as lower bound give greater or equal value 
                // if equal not give it gives greater but maybe lower value is more compatible eg 2 5 9 12 and we want 6.. lower bound will give 9 but better is 5
                if(l > 0) res = Math.min(res, Math.abs(sum - 2*(a + v.get(l-1))));
            }
        }
        // return minimum
        return res;
    }
}

// TC -> O(2^N)
// recursion and tried DP
/*class Solution {
    int f(int n,int take , int sum1, int totSum, int[] nums){ 
        if(take > n + 1) return (int)1e8;
        if(take == 0) return Math.abs(totSum - 2*sum1);

        if(n == 0) {
            if(take == 1) return Math.abs(totSum - 2*(sum1 + nums[0]));
            else          return (int)1e8;
        }

        //if(dp[n][take][sum1] != -1) return dp[n][take][sum1];

            int groupA = f(n-1, take-1, sum1+ nums[n],totSum, nums);
            int groupB = f(n-1, take, sum1, totSum, nums);

            return  Math.min(groupA, groupB);
    }
    
    public int minimumDifference(int[] nums) {
        int x = nums.length;
        int sum = 0;
        for(int i = 0; i < x; i++) sum += nums[i];
        int[][][] dp = new int[x][(x/2) + 1][sum];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < x/2; j++) Arrays.fill(dp[i][j], -1);
        }
        return f(x - 1 , x/2 , 0, sum, nums);
    }
}*/
