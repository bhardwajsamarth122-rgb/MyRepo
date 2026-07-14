class Solution {

    int mod = (int) 1e9 + 7;
    Integer[][][] dp;

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int solve(int[] nums, int i, int first, int second) {
        if (i == nums.length) {
            return (first != 0 && second != 0 && first == second) ? 1 : 0;
        }

        if (dp[i][first][second] != null)
            return dp[i][first][second];

        long skip = solve(nums, i + 1, first, second);
        long f = solve(nums, i + 1, gcd(first, nums[i]), second);
        long s = solve(nums, i + 1, first, gcd(second, nums[i]));

        return dp[i][first][second] = (int) ((skip + f + s) % mod);
    }

    public int subsequencePairCount(int[] nums) {
        dp = new Integer[nums.length + 1][201][201];
        return solve(nums, 0, 0, 0);
    }
}