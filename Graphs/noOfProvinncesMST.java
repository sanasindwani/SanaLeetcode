class DisjointSet{
    public List<Integer> size = new ArrayList<>();
    public List<Integer> parent = new ArrayList<>();

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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i == j) continue;

                if(isConnected[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }

// this will count the number of different ultimate parent exsist in the graph
// and acc to it we will have different provinces 
        int count = 0;
// if ultimate parent of a nide is the node itself then that node is the ultimate node

// we can even use parent list directly in order to check for different parents or ultimate parents directly 
          for(int i = 0; i < n; i++){
            if(ds.parent.get(i) == i) count++;
          }
        /*for(int i = 0; i < n; i++){
            if(ds.FindUPar(i) == i) count++;
        }*/

        return count;
    }
}