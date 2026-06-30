// using one while loop reverse of the variable sliding window method i used
// here we calculate by fixing right and using left values + 1 (the substring itself)
// Tc -> O(N)
// SC -> O(1)
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int r = 0;

        int[] last = {-1,-1,-1};

        while(n > r){
            last[s.charAt(r) - 'a'] = r;

            ans += Math.min(last[0],Math.min(last[1], last[2])) + 1;

            r++;
        }
        return ans;
    }
}

// here we fix left and calculate using length() - right index thus because of length() one element(self string) is already added thus we don't do +1
// we assume if substring is valid then its length() - right indexes will also be valid
// opp to above approach
// TC -> O(N)
// SC -> O(1)
/*class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int count = 0;
        // we can either create freq map or array
        // array is preffered in cp also fixed space
        int[] freq = new int[3];

        while(n > r){
            freq[s.charAt(r) - 'a']++;

            while(freq[0] != 0 && freq[1] != 0 && freq[2] != 0){
                count += n - r;
                freq[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return count;
    }
}*/