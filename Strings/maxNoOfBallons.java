package Strings;

public class maxNoOfBallons {
    // hard code balloon 
class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;

        // we can use switch case here
        for(char c : text.toCharArray()){
            if(c == 'b') b++;
            if(c == 'a') a++;
            if(c == 'l') l++;
            if(c == 'o') o++;
            if(c == 'n') n++;
        }
        return Math.min(b,(Math.min(a, Math.min(l/2, Math.min(o/2, n)))));
    }
}

// too slow
// my code 
/*class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
       for(char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        if(freq['b' - 'a'] == 0 || freq['a' - 'a'] == 0 || freq['l' - 'a'] == 0 || freq['o' - 'a'] == 0 || freq['n' - 'a'] == 0) return 0;

        int count = Integer.MAX_VALUE;

        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if(ch == 'b' || ch == 'a' || ch == 'n'){
            count = Math.min(count, freq[ch - 'a']);
            }

            if(ch == 'l' || ch == 'o'){
                int val = freq[ch - 'a']/2;
                count = Math.min(count, val);
            }
        }
        return count;
    }
}*/
}
