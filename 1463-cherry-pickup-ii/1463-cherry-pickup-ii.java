class Solution {
    int m;
    int n;

    Integer[][][] dp;

    public int solve(int[][] grid, int r, int c1, int c2){
        if(r >= m || c1 < 0 || c1 >= n || c2 < 0 || c2 >= n){
            return 0;
        }

        if(dp[r][c1][c2] != null) return dp[r][c1][c2];

        int cherry = grid[r][c1] + grid[r][c2];
        if(c1 == c2){
            cherry -=  grid[r][c2];
        }
        int max = Integer.MIN_VALUE;
        for(int val1 = -1; val1 <= 1; val1++){
            for(int val2 = -1; val2 <= 1; val2++){
                int new_c1 = c1 + val1;
                int new_c2 = c2 + val2;
                max = Math.max(max, solve(grid, r+1, new_c1, new_c2));
            }
        }

        return dp[r][c1][c2] = cherry + max;
    }

    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m+1][n+1][n+1];
        return solve(grid, 0, 0, n-1);
    }
}