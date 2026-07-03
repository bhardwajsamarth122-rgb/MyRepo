class Solution {
    int n;
    int mod = (int) 1e9 + 7;
    Integer[][] dp;
    public int solve(int i, int step){
        if(step == 0 && i == 0){
            return 1;
        }
        if(step <= 0){
            return 0;
        }
        if(i < 0 || i >= n){
            return 0;
        }

        if(dp[i][step] != null) return dp[i][step];

        long right = solve(i+1, step - 1) % mod;
        long left = solve(i-1, step -1) % mod;
        long stay = solve(i, step - 1) % mod;

        return dp[i][step] = (int) ((right + left + stay) % mod);
    }

    public int numWays(int steps, int arrLen) {
        n = Math.min(arrLen, steps / 2 + 1);
        dp = new Integer[n+1][steps + 1];
        return solve(0, steps) % mod;
    }
}