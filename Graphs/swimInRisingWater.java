// This question can be solved using three ways sanae
// first -> Binary search + DFS (sabse pehle lower bound se nikal liya ki time then usko DFS se check kiys ki possible hai ya nahi) (TC -> O(n^2 log V))
// second -> Better approach -> DSU connect karke -> process cells in increasing order of elevation, activate them, and union them with already activated neighbors. As soon as the start and end belong to the same component, that's the answer.
// third -> optimal/best approach is using Dijkstra/PriorityQueue (TC -> O(n^2 log n))

// kyonki yahan pe ham maximum of minimised path dhoond rahe hai it's binary search kyonki jahan pe minimise the maximum ya maximize the minimum bola ho it suggests binary search on answer

// first isko binary search se solve karte hai
/*class Solution {
    boolean isPossible(int mid, int row, int col, int[][] grid, int[] dx, int[] dy, int[][] vis){
        int n = grid.length;
        vis[row][col] = 1;
        if(row == n - 1 && col == n - 1) return true;

        for(int i = 0; i < 4; i++){
            int nr = row + dx[i];
            int nc = col + dy[i];

            if(nr < n && nr >= 0 && nc < n && nc >= 0 && vis[nr][nc] == 0 && grid[nr][nc] <= mid){
               // return isPossible(mid, nr, nc, grid, dx, dy, vis);
               // this is wrong kyonki yeah bahot jaldi return kar dega eak hi neighbour check karke
               if(isPossible(mid, nr, nc, grid, dx, dy, vis)) return true; 
            }
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        // its written max grid[i][j] will be < n^2 this high = n^2 - 1
        int n = grid.length;
        int[] dx = {1,0,-1,0};
        int[] dy = {0, -1, 0, 1};

        int l = Math.max(grid[0][0], grid[n - 1][n - 1]), r = (n*n) - 1;
        // l = grid[0][0] bhi chalega
        while(l <= r){
            int mid = l + (r - l)/2;
            int[][] vis = new int[n][n];

            if(isPossible(mid, 0, 0, grid, dx, dy, vis)){
                r = mid - 1;
            }

            else l = mid + 1;
        }

        return l;
    }
}*/

// second method is DSU 
// DSU -> O(n² log n)
/*class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i < n; i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int nnode = findUPar(parent.get(node));
        parent.set(node, nnode);

        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution{
    public int swimInWater(int[][] grid) {
        int n = grid.length;


// isse ham sort kar lenge ki kis order me joh hai connect honge cells as cells are the DSU node 
        int[][] cells = new int[n*n][3];
        int idx = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cells[idx++] = new int[] {grid[i][j], i, j};
            }
        }

        // abb iss cells ko sort karenge
        Arrays.sort(cells, (a, b) -> a[0] - b[0]);


// yeah batayega ki yeah activated cell hai toh agar neighbour koi active cell hai tabhi continue ho sakta path
        boolean[][] vis = new boolean[n][n];


// neighbours active karne ke liyae
        int[] dr = {1,0,-1,0};
        int[] dc = {0, -1, 0, 1};

        DisjointSet ds = new DisjointSet(n*n);

        for(int[] cell : cells){
            int time = cell[0];
            int row = cell[1];
            int col = cell[2];

            vis[row][col] = true;

            int node = row*n + col;

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr < n && nr >= 0 && nc  < n && nc >= 0 && vis[nr][nc]){
                    int adjNode = nr*n + nc;
                    ds.unionBySize(node, adjNode);
                }
            }

            if(vis[0][0] && vis[n-1][n-1] && ds.findUPar(0) == ds.findUPar(n*n - 1)){
                return time;
            }
        }
        return -1;
    }
}*/

// best solution 
// dijshtra algo

/*class Solution{
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] vis = new int[n][n];

        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        // int minT = 0;
        // unnecessary

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            
            int time = node[0];
            int row = node[1];
            int col = node[2];
            if (vis[row][col] == 1) continue;
            vis[row][col] = 1;

            if(row == n-1 && col == n-1) return time;

            for(int i = 0; i < 4; i++){
                int nr = row + dx[i];
                int nc = col + dy[i];

                if(nr < n && nr >= 0 && nc < n && nc >= 0 && vis[nr][nc] == 0){
                    //pq.add(new int[]{grid[nr][nc], nr, nc}); wrong
                    // kyonki hame path ka max store karke aage jana hai toh we'll do max(encountered till now, iss cell ka)
                    pq.add(new int[]{Math.max(time, grid[nr][nc]), nr, nc});
                }
            }
        }
        return -1;
    }
}*/

// Interview Style
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // Directions: Down, Left, Up, Right
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, -1, 0, 1};

        boolean[][] vis = new boolean[n][n];

        // {currentTime, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Start from (0,0)
        pq.offer(new int[]{grid[0][0], 0, 0});

        while (!pq.isEmpty()) {

            int[] node = pq.poll();

            int time = node[0];
            int row = node[1];
            int col = node[2];

            // Already processed
            if (vis[row][col]) continue;

            vis[row][col] = true;

            // Destination reached
            if (row == n - 1 && col == n - 1) {
                return time;
            }

            // Explore all 4 neighbours
            for (int i = 0; i < 4; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    !vis[nr][nc]) {

                    // Maximum elevation encountered on this path
                    int newTime = Math.max(time, grid[nr][nc]);

                    pq.offer(new int[]{newTime, nr, nc});
                }
            }
        }

        return -1;
    }
}