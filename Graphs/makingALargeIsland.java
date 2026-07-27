// Tc -> O(n^2* α(n^2))+ O(n^2 α(n^2))+ O(n^2) ~ O(n^2)
// SC -> O(n^2) as parent and size array hashset max 4 element lega toh voh constant hai
class DisjointSet{
    public List<Integer> size = new ArrayList<>();
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

class Solution {
    boolean isValid(int nr, int nc, int n){
        return nr < n && nc < n && nr >= 0 && nc >= 0;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, +1, 0};

// my first step will be to connect the components
// Build the DSU only for the original 1s
// yeah step - 1 tha
        DisjointSet ds = new DisjointSet(n*n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;

                for(int k = 0; k < 4; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if(isValid(nr, nc, n) && grid[nr][nc] == 1){
                        int node1 = i * n + j;
                        int node2 = nr * n + nc;
                        ds.unionBySize(node1, node2);
                    }
                }
            }
        }

// step -> 2 was to do simple brute force where we check all the possible 0's and try and convert them into 1 and check the max size possible
            int max = 0;

            for(int row = 0; row < n; row++){
                for(int col = 0; col < n; col++){
                    if(grid[row][col] == 1) continue;
                    HashSet<Integer> set = new HashSet<>();

                    for(int i = 0; i < 4; i++){
                        int nr = row + dr[i];
                        int nc = col + dc[i];

                        if(isValid(nr, nc, n) && grid[nr][nc] == 1){
                            int node = ds.FindUPar(nr * n + nc);
                            set.add(node);
                        }
                    }
                    int temp = 0;
                    for(int val : set){
                        temp += ds.size.get(val);
                    }

                    max = Math.max(max, temp + 1);
                }
            }

// this is the last step and it checks if all the cells are 1 then max will never be updates and will stay as 0 thus we have the last check here which sees if the grid contains all 1's then the max size of the nodes of ultimate parent will be the ans
            /*for(int cellN = 0; cellN < n*n; cellN++){
                max = Math.max(max, ds.size.get(cellN));
            }*/
            if(max == 0) return n*n;
        return max;
    }
}