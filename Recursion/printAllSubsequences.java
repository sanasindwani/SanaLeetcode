package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class printAllSubsequences{
    void subsequence(String s,String sc, int n,int len, List<String> lst){
        if(n >= len){
          lst.add(sc);
          return;
        }
        subsequence(s, sc + s.charAt(n), n+1, len, lst);
        subsequence(s, sc, n+1, len, lst);
    }
    public List<String> AllPossibleStrings(String s) {
        List<String> lst = new ArrayList<>();
        int len = s.length();
        subsequence(s, "", 0, len, lst);
        Collections.sort(lst);
        return lst;
    }
}
