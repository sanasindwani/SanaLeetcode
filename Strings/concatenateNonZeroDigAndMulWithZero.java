class Solution {
    public long sumAndMultiply(int n) {
        if(n == 0) return 0;
        long sum = 0;
        StringBuilder s = new StringBuilder();

        while(n > 0){
            int nn = n%10;
            if(nn != 0){
                s.append(nn);
                sum += nn;
            }
            n /= 10;
        }      
        s.reverse();
        long num = Long.parseLong(s.toString());

        return num*sum;
    }
}