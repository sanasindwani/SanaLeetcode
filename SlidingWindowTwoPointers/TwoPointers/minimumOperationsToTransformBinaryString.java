class Solution {
    public int minOperations(String s1, String s2) {
        int n = s1.length();
        int ans = 0;
        StringBuilder a = new StringBuilder(s1);

        if(n == 1 && s1.charAt(0) == '1' && s2.charAt(0) == '0') return -1;
// we first change our 0's in s1 to 1 in a as both the operations are independent thus changing one won't hinder other 
// thus after after operation of 0 -> 1 we can say ans += 1
        for(int idx = 0; idx < n; idx++){
            if(s1.charAt(idx) == '0' && s2.charAt(idx) == '1'){
                ans += 1;
                a.setCharAt(idx, '1');
            }
        }

        int i = 0;
// then we try and make a window of 0's such that all 0's in b1 can be grouped together as b = 1 wala change we have already encountered and change a when needed 
// now when b == 0 we can perform two operations when a is 1 and when a is 0
// this while loop will block b into groups of 0's
        while(i < n){
            int j = i;

            if(a.charAt(i) == s2.charAt(i)){
                i += 1;
                continue;
            }
// now after we are grouped into groups of 0's of b 
// we can check if the a's 1 are contigous or not
//based on that we can perform operation 2
            while(j < n && s2.charAt(j) == '0'){
                j += 1;
            }
// this while will calculate contigous group of A's 
// and we can know how many are there using another window of k to jj
            int k = i;
            while(k < j){

                if(a.charAt(k) == '0'){
                    k += 1;
                    continue;
                }

                int jj = k;
                while(jj < j && a.charAt(jj) == '1'){
                    jj += 1;
                }
// now if they are even we can say ans += totalcount/2
// as two 11's -> can be converted to 00
// if they are odd we can say ans +2 as now after converting into 00's from 11's we have to again conver (01/10) a 0 to 1 
                ans += (jj - k)/2;
                if(((jj - k) & 1) == 1){
                    ans += 2;
                }
// now we will assign k as jj and i as j (New window)
                k = jj;
            }
            i = j;
        }
        return ans;
    }
}