// TC -> ≈ O(N)
// SC -> O(maxRow + maxCol)
// rows and coloumns are treated as nodes in disjoint set
// ans will be total number of stones - total connected components 
// shift by col + maxRow + 1
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

class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;

        for(int[] stone : stones){
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);

        // now we'll connect all rows and coloumns 
          // now if we'll create a grid to check the ultimate parents it'll be too costly usse better option hai ki ham map me store kar dein 

        HashSet<Integer> stoneNodes = new HashSet<>();
        // we can make a set also

        for(int[] it : stones){
            int row = it[0];
            int col = maxRow + it[1] + 1;
            ds.unionBySize(row, col);
            stoneNodes.add(row);
            stoneNodes.add(col);
        }

        int cnt = 0;
        for(int val : stoneNodes){
            if(ds.FindUPar(val) == val) cnt++;
        }

        return stones.length - cnt;
    }
}