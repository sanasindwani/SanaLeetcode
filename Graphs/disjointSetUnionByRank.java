import java.util.*;

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
        int ulp = FindUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void unionByRank(int u, int v){
        int ulp_u = FindUPar(u);
        int ulp_v = FindUPar(v);
        
        if(ulp_v == ulp_u) return;
        
        if(rank.get(u) < rank.get(v)){
            parent.set(ulp_u, ulp_v);
        } 
        else if(rank.get(v) < rank.get(u)){
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU+1);
        }
    }
}

public class Main
{
	public static void main(String[] args) {
		DisjointSet ds = new DisjointSet(7);
		ds.unionByRank(1, 2);
		ds.unionByRank(2, 3);
		ds.unionByRank(4, 5);
		ds.unionByRank(6, 7);
		ds.unionByRank(5, 6);
		
		if(ds.FindUPar(3) == ds.FindUPar(7)){
		    System.out.println("Same");
		} else {
		    System.out.println("Not same");
		}
		
		ds.unionByRank(3, 7);
		
			if(ds.FindUPar(3) == ds.FindUPar(7)){
		    System.out.println("Same");
		} else {
		    System.out.println("Not same");
		}
	}
}