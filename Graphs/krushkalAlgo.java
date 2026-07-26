// TC -> O(M log M + M*4*alpha) since alpha is constant we can say TC ~ O(M log M)
// SC -> O(M + V) M for sorting and V for rank, parent

class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i = 0; i <= n; i++){
            rank.add(0);
            parent.add(i);
        }
    }
    
    public int FindUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        
        int nPar = FindUPar(parent.get(node));
        parent.set(node, nPar);
        
        return parent.get(node);
    }
    
    public void unionByRank(int u, int v){
        int ulp_u = FindUPar(u);
        int ulp_v = FindUPar(v);
        
        if(ulp_u == ulp_v) return;
        
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u)+1);
        }
    }
}

class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        DisjointSet dj = new DisjointSet(V);
        // M log M
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int MSTwt = 0;
        
        // M * 4 * alpha
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            if(dj.FindUPar(u) != dj.FindUPar(v)){
                MSTwt += wt;
                dj.unionByRank(u, v);
            }
            
        }
        
        return MSTwt;
    }
}
