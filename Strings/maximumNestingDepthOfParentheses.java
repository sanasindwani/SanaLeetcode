package Strings;

public class maximumNestingDepthOfParentheses {
    class Solution {
    public int maxDepth(String s) {
        int n = s.length();

        int max = 0;
        int count = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                count += 1;
                max = Math.max(count, max);
            }
            if(s.charAt(i) == ')') count--;
        }

        return max;
    }
}
}
