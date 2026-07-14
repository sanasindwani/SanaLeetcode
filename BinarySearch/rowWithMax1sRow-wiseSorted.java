class Solution {

    static int lowerBound(int[] row, int x) {
        int low = 0;
        int high = row.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int rowWithMax1s(int[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        int max = 0;
        int idx = -1;

        for (int i = 0; i < n; i++) {
            int countOne = m - lowerBound(arr[i], 1);

            if (countOne > max) {
                max = countOne;
                idx = i;
            }
        }

        return idx;
    }
}