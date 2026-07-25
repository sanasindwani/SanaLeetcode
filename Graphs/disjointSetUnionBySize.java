// TC -> O(4(alpha)) 
// TC -> O(constant)
// time complexicity is constant as alpha derived to be almost approximately equal to 1 
import java.util.*;

class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i = 0; i <= n; i++){
            size.add(1);
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
    
    public void unionBySize(int u, int v){
        int ulp_u = FindUPar(u);
        int ulp_v = FindUPar(v);
        
        if(ulp_v == ulp_u) return;
        
        if(size.get(u) < size.get(v)){
            parent.set(ulp_u, ulp_v);
            int nsize = size.get(ulp_v)+size.get(ulp_u);
            size.set(ulp_v, nsize);
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

public class Main
{
	public static void main(String[] args) {
		DisjointSet ds = new DisjointSet(7);
		ds.unionBySize(1, 2);
		ds.unionBySize(2, 3);
		ds.unionBySize(4, 5);
		ds.unionBySize(6, 7);
		ds.unionBySize(5, 6);
		
		if(ds.FindUPar(3) == ds.FindUPar(7)){
		    System.out.println("Same");
		} else {
		    System.out.println("Not same");
		}
		
		ds.unionBySize(3, 7);
		
			if(ds.FindUPar(3) == ds.FindUPar(7)){
		    System.out.println("Same");
		} else {
		    System.out.println("Not same");
		}
	}
}