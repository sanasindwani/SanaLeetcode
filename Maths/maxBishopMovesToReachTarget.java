// bfs se better approach is bishop ki technique samjhna 
class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int sr = source[0], sc = source[1];
        int tr = target[0], tc = target[1];

        if(sr == tr && sc == tc) return 0;
        if((sr + sc) % 2 != (tr + tc) % 2) return -1;
        if(Math.abs(sr - tr) == Math.abs(sc - tc)) return 1;
        return 2;
    }
}
/*class Solution {
    int bfs(int[] s, int[] t, int[][] dis, int[] dx, int[] dy){
        dis[s[0]][s[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s[0], s[1]});

        while(!q.isEmpty()){
            int[] val = q.poll();
            int row = val[0];
            int col = val[1];
            if(row == t[0] && col == t[1]) return dis[row][col];

            for(int i = 0; i < 4; i++){
                int nr = row + dx[i];
                int nc = col + dy[i];

                while(nr >= 0 && nr <= 8 && nc >= 0 && nc <= 8){
                    if(dis[nr][nc] > dis[row][col] + 1){
                        dis[nr][nc] = dis[row][col] + 1;
                        q.add(new int[]{nr, nc});
                    }
                    nr += dx[i];
                    nc += dy[i];
                }
            }
            
        }
        return -1;
    }
    public int minBishopMoves(int[] source, int[] target) {
        int[][] dis = new int[9][9];
        for(int i = 0; i < 9; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);

        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, +1, +1, -1};

        return bfs(source, target, dis, dx, dy);
    }
}*/


ss