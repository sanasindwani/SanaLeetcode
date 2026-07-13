// no need for this only 36 such numbers exsist as 
//  when we select length such as 2 we only have 8 possible answers (12 23 34 45 56 67 78 89) with 3 we have only 7 (123 234 345 456 567 678 789)
// similaryly for 4 we have 6... for 5 we have 5.. and so on for 9 we have only 1 123456789
// so in total we have only 36 values

// Type - 2 (generate them yourself)
//TC -> O(1)
//SC -> O(1)
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ls = new ArrayList<>();

        for(int len = 2; len <= 9; len++){
            for(int start = 1; start <= 10 - len; start++){
                int num = start;
                int next = start+1;

                for(int k = 1; k < len; k++){
                    num = num*10 + next;
                    next++;
                }

                if(num >= low && num <= high){
                    ls.add(num);
                }
            }
        }
        return ls;
    }
}


// Type - 1 (hardcode it)
/*class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] arr = {12,23,34,45,56,67,78,89,123,234,345,456,567,678,789,1234,2345,3456,4567,5678,6789,12345,23456,34567,45678,56789,123456,234567,345678,456789, 1234567,2345678,3456789,12345678,23456789,123456789};

        List<Integer> ls = new ArrayList<>();

        for(int num : arr){
            if(num >= low && num <= high){
                ls.add(num);
            }
        }
        return ls;
    }
}*/

/*class Solution {
    int dig(int num){
        int val = 0;

        while(num > 0){
            num /= 10;
            val++;
        }
    }
    public List<Integer> sequentialDigits(int low, int high) {
        int nlow = dig(low);
        int nhigh = dig(high);

        List<Integer> ls = new ArrayList<>();
        if(low == high) return ls;

        
    }
}*/