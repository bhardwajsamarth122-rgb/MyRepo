class Solution {
    int n;
    Long[][][] dp;
    public long solve(int i, int k, int[] nums, int startNew){
        if(k == 0) return 0;
        if(i >= n) return Long.MIN_VALUE;
        if(dp[i][k][startNew] != null) return dp[i][k][startNew];

        long not_take = Long.MIN_VALUE;
        if(startNew == 1){
            not_take = solve(i+1, k, nums, 1);
        }

        long take = Long.MIN_VALUE;
        long val = (long)  nums[i] * k;

        long continue_ = solve(i+1, k, nums, 0);
        long not_continue = solve(i+1, k - 1, nums, 1);

        if(k % 2 == 0){
            val = -1* val;
        }

        if(continue_ != Long.MIN_VALUE ){
            take = continue_ + val;
        }

        if(not_continue != Long.MIN_VALUE){
            take = Math.max(take, not_continue + val);
        }
       
        return dp[i][k][startNew] = Math.max(take, not_take);
        
    }

    public long maximumStrength(int[] nums, int k) {
        n = nums.length;
        dp = new Long[n+1][k+1][2];
        return solve(0, k, nums, 1);
    }
}