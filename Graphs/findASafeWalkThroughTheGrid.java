// can be solved using BFS + 2D array
// and even reverse dijkstra + 2D array
/*class Tuple{
    int row;
    int col;
    int maxHealth;

    Tuple(int row, int col, int maxHealth){
        this.row = row;
        this.col = col;
        this.maxHealth = maxHealth;
    }
}
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] bestHealth = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(bestHealth[i], -1);
        bestHealth[0][0] = health - grid.get(0).get(0);

        int[] d = {0,1,0,-1,0};

        PriorityQueue<Tuple> q = new PriorityQueue<>((a,b) -> b.maxHealth - a.maxHealth);
        q.add(new Tuple(0,0, health - grid.get(0).get(0)));

        while(!q.isEmpty()){
            Tuple t = q.poll();
            int r = t.row;
            int c = t.col;
            int h = t.maxHealth;

            if(h < 1) break;

            if(r == m-1 && c == n-1){
                return true;
            }

            if(h < bestHealth[r][c]) continue;

            for(int i = 0; i < 4; i++){
                int nr = r + d[i];
                int nc = c + d[i+1];
                

                if(nr < m && nr >= 0 && nc < n && nc >= 0){
                    int ndis = h - grid.get(nr).get(nc);
                    if(ndis > bestHealth[nr][nc]){
                        bestHealth[nr][nc] = ndis;
                    q.add(new Tuple(nr, nc, ndis));
                    }
                }
            }
        }
        return false;
    }
}*/

// This solution doesn't require a MaxHealth in our queue because it doesn't use Priority Queue
// When we use priority Queue we need to put updated Health because it works on making updated health better
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] bestHealth = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(bestHealth[i], -1);
        }

        int startHealth = health - grid.get(0).get(0);
        if (startHealth < 1) return false;

        bestHealth[0][0] = startHealth;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            int currHealth = bestHealth[r][c];

            if (r == m - 1 && c == n - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                int newHealth = currHealth - grid.get(nr).get(nc);

                if (newHealth < 1)
                    continue;

                if (newHealth > bestHealth[nr][nc]) {
                    bestHealth[nr][nc] = newHealth;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}c