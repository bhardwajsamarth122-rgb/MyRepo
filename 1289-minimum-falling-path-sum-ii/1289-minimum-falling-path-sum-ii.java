class Solution {
    int n;
    Integer[][] dp;
    public int solve(int row, int col, int[][] grid){
        if(row == n-1){
            return grid[row][col];
        }

        if(dp[row][col] != null) return dp[row][col];


        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            if(j != col){
                ans = Math.min(ans, grid[row][col] + solve(row + 1, j, grid));
            }
        }

        return dp[row][col] = ans;
    }

    public int minFallingPathSum(int[][] grid) {
        n = grid.length;
        dp = new Integer[n+1][n+1];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, solve(0, i, grid));
        }

        return ans;
    }
}