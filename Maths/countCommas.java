class Solution {
    public int countCommas(int n){
        if(n < 1000) return 0;
        return n - 1000 + 1;
    }
}


/*class Solution {
    public int countCommas(int n) {
        int digCount = 0;
        int num = n;
        while(num > 0){
            num /= 10;
            digCount++;
        }
        if(digCount <= 3) return 0;
        if(digCount == 4) return n - 1000 + 1;
        
        int ans = 0;
        // yahan pe 4 se shuru karna tha digit - 1 likh rakha tha
        // plus Math.pow(9) likh rakha tha instead of 10
        for(int i = 4; i < digCount; i++){
            ans += (i/3) *(9 * Math.pow(10, i - 1));
        }

// Mat.pow give double result isko (int) nahi kiya tha and digCount -1 bhi karna bhool gayi thi 
        return (n - (int)Math.pow(10, digCount - 1) + 1) + ans;
    }
}*/