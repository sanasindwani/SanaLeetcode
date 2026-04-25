public class maxSumWithoutAdjacents {
    //RECURSION 
/*class Solution {
    int maxSum(int[] arr, int n){
        if(n >= arr.length) return 0;
        int l = maxSum(arr, n+1) ;
        int r = maxSum(arr, n+2) + arr[n];
        
        return Math.max(l, r);
    }
    int findMaxSum(int arr[]) {
        int ans = maxSum(arr, 0);
        return ans;
    }
}*/

/*Mistake Memo
1. Treating primitives like global variables
- msum = Math.max(msum, sum);
“All recursive calls will update the same msum”
-In Java, int is pass-by-value
-Each call gets its own copy

“If I want results from recursion, I must RETURN them, not store them in a primitive”

2. Exploring choices but not using their results

maxSum(arr, n+1, ...);
maxSum(arr, n+2, ...);
“Just calling both will somehow give me the answer”
ignored what they returned

Correct mental model:
int a = f(...);
int b = f(...);
return Math.max(a, b);
Always collect → compare → return

3. Mixing two recursion styles

accidentally mixed:
Style A (backtracking style)
use global variable
don’t return values
Style B (functional recursion)
return values
no global variable

Correct rule:
Pick ONE style and stick to it

Base case = “STOP here” → always return

5. Index safety (very common)
used:
if(n == arr.length)

But recursion did:
n + 2
leads to out-of-bounds

Correct rule:
if(n >= arr.length)

6. State mutation confusion (sum += arr[n])

“I’ll update sum and continue”

Problem:
changed state but didn’t restore it
Correct rule (important for future):
If you change something → either
undo it (backtracking), OR pass new value instead of modifying

7. Thinking recursion “stores answers automatically”

“If I explore all paths, answer will emerge somehow”
Reality:
Recursion does NOTHING automatically
must:
capture results
combine them
return them

Correct Mental Model

Whenever while writing recursion, ask:
3 golden questions

What does my function return?
“Best answer from index n”

What are my choices?
pick / not pick

How do I combine results?
Math.max(left, right)

Final Pattern (very important)
int f(index){
    if(base case) return something;

    int choice1 = f(...);
    int choice2 = f(...);

    return combine(choice1, choice2);
}
*/
}
