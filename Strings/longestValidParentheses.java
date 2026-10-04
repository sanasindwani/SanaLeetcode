// logic is correct but will give TLE for this type of ques as for every recursion we have 3 states
/*class Solution {
    boolean check(int n,String s, int open, int close){
        if(close > open) return false;
        if(n == s.length()){
            if(open == close) return true;
            else              return false;
        }

        if(s.charAt(n) == '('){
           return check(n+1, s, open + 1, close);
        }
        else if(s.charAt(n) == ')'){
           if(close + 1 > open) return false;
           return check(n + 1, s, open, close + 1);
        }
        else{
            boolean a = check(n + 1, s, open + 1, close);
            boolean b = check(n + 1, s, open, close + 1);
            boolean c = check(n + 1, s, open, close);

            return a || b || c;
        }
    }
    public boolean checkValidString(String s) {
        return check(0, s, 0, 0);
    }
}*/


class Solution {
    public boolean checkValidString(String s) {
        int len = s.length();
        int minOpen = 0;
        int maxOpen = 0;

 /*       for(int i = 0; i < len; i++){
            if(maxOpen < 0) return false;
            if(s.charAt(i) == '('){
                minOpen++;
                maxOpen++;
            }
            else if(s.charAt(i) == ')'){
                minOpen--;
                maxOpen--;
            }
            else{
                minOpen--; //(as it represents min open)
                maxOpen++;
                minOpen = Math.max(0, minOpen);
            }
        }
        if(minOpen == 0) return true;
        return false;
    }
}*/

// Keep the range of possible open-bracket counts instead of exploring every possible interpretation of *.
for (int i = 0; i < len; i++) {

    if (s.charAt(i) == '(') {
        minOpen++;
        maxOpen++;
    }
    else if (s.charAt(i) == ')') {
        minOpen--;
        maxOpen--;
    }
    else {
        minOpen--;
        maxOpen++;
    }

    minOpen = Math.max(0, minOpen);

    if (maxOpen < 0)
        return false;
}

return minOpen == 0;
    }
}
