class Solution {
    int mod = (int) 1e9 + 7;
    int[][] direction = new int[][]{{2,-1}, {2,1}, {1,2}, {1,-2}, {-2,-1}, {-2,1}, {-1,2}, {-1,-2}};

    Integer[][][] dp;

    public int solve(int i, int j, int[][] dialer, int n, int len){
        if(len == n){
            return 1;
        }
        if(dp[i][j][len] != null) return dp[i][j][len];
        long ans = 0;

        for(int[] d : direction){
            int x = i + d[0];
            int y = j + d[1];

            if(x < 0 || y < 0 || x >= 4 || y >= 3 || dialer[x][y] == -1){
                continue;
            }

            ans = (ans + solve(x, y, dialer, n, len+1)) % mod ;
        }

        return dp[i][j][len] = (int) ans;
    }

    public int knightDialer(int n) {
        int[][] dialer = new int[4][3];
        int val = 1;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                dialer[i][j] = val++;
            }
        }

        dialer[3][0] = -1; dialer[3][1] = 0; dialer[3][2] = -1;

        dp = new Integer[4][3][n+1];

        long ans = 0;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(dialer[i][j] != -1){
                    ans = (ans + solve(i, j, dialer, n, 1)) % mod;
                }
            }
        }

        return (int) ans;
    }
}