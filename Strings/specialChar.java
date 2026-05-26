// Array is faster
// might take more space but is better approach -> optimised 
// as 126 is predefined small memory thus preffered 
class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] vis = new boolean['z' + 1];
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            vis[word.charAt(i)] = true;
        }
        for(int i = 0; i < 26; i++){
            if(vis['a' + i] == true && vis['A' + i] == true){
                count++;
            }
        }
        return count;
    }
}
/*
class Solution {

    public int numberOfSpecialChars(String word) {

        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        // Traverse string
        for (char ch : word.toCharArray()) {

            // lowercase
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a'] = true;
            }

            // uppercase
            else {
                upper[ch - 'A'] = true;
            }
        }

        int count = 0;

        // Check both exist
        for (int i = 0; i < 26; i++) {

            if (lower[i] && upper[i]) {
                count++;
            }
        }

        return count;
    }
}*/
// Brute (hashmap) therefor slow
/*class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int count = 0; 
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch) && mp.getOrDefault(ch,0) == 0){
                char c = Character.toUpperCase(ch);
                if(mp.getOrDefault(c,0) == 1) count++;
            }
            else{
                char c = Character.toLowerCase(ch);
                if(mp.getOrDefault(c, 0) == 1 && mp.getOrDefault(ch, 0) == 0){
                    count++;
                }
            }
            mp.put(ch, 1);
        }
        return count;
    }
}*/