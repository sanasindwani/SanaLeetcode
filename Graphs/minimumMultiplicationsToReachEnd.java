package Graphs;

import java.util.LinkedList;
import java.util.Queue;
// TC -> O(100000 * arr.length)
// SC -> O(100000) + O(100000)
public class minimumMultiplicationsToReachEnd {
    class Pair{
        int steps;
        int node;
        Pair(int steps, int node){
            this.steps = steps;
            this.node = node;
        }
    }
    /*public int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;
        if(start == end) return 0;
        Queue<Pair> q = new LinkedList<>();
        int[] dis = new int[100000];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        q.add(new Pair(0,start));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i : arr){
                int nval = (curr.node * i) % mod;
                if(nval == end) return curr.steps+1;
                if(curr.steps + 1 < dis[nval]){
                    dis[nval] = curr.steps + 1;
                    q.add(new Pair(curr.steps+1, nval));
                }
            }
        }
        return -1;
    }
}*/
      public int minimumMultiplications(int[] arr, int start, int end) {
      if(start == end) return 0;
      int mod = 100000;
      boolean[] vis = new boolean[100000];
      Queue<Pair> q = new LinkedList<>();
      vis[start] = true;
      q.add(new Pair(0,start));
      while(!q.isEmpty()){
          Pair curr = q.poll();
          for(int i : arr){
              int nval = (curr.node * i) % mod;
              if(nval == end) return curr.steps+1;
              if(vis[nval] == true) continue;
              vis[nval] = true;
              q.add(new Pair(curr.steps+1 , nval));
          }
      }
      return -1;
      }

}
