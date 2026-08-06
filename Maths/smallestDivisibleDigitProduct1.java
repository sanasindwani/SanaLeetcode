// kyonki iss ques ke constraints chote hai thus we can say at mox + 9 ku gap pe hoga min number thus loop can be used to check consecutive 10 numbers and in the loop only we can calculate the digit multiplication which is at max 3 as n <= 100

class Solution {
    public int smallestNumber(int n, int t) {
        
        for(int i = 0; i <= 9; i++){
            int num = n + i;
            int prod = 1;

            while(num > 0){
                prod *= (num)%10;
                num = num/10;
            }

            // wrong -> its checking whether the quotient is 0, not whether prod is divisible by t
            //if((double)prod/t == 0) return (int) n + i;
            if(prod % t == 0) return n+i;
        }

        return -1;
    }
}