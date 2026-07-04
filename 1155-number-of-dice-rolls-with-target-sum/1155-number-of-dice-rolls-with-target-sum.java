class Solution {

    int mod = (int) 1e9 + 7;
    Integer[][] dp;

    public int solve(int n, int k, int target, int sum){
        if(n== 0 && target == sum){
            return 1;
        }
        if(sum > target){
            return 0;
        }
        if(n == 0){
            return 0;
        }if(dp[n][sum] != null) return dp[n][sum];

        long ans = 0;

        for(int i = 1; i <= k; i++){
            ans = (ans + solve(n-1, k, target, sum + i)) % mod;
        }

        return dp[n][sum] = (int) ans % mod;
    }

    public int numRollsToTarget(int n, int k, int target) {
        dp = new Integer[n+1][target + 1];
        return solve(n, k, target, 0) % mod;
    }
}