class Solution {
    int n;
    int m;
    Integer[][] dp;

    public int solve(int i, int j, int[] nums1, int[] nums2) {
        if (i >= m || j >= n) {
            return Integer.MIN_VALUE;
        }
        if(dp[i][j] != null) return dp[i][j];
        int val = nums1[i] * nums2[j];
        int next = solve(i + 1, j + 1, nums1, nums2);

        int take_i_j = val;
        if (next != Integer.MIN_VALUE) {
            take_i_j += next;
        }
        int take_i = solve(i, j + 1, nums1, nums2);
        int take_j = solve(i + 1, j, nums1, nums2);
        return dp[i][j] = Math.max(Math.max(val, take_i_j), Math.max(take_i, take_j));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        dp = new Integer[m+1][n+1];
        return solve(0, 0, nums1, nums2);
    }
}