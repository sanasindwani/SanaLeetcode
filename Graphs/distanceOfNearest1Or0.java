package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class distanceOfNearest1Or0 {
    //GFG my solution
    // Leetcode one is just reverse 0 <-> 1
    class Solution {
    class Pair{
        int[] arr;
        int num;
        
        Pair(int[] arr, int num){
            this.arr = arr;
            this.num = num;
        }
    }
    
    void bfs(Queue<Pair> q,int[][]vis,int[][] grid, ArrayList<ArrayList<Integer>> ans){
        int[] delX = {1,0,-1,0};
        int[] delY = {0,1,0,-1};
        int m = grid.length;
        int n = grid[0].length;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int i = p.arr[0];
            int j = p.arr[1];
            int a = p.num;
            ans.get(i).set(j, a);
            for(int k = 0; k < 4; k++){
                int ni = i + delX[k];
                int nj = j + delY[k];
                if(ni < m && nj < n && ni >= 0 && nj >= 0 && vis[ni][nj] == 0){
                    vis[ni][nj] = 1;
                    q.add(new Pair(new int[]{ni,nj}, a+1));
                }
            }
        }
    }
    
    
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int m = grid.length;
        int n = grid[0].length;
        int[][]vis = new int[m][n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // i forgot initiation
        for(int i = 0; i < m; i++){
            ans.add(new ArrayList<Integer>());
            for(int j = 0; j < n; j++){
                ans.get(i).add(0);
            }
        } 
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(new int[]{i,j},0));
                    vis[i][j] = 1;
            }
        }
        }
        bfs(q, vis, grid, ans);
        return ans;
    }
}
}
