package TwoPointers;
import java.util.Arrays;

public class assignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0, c = 0;

        while(i < g.length && j < s.length){
            if(g[i] <= s[j]){
                c++;
                i++;
            }
            j++;
        }
        return c;
    }
}

/*class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length;
        if(n == 0 || m == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int gp = n-1, sp = m-1;
        int count = 0;

        while(gp >= 0 &&  sp >= 0){
            if(g[gp] > s[sp]) gp--;
            else{
                count++;
                gp--;
                sp--;
            }
        }
        return count;
    }
}*/
