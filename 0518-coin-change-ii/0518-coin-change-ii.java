class Solution {
    int n;
    Integer[][] dp;
    public int solve(int i, int sum, int amount, int[] coins){
        if(sum == amount){
            return 1;
        }     
        if(sum > amount){
            return 0;
        }
        
        if(i == n){
            return 0;
        }
        

        if(dp[i][sum] != null){
            return dp[i][sum];
        }
        
        
        int take = solve(i, sum + coins[i], amount, coins);
        int skip = solve(i + 1, sum, amount, coins);
        
        return dp[i][sum] = take + skip;
    }

    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new Integer[n][amount + 1];
        return solve(0, 0, amount, coins);
    }
}