class Solution {
    int[][] take = new int[][]{{100, 0}, {75, 25}, {50, 50}, {25, 75}};
    double[][] dp;
    public double solve(int a, int b){
        if(a <= 0 && b<= 0){
            return 0.5;
        }
        if(a <= 0){
            return 1.0;
        }
        if(b <= 0){
            return 0.0;
        }
        if(dp[a][b] != -1) return dp[a][b];
        double prob = 0.0;
        for(int[] t : take){
            int a_take = t[0];
            int b_take = t[1];
            prob += solve(a - a_take, b - b_take);
        }

        return dp[a][b] = prob / 4.0;
    }

    public double soupServings(int n) {
        if(n > 5000) return 1.0;
        dp = new double[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1.0);
        }
        return solve(n, n);
    }
}