// TC -> O(n * log(m))
// SC -> O(1)
class Solution {
    int findMax(int[][] mat, int mid, int n, int m){
        int max = 0;
        int idx = 0;

        for(int i = 0; i < n; i++){
            if(mat[i][mid] > max){
                max = mat[i][mid];
                idx = i;
            }
        }
        return idx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int l = 0, r = m - 1;

        while(l <= r){
            int mid = l + (r - l)/2;

            int row = findMax(mat, mid, n, m);
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < m ? mat[row][mid + 1] : -1;

            if(mat[row][mid] > left && mat[row][mid] > right) return new int[] {row, mid};

            else if(mat[row][mid] < left) r = mid - 1;
            else                          l = mid + 1; 
        }
        return new int[]{-1, -1};
    }
}