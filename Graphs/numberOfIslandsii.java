import java.util.*;

class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i < n; i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int FindUPar(int node){
        if(node == parent.get(node)){
            return node;
        }

        int nNode = FindUPar(parent.get(node));
        parent.set(node, nNode);

        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ulp_u = FindUPar(u);
        int ulp_v = FindUPar(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}

public class Solution {
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        int[][] vis = new int[n][m];
        int island = 0;

        int[] ans = new int[q.length];
        int idx = 0;
        DisjointSet ds = new DisjointSet(n*m);
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        for(int[] query : q){
            int row = query[0];
            int col = query[1];
            if(vis[row][col] == 1){
                ans[idx] = island;
                idx++;
                continue;
            }

            int node = (row * m) + col;

            vis[row][col] = 1;
            island++;

            for(int i = 0; i < 4; i++){
                int nx = row + dx[i];
                int ny = col + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && vis[nx][ny] == 1){
                    int nnode = (nx * m) + ny;

                    /*int ulp = ds.FindUPar(node);
                    int unp = ds.FindUPar(nnode);

                    if(ulp != unp){
                        ds.unionBySize(node, nnode);
                        island--;
                    }*/
                    if (ds.FindUPar(node) != ds.FindUPar(nnode)) {
                        ds.unionBySize(node, nnode);
                        island--;
                    }
                }
            }
            ans[idx] = island;
            idx++;
        }
        return ans;
    }
}