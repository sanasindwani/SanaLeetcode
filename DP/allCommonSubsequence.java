package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class allCommonSubsequence {
    /*import java.util.*;

class Solution {

    HashSet<String> getAllLCS(String s1, String s2, int i, int j,
                              int[][] dp,
                              HashMap<String, HashSet<String>> memo) {

        String key = i + "," + j;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        HashSet<String> result = new HashSet<>();

        if (i == 0 || j == 0) {
            result.add("");
            return result;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

            HashSet<String> prev =
                getAllLCS(s1, s2, i - 1, j - 1, dp, memo);

            for (String str : prev) {
                result.add(str + s1.charAt(i - 1));
            }
        } else {

            if (dp[i - 1][j] == dp[i][j]) {
                result.addAll(
                    getAllLCS(s1, s2, i - 1, j, dp, memo)
                );
            }

            if (dp[i][j - 1] == dp[i][j]) {
                result.addAll(
                    getAllLCS(s1, s2, i, j - 1, dp, memo)
                );
            }
        }

        memo.put(key, result);
        return result;
    }

    public ArrayList<String> allLCS(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        HashMap<String, HashSet<String>> memo = new HashMap<>();

        ArrayList<String> ans = new ArrayList<>(
            getAllLCS(s1, s2, n, m, dp, memo)
        );

        Collections.sort(ans);
        return ans;
    }
}*/

class Solution {
    void cal(int n, int m, String s1, String s2, HashSet<String>[][] dp){
        
        if(dp[n][m] != null) return;
        
       if (n == 0 || m == 0) {
            dp[n][m] = new HashSet<>();
            dp[n][m].add("");
            return;
        }
        
        
        cal(n - 1, m, s1, s2, dp);
        cal(n, m - 1, s1, s2, dp);
        cal(n - 1, m - 1, s1, s2, dp);
        
        dp[n][m] = new HashSet<>();
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
        for(String s : dp[n-1][m-1]){
            dp[n][m].add(s + s1.charAt(n - 1));
        }
         return;
        }
        
        int Top = dp[n-1][m].iterator().next().length();
        int Left = dp[n][m-1].iterator().next().length();
        
        if(Top > Left){
            for(String s : dp[n-1][m]) dp[n][m].add(s);
        }
        else if(Top < Left){
            for(String s : dp[n][m-1]) dp[n][m].add(s);
        }
        else{
            for(String s : dp[n-1][m]) dp[n][m].add(s);
            for(String s : dp[n][m-1]) dp[n][m].add(s);
        }
        
        return;
    }
public ArrayList<String> allLCS(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    
    HashSet<String> [][] dp = new HashSet[n+1][m+1];
    
    /*for(int i = 0; i <= n; i++) {
        dp[i][0] = new HashSet<>();
        dp[i][0].add("");
    }

    for(int j = 0; j <= m; j++) {
        dp[0][j] = new HashSet<>();
        dp[0][j].add("");
    }*/
    
    cal(n, m, s1, s2, dp);
    ArrayList<String> list = new ArrayList<>(dp[n][m]);
    
    Collections.sort(list);
    
    return list;
    
    }
}

/*class Solution {
    public ArrayList<String> allLCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        HashSet<String>[][] dp = new HashSet[n+1][m+1];
        
        for(int i = 0; i <= n; i++){
            dp[i][0] = new HashSet<>();
            dp[i][0].add("");
        }
        
         for(int j = 0; j <= m; j++){
            dp[0][j] = new HashSet<>();
            dp[0][j].add("");
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                
                dp[i][j] = new HashSet<>();
                
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    for(String s : dp[i-1][j-1]) dp[i][j].add(s + s1.charAt(i-1));
                }
                
                else{
                    int v1 = dp[i-1][j].iterator().next().length();
                    int v2 = dp[i][j-1].iterator().next().length();
                    
                    if(v1 > v2){
                        for(String s : dp[i-1][j]) dp[i][j].add(s);
                    }
                    else if(v1 < v2){
                        for(String s : dp[i][j - 1]) dp[i][j].add(s);
                    } else {
                        for(String s : dp[i-1][j]) dp[i][j].add(s);
                        for(String s : dp[i][j - 1]) dp[i][j].add(s);
                    }
                }
            }
        }
        
        ArrayList ans = new ArrayList<>(dp[n][m]);
        Collections.sort(ans);
        
        return ans;
    }
}*/

/*class Solution {
    public ArrayList<String> allLCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        HashSet<String>[] prev = new HashSet[m+1];
        
         for(int j = 0; j <= m; j++){
            prev[j] = new HashSet<>();
            prev[j].add("");
        }
        
        for(int i = 1; i <= n; i++){
            HashSet<String>[] curr = new HashSet[m+1];
            curr[0] = new HashSet<>();
            curr[0].add("");
            for(int j = 1; j <= m; j++){
                
                curr[j] = new HashSet<>();
                
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    for(String s : prev[j-1]) curr[j].add(s + s1.charAt(i-1));
                }
                
                else{
                    int v1 = prev[j].iterator().next().length();
                    int v2 = curr[j-1].iterator().next().length();
                    
                    if(v1 > v2){
                        for(String s : prev[j]) curr[j].add(s);
                    }
                    else if(v1 < v2){
                        for(String s : curr[j - 1]) curr[j].add(s);
                    } else {
                        for(String s : prev[j]) curr[j].add(s);
                        for(String s : curr[j - 1]) curr[j].add(s);
                    }
                }
            }
            prev = curr;
        }
        
        ArrayList ans = new ArrayList<>(prev[m]);
        Collections.sort(ans);
        
        return ans;
    }
}*/

/*class Solution {
    int LCS(int n, int m, String s1, String s2, int[][] dp){
        if(n == 0 || m == 0) return 0;
        
        if(dp[n][m] != -1) return dp[n][m];
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
            return dp[n][m] = 1 + LCS(n-1, m-1, s1, s2, dp);
        }
        
        return dp[n][m] = Math.max(LCS(n-1, m, s1, s2, dp), LCS(n, m-1, s1, s2, dp));
    }
    public ArrayList<String> allLCS(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);
        
        int len = LCS(n, m, s1, s2, dp);
        
        HashSet<String> ans = new HashSet<>();
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(n,m,""));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int ni = p.i;
            int nj = p.j;
            String ns = p.str;
            
            
            if(ns.length() == len){
                ans.add(new StringBuilder(ns).reverse().toString());
                continue;
            }
            
            if (ni == 0 || nj == 0) {
                continue;
            }
    
            else if(s1.charAt(ni - 1) == s2.charAt(nj - 1)){
                q.add(new Pair(ni - 1, nj - 1, ns + s1.charAt(ni - 1)));
            }
            else if(dp[ni-1][nj] > dp[ni][nj-1]){
                q.add(new Pair(ni-1, nj, ns));
            }
            else if(dp[ni-1][nj] < dp[ni][nj-1]){
                q.add(new Pair(ni, nj-1, ns));
            }
            else{
                q.add(new Pair(ni-1, nj, ns));
                q.add(new Pair(ni, nj-1, ns));
            }
        }
        
        ArrayList<String> res = new ArrayList<>(ans);
        Collections.sort(res);
        
        return res;
        
    }
    
}
class Pair{
    int i;
    int j;
    String str;
    
    Pair(int i, int j, String str){
        this.i = i;
        this.j = j;
        this.str = str;
    }
}*/

/*public List<String> allLCS(String s1, String s2) {
        HashSet<String> ans =new HashSet<String>();
        int n=s1.length();
        int m=s2.length();
        int [][]dp =new int[n+1][m+1];
        for(int []x1:dp)
        {
          Arrays.fill(x1,-1);
        }
        dp[n][m]=LCS(s1,s2,n,m,dp);
        int max=dp[n][m];
        Queue<Pair> q1 =new LinkedList<Pair>();
        q1.add(new Pair(n,m,""));
        while(q1.isEmpty()==false)
        {
          Pair p1=q1.poll();
          int i=p1.i;
          int j=p1.j;
          String seq=p1.seq;
          if(seq.length()==max)
          {
             ans.add(new String(new StringBuilder(seq).reverse().toString()));
             continue;
          }
          if(s1.charAt(i-1)==s2.charAt(j-1))
          {
              q1.add(new Pair(i-1,j-1,seq+s1.charAt(i-1)));
          }
          else if(dp[i][j-1]>dp[i-1][j])
          {
              q1.add(new Pair(i,j-1,seq));
          }
          else if(dp[i][j-1]<dp[i-1][j])
          {
              q1.add(new Pair(i-1,j,seq));
          }
          else
          {
              q1.add(new Pair(i,j-1,seq));
              q1.add(new Pair(i-1,j,seq));
          }
        }
        
        
        List<String> t1 =new ArrayList<String>(ans);
        Collections.sort(t1);
        return t1;
        
        
    }
   
    public int LCS(String x,String y,int n,int m,int [][]dp)
    {
        if(n==0||m==0)
        {
          return 0;
        }
        if(dp[n][m]!=-1)
        {
            return dp[n][m];
        }
        if(x.charAt(n-1)==y.charAt(m-1))
        {
          dp[n][m]=1+LCS(x,y,n-1,m-1,dp);
          return dp[n][m];
        }
        dp[n][m]=Math.max(LCS(x,y,n-1,m,dp),LCS(x,y,n,m-1,dp));
        return dp[n][m];
        
    }
    
}

class Pair
{
    int i;
    int j;
    String seq;
    public Pair(int i,int j,String seq)
    {
        this.i=i;
        this.j=j;
        this.seq=seq;
    }
}*/
}
