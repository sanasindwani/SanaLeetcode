public class findTheHighestAltitude {
    class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int alt = 0;

        for(int i = 0; i < gain.length; i++){
            sum += gain[i];
            alt = Math.max(alt, sum);
        }

        return alt;
        
    }
}
}
