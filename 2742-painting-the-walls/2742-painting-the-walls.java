class Solution {
    int n;
    Integer[][] dp;

    public int solve(int i, int rem, int[] cost, int[] time){
        if(rem <= 0){
            return 0;
        }
        if(i  >= n){
           return Integer.MAX_VALUE; 
        }
        if(dp[i][rem] != null) return dp[i][rem];

        int temp  = solve(i+1, rem -1 - time[i], cost, time);
        int paint = Integer.MAX_VALUE;
        if(temp != Integer.MAX_VALUE){
            paint = cost[i] + temp;
        }


        int notPaint = solve(i+1, rem, cost, time);

        return dp[i][rem] = Math.min(paint, notPaint);
    }

    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        dp = new Integer[n + 1][n + 1];
        return solve(0, n, cost, time);
    }
}