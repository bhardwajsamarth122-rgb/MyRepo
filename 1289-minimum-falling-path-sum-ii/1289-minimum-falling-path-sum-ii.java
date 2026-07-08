class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if(n == 1) return grid[0][0];
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i == n-1){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                for(int col = 0; col < n; col++){
                    if(j != col){
                        dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i+1][col]);
                    }
                }
                if(i == 0){
                    ans = Math.min(ans, dp[i][j]);
                }
            }
        }

        return ans;
    }
}