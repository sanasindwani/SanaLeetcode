// TC -> O(m*n)
// SC -> O(1)
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int idx = -1;
        int maxC = -1;

        for(int i = 0; i < m; i++){
            int rowC = 0;
            for(int j = 0; j < n; j++){
                rowC += mat[i][j];
            }

            if(rowC > maxC){
                maxC = rowC;
                idx = i;
            }
        }
        return new int[]{idx, maxC};
    }
}