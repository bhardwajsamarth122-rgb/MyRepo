class Solution {
    int m;
    int n;
    int mod = (int) 1e9 + 7;
    int[][] dir = new int[][]{{1,0}, {-1,0}, {0,-1}, {0,1}};
    Integer[][][] dp;
    public int solve(int x, int y, int maxMove){
        if(x < 0 || y < 0 || x >= m || y >= n){
            return 1;
        }
        if(maxMove <= 0){
            return 0;
        }
        if(dp[x][y][maxMove] != null) return dp[x][y][maxMove];
        long ans = 0;
        for(int[] d : dir){
            int i = d[0] + x;
            int j = d[1] + y;
            ans = (ans + solve(i, j, maxMove - 1)) % mod;
        }

        return dp[x][y][maxMove] = (int) ans % mod;
    }

    public int findPaths(int M, int N, int maxMove, int startRow, int startColumn) {
        m = M;
        n = N;
        dp = new Integer[m+1][n+1][maxMove+1];
        return solve(startRow, startColumn, maxMove);
    }
}