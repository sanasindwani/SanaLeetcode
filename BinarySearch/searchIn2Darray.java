// Method - 3
// best sol
// Tc -> O(n + m)
// here we have two starting points at the diagonal from right to left
// where we see a pattern on how the values are increasing and decreasing
// thus when we get to decide which direction is best to move from that position at extremeright corner we have either go left when that element is greater than target or go down when that ele is smaller cause its left will be even smaller 
// thus we reduce either one row or one col at a time
// and max path will become two extremes diagonal point thus m+n length

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        // the starting point
        int row = 0, col = m-1;

        while(row < n && col >= 0){
            if(matrix[row][col] == target) return true;

            else if(matrix[row][col] < target){
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}


// Method - 2
// Better sol
// TC -> O(n * log(m))
// here we know every row is sorted thus we try to perform binary search on every row and check if it exsist in that particular row

/*class Solution {
    boolean bs(int[] mat, int target){
        int l = 0, r = mat.length - 1;

        while(l <= r){
            int mid = (l + r)/2;

            if(mat[mid] == target) return true;
            else if (mat[mid] < target) l = mid + 1;
            else                        r = mid - 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            boolean pos = bs(matrix[i], target);
            if(pos == true) return true;
        }
        return false;
    }
}*/


// Method - 1
// simple iteration
// Tc -> O(n*m)

/*class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}*/