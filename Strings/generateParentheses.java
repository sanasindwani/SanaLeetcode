class Solution {
    List<String> total(int n, int open , int close, List<String> ls, StringBuilder st){
        if(open == n && close == n){
            ls.add(st.toString());
            return ls;
        }

        if(open < n){
            st.append('(');
            total(n, open+1, close, ls, st);
            st.deleteCharAt(st.length() - 1);
        }
        if(close < open){
            st.append(')');
            total(n, open, close+1, ls, st);
            st.deleteCharAt(st.length() - 1);
        }

        return ls;
    }
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        StringBuilder st = new StringBuilder();

        List<String> list = total(n, 0, 0, ls, st);
        return list;
    }
}

// another way of solving it -> a better way
/*
import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] s = new char[2 * n];
        solve(ans, s, 0, 0, 0, n);
        return ans;
    }

    private void solve(List<String> ans, char[] s, int pos,
                       int open, int close, int n) {

        if (pos == s.length) {
            ans.add(new String(s));
            return;
        }

        if (open < n) {
            s[pos] = '(';
            solve(ans, s, pos + 1, open + 1, close, n);
        }

        if (close < open) {
            s[pos] = ')';
            solve(ans, s, pos + 1, open, close + 1, n);
        }
    }
}*/