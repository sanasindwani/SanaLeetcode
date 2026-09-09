class Solution {
    public long countCommas(long n) {
        long ans = 0;

        for (long k = 1000; k <= n; ) {
            ans += n - k + 1;

            if (k > n / 1000) {
                break;
            }

            k *= 1000;
        }

        return ans;
    }
}
