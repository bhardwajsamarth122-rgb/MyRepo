class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] dp = new long[m + 2][n + 2][maxMove + 1];
        int mod = (int) 1e9 + 7;
        int[][] dir = new int[][]{{1,0}, {-1,0}, {0,-1}, {0,1}};
        for (int k = 0; k <= maxMove; k++) {

            for (int i = 0; i < m + 2; i++) {
                dp[i][0][k] = 1;
                dp[i][n + 1][k] = 1;
            }

            for (int j = 0; j < n + 2; j++) {
                dp[0][j][k] = 1;
                dp[m + 1][j][k] = 1;
            }
        }

        for (int k = 1; k <= maxMove; k++) {
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            for (int[] d : dir) {
                dp[i][j][k] =
                    (dp[i][j][k]
                    + dp[i + d[0]][j + d[1]][k - 1]) % mod;
            }
        }
    }
}

        

        

        return (int) dp[startRow+1][startColumn + 1][maxMove];
    }
}
