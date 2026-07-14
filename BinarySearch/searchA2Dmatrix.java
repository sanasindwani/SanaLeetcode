// Approach - 3
// Best approach
// we'll imagine as if we flatten the whole 2D array and then we'll search over the matrix using binary search
// now the TC -> O(log(m*n))
// here we change the indexes as num/m as row and num%m as coloum
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0, r = (n*m) - 1;
        while(l <= r){
            int mid = (l + r)/2;

            int row = mid / m;
            int col = mid % m;

            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}

// Appraoch - 2
// iterate over rows and look for rows which might contain the element
// use binary search to put the element in its right position
// TC -> O(n) + log(m) as we are using binary search only once

/*class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            if(matrix[i][0] <= target && matrix[i][m - 1] >= target){
                int l = 0, r = m - 1;

                while(l <= r){
                    int mid = (l + r)/2;

                    if(matrix[i][mid] == target) return true;
                    else if(matrix[i][mid] < target){
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}*/

// Approach - 1
// simple iteration
// TC -> O(N*M)
/*class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}*/