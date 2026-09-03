public class Main{
    public static int maxDays(int[] need, int S, int E){
        int n = need.length;
        int[] prefixCount = new int[n + 1];
        int[] prefixStock = new int[n + 1];
        
        int stock = S;
        int count = 0;
        
        // at first we'll calculate the before E scenario 
        for(int i = 0; i < n; i++){
            prefixStock[i] = stock;
            prefixCount[i] = count;
            
            if(need[i] <= stock){
                count++;
                stock -= need[i];
            }
        }
        prefixCount[n] = count;
        prefixStock[n] = stock;
        
        // abb we'll calculate all possible combination with E added 
        int ans = 0;
        
        for (int i = 0; i < n; i++){
            int currentStock = prefixStock[i] + E;
            int currentCount = prefixCount[i];
            
            for(int j = i; j < n; j++){
                if(need[j] <= currentStock){
                    currentCount++;
                    currentStock -= need[j];
                }
            }
            
            ans = Math.max(ans, currentCount);
        }
        
        return ans;
    }
    
    public static void main(String[] args){
        int need[] = {200, 5, 15, 2, 1};
        int S = 6;
        int E = 3;
        
        int val = maxDays(need, S, E);
        System.out.print(val);
    }
}