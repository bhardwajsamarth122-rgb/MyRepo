class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if(n == 1) return grid[0][0];
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;
        int min1_ = Integer.MAX_VALUE;
        int min2_ = Integer.MAX_VALUE;

        for(int i = n-1; i >= 0; i--){
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for(int j = n-1; j >= 0; j--){
                if(i == n-1){
                    dp[i][j] = grid[i][j];
                    
                    //continue;
                }

                else if(dp[i+1][j] != min1_){
                    dp[i][j] = grid[i][j] + min1_;
                }
                else{
                    dp[i][j] = grid[i][j] + min2_;
                }


                if(min1 > dp[i][j]){
                        min2 = min1;
                        min1 = dp[i][j];
                    }
                    else if(min2 > dp[i][j]){
                        min2 = dp[i][j];
                    }
                if(i == 0){
                    ans = Math.min(ans, dp[i][j]);
                }
            }
            min1_ = min1;
            min2_ = min2;
        }

        return ans;
    }
}