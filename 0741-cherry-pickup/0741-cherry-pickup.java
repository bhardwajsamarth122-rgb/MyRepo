class Solution {
    int[][] dir = new int[][] { { 1, 0 }, { 0, 1 } };
    int n;
    Integer dp[][][][];

    public int solve(int[][] grid, int r1, int c1, int r2, int c2) {
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        if(dp[r1][c1][r2][c2] != null) return dp[r1][c1][r2][c2];
        int cherry = grid[r1][c1] + grid[r2][c2];
        if (r1 == r2 && c1 == c2) {
            cherry -= grid[r2][c2];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                int n_r1 = r1 + dir[i][0];
                int n_c1 = c1 + dir[i][1];

                int n_r2 = r2 + dir[j][0];
                int n_c2 = c2 + dir[j][1];
                max = Math.max(max, solve(grid, n_r1, n_c1, n_r2, n_c2));
            }

        }
        if (max == Integer.MIN_VALUE) {
            return dp[r1][c1][r2][c2]= Integer.MIN_VALUE;
        }
        return dp[r1][c1][r2][c2] = cherry + max;
    }

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        dp = new Integer[n+1][n+1][n+1][n+1];
        int ans = solve(grid, 0, 0, 0, 0);
        if(ans == Integer.MIN_VALUE) return 0;
        return ans;
    }
}