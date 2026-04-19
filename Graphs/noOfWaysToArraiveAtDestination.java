package Graphs;
import java.util.*;

class noOfWaysToArriveAtDestination {
    // TC -> O(E log V)
    class Pair{
        long time;
        int node;
        Pair(long time, int node){
            this.time = time;
            this.node = node;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9 + 7);

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] r : roads){
            adj.get(r[0]).add(new Pair(r[2], r[1]));
            adj.get(r[1]).add(new Pair(r[2], r[0]));
        }

        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);

        int[] ways = new int[n];
        ways[0] = 1;
        time[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.time, b.time));
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if(curr.time > time[curr.node]) continue;

            for(Pair ni : adj.get(curr.node)){
                long ntime = curr.time + ni.time;

                if(ntime < time[ni.node]){
                    time[ni.node] = ntime;
                    ways[ni.node] = ways[curr.node];
                    pq.add(new Pair(ntime, ni.node));
                }
                else if(ntime == time[ni.node]){
                    // parent node se voh path kitni node se aara
                    // after parent is copied to des node now we see how many nodes can carry same parent node path 
                    // total parent * parent[ways]
                    ways[ni.node] = (ways[ni.node] + ways[curr.node]) % mod;
                }
            }
        }

        return ways[n-1];
    }
}
/*
class Solution {
    class Pair{
        long time;
        int node;
        Pair(long time, int node){
            this.time = time;
            this.node = node;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9 + 7);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int j = 0; j < roads.length; j++){
            adj.get(roads[j][0]).add(new Pair(roads[j][2], roads[j][1]));
            adj.get(roads[j][1]).add(new Pair(roads[j][2], roads[j][0]));
        }
        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        int[] ways = new int[n];
        ways[0] = 1;
        time[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Long.compare(a.time, b.time));
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.time > time[curr.node]) continue;
            for(Pair ni : adj.get(curr.node)){
                long ntime = curr.time + ni.time;
                if(ntime < time[ni.node]){
                    pq.add(new Pair(ntime, ni.node));
                    time[ni.node] = ntime;
                    ways[ni.node] = ways[curr.node];
                }
                else if(ntime == time[ni.node]){
                    ways[ni.node] = (ways[curr.node] + ways[ni.node]) % mod;
                }
            }
        }
    return ways[n-1] % mod;
    }
} */