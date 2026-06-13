package Strings;

public class weightedWordMapping {
    // String builder code
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        for(String s : words){
            int sum = 0;
            for(int i=0; i<s.length(); i++){
                sum += weights[s.charAt(i) - 'a'];
            }
            int c = 25 - (sum % 26);
            ans.append((char) ('a' + c));
        }
        return ans.toString();
    }
}

// My code
/*class Solution {
    int wt(String w, int[] wt){
        int sum = 0;
        for(int i = 0; i < w.length(); i++){
            sum += wt[w.charAt(i) - 'a'];
        }

        return sum;
    }
    public String mapWordWeights(String[] words, int[] weights) {
        String s = "";
        
        int m = words.length;
        for(int i = 0; i < m; i++){
            int j = wt(words[i], weights);

            j = j % 26;
            char ch = (char)((25 - j) + 'a');

            s += ch;
        }

        return s;
        
    }
}*/
}
