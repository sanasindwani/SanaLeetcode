// my approach is better -> 2nd approach
// sir has solved it differently instead of just differnt provinces while dynamically forming the graph he counted extra edges
// now these extra edges will be counted and evaluated using a if condition that if extraEdges count > number of components - 1 then we can connect as for n number of components n - 1 edges is required 
// then we return components - 1
// my method was to just check if its not possible then implement the possible condition
class DisjointSet{
    List<Integer> size = new ArrayList<>();
    public List<Integer> parent = new ArrayList<>();

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

        int nNode = findUPar(parent.get(node));
        parent.set(node, nNode);

        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int upu = findUPar(u);
        int upv = findUPar(v);

        if(upu == upv) return;

        if(size.get(upu) < size.get(upv)){
            parent.set(upu, upv);
            size.set(upv, size.get(upu) + size.get(upv));
        } else {
            parent.set(upv, upu);
            size.set(upu, size.get(upu) + size.get(upv));
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        DisjointSet ds = new DisjointSet(n);
        int extra = 0;

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];

            if(ds.findUPar(u) == ds.findUPar(v)){
                extra++;
            } else {
                ds.unionBySize(u, v);
            }
        }

        int count = 0;
        for(int i = 0; i < ds.parent.size(); i++){
            if(ds.parent.get(i) == i) count++;
        }

        int ans = count - 1;
        if(extra >= ans) return ans;
        return -1;
    }
}

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

        int nNode = findUPar(parent.get(node));
        parent.set(node, nNode);

        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int upu = findUPar(u);
        int upv = findUPar(v);

        if(upu == upv) return;

        if(size.get(upu) < size.get(upv)){
            parent.set(upu, upv);
            size.set(upv, size.get(upu) + size.get(upv));
        } else {
            parent.set(upv, upu);
            size.set(upu, size.get(upu) + size.get(upv));
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(edges + 1 < n) return -1;
        // if(connections.length < n - 1) return -1;

        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < edges; i++){
            ds.unionBySize(connections[i][0], connections[i][1]);
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            if (ds.findUPar(i) == i) count++;
        }

        return count - 1;
    }
}*/