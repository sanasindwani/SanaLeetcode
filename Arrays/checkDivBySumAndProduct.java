class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;

        int num = n;
        while(num > 0){
            int dig = num%10;
            sum += dig;
            prod *= dig;
            num /= 10;
        }

        int res = sum + prod;

        if(n % res == 0) return true;
        return false;
    }
}