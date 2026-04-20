package DP;
import java.util.*;

public class dpfibonacci {
    // Memoization
    // TC -> O(N)
    // SC -> O(N) + O(N) ~ O(N)
    static int f(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = f(n - 1, dp) + f(n - 2, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(f(n, dp));

        sc.close();
    }
}

    //Tabulation
    /*Because:
Hidden vs explicit space
Recursion → implicit stack space
Iteration → no hidden memory
Even though both are O(n), recursion actually uses more memory in practice

Stack overflow risk 
If n is large:
Recursion → can crash (stack limit)
Iteration → safe */

    // TC -> O(N)
    // SC -> O(N) no recursive stack space
    /*import java.util.*;

public class Main {

    static int f(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(f(n, dp));
    }
} */
// Intutive solution 
// More space optimization using pointers 
// No more space is used as no dp array is created 
// TC -> O(N)
// SC -> O(1)
/*import java.util.*;

public class Main {

    static int f(int n) {
        int prev1 = 1;
        int prev2 = 0;
        
        for(int i = 2; i <= n; i++){
           int curri = prev1 + prev2;
           prev2 = prev1;
           prev1 = curri;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(f(n));
    }
} */
