package Strings;
// TC -> O(N) -> for loop
// SC -> no extra space
class processStringwithSpecialCharii {
    public char processStr(String s, long k) {
        long l = 0;

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(l > 0) l--;
            }

            else if(ch == '%') continue;
            else if(ch == '#') l += l;
            else               l++;
        }

        if(k >= l) return '.';

        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);

            if(ch == '*') l++;
            else if(ch == '%') k = l - k - 1;
            else if(ch == '#'){
                l = l/2;
                if(k >= l) k -= l;
            }
            else           {
                l--;
                if(l == k) return s.charAt(i);
            }   
        }

        return '.';
    }
}

/*class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long l = 0;
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(ch == '#') l += l;
            else if(l > 0 && ch == '*') l -= 1;
            else if(ch == '%' || ch == '*') continue;
            else               l++; 
        }

        if(k >= l) return '.';

        for(int i = n-1; i >= 0; i--){
            char ch = s.charAt(i);

            if(ch == '#'){
                l = l/2;
                if(k >= l) k -= l;
            }
            else if(ch == '*') l++;
            else if(ch == '%') k = l - k - 1;
            else{
                l--;
                if(l == k) return s.charAt(i);
            }
        }

        return '.';
    }
}*/

/*class Solution {
    public char processStr(String s, long k) {

        StringBuilder st = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '*'){
                if(st.length() > 0) st.deleteCharAt(st.length() - 1);
            }

            else if(ch == '%') st.reverse();

            else if(ch == '#') st.append(st.toString());

            else  st.append(ch);
        }

        if(k >= st.length()) return '.';

        return st.charAt((int)k);
        
    }
}*/