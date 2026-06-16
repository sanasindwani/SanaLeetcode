/* Use stringbuilder and its functions
- reverse()
- append()
- deleteCharAt()
- toString()
*/

class Solution {
    public String processStr(String s) {
        StringBuilder str = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '#'){
                str.append(str.toString());
            }else if(ch == '%'){
                str.reverse();
            }else if(ch == '*'){
                if(str.length() > 0){
                    str.deleteCharAt(str.length() - 1);
                }
            }else{
                str.append(ch);
            }
        }
        return str.toString();

    }
}
/*class Solution {
    public String processStr(String s) {

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '#'){
                res.append(res.toString());
            }
            else if(ch == '%'){
                res.reverse();
            }
            else if(ch == '*'){
                if(res.length() > 0){
                    res.deleteCharAt(res.length() - 1);
                }
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }
}*/

/*class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();

        for(int i = 0; i < n; i++){

            char ch = s.charAt(i);
        
            if(ch >= 'a' && ch <= 'z') res.append(ch);

            if(ch == '*' && res.length() > 0) res.deleteCharAt(res.length() - 1);
            if(ch == '#') res.append(res.toString());
            if(ch == '%') res.reverse();
        }

        String ans = res.toString();

        return ans;
        
    }
}*/