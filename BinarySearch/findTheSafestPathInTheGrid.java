// Here 
// Tc -> O(N*N log N)
// Sc -> O(N*N)
// Step - 1 At first I'll apply multi-source BFS to calculate the distance from nearest thieves
/*class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
// this function will check if we can possibly make a path with sf = midSF
// thus this means that we can reach the last index n-1, n-1 with sf values equal of greater than mid
// else we say do r = mid - 1;
    boolean check(int[][] dis, int sf){
        int n = dis.length;
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][n];
        q.add(new int[]{0,0});
        if(dis[0][0] >= sf) vis[0][0] = 1;
        else                return false;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            if(row == n-1 && col == n-1) return true;

            for(int i = 0; i < 4; i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow < n && nrow >= 0 && ncol < n && ncol >= 0 && vis[nrow][ncol] == 0){
                    if(dis[nrow][ncol] < sf) continue;

                    q.add(new int[]{nrow, ncol});
                    vis[nrow][ncol] = 1;
                }
            }
        }
         return false;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        
        int n = grid.size();
        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) return 0;

        int[][] dis = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dis[i], -1);
        //int[][] vis = new int[n][n];        
        // Precalculation of distToNearestThief -> for each cell
        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(grid.get(r).get(c) == 1){
                    q.add(new int[]{r,c});
                    //vis[r][c] = 1;
                    dis[r][c] = 0;
                }
            }
        
        }

            //int level = 0;
            while(!q.isEmpty()){
                int size = q.size();

                for(int i = 0; i < size; i++){
                    int[] curr = q.poll();
                    int ri = curr[0];
                    int ci = curr[1];

                    //dis[ri][ci] = level;
                    for(int ni = 0; ni < 4; ni++){
                        int nr = ri + dr[ni];
                        int nc = ci + dc[ni];
                            if(nr < n && nr >= 0 && nc < n && nc >= 0 && dis[nr][nc] == -1){
                                dis[nr][nc] = dis[ri][ci] + 1;
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }
            }
                //level++;

        // Step - 2 is Apply Binary Search on SF(Safe factor):
        // here safe factor is already decided and then we iterate assuming that our safe factor path exsists in our journey
        // if its not now we know ki this SF and all SF's greater than this are not possible 
        //there fore we do r = SFvalue-1;
        // this is a monotonic function for such functions we do this 

        int l = 0;
        int r = 400;

        int result = 0;

        while(l <= r){
            int midSF = l + (r-l)/2;

            if(check(dis, midSF)){
                result = midSF;
                l = midSF + 1;
            } else {
                r = midSF - 1;
            }
        } 
        return result;
    }
}*/

// Dijksstra's Algorithm 
// max heap
class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
  int n=grid.size();
        int[] [] dist=new int[n][n];

        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=-1;
                if(grid.get(i).get(j)==1){
                    q.offer(new int[]{i,j});
                    dist[i][j]=0;
                }
            }
        }
int [] x={1,-1,0,0};
int [] y={0,0,1,-1};
        while(!q.isEmpty()){
          int [] curr=q.poll();
          int r=curr[0];
          int c=curr[1];
for(int k=0;k<4;k++){
    int r1=r+x[k];
    int c1=c+y[k];

if(r1>=0 && r1<n && c1>=0 && c1<n && dist[r1][c1]==-1){
    dist[r1][c1]=dist[r][c]+1;

    q.offer(new int[]{r1,c1});
}
}

        }


       PriorityQueue<int[]> pq =
    new PriorityQueue<>((a,b) -> b[0] - a[0]);

        pq.offer(new int[] {dist[0][0],0,0});

        boolean[][]vis=new boolean[n][n];
        vis[0][0]=true;
        while(!pq.isEmpty()){
 
int [] c2=pq.poll();
int wt=c2[0];
int r=c2[1];
int c=c2[2];

if(r==n-1 && c==n-1){
    return wt;
}
for(int k=0;k<4;k++){
       int r1=r+x[k];
    int c1=c+y[k];


if(r1>=0 && r1<n && c1>=0 && c1<n && vis[r1][c1]==false){
     
int nwt=Math.min(wt,dist[r1][c1]);
pq.offer(new int[]{nwt,r1,c1});
vis[r1][c1]=true;
}
}

        }


        return 0;
      
    }



}