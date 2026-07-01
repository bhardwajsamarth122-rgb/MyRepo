class Solution {
    int m;
    int n;
    int len;
    Boolean dp[][][];

    public boolean solve(int i, int j, int k, String s1, String s2, String s3){
        if(i >= m && j >= n && k >= len){
            return true;
        }

        if(dp[i][j][k] != null) return dp[i][j][k];

        if((i < m && k < len) && s1.charAt(i) == s3.charAt(k)){
            if(solve(i+1, j, k+1, s1,s2,s3)){
                return dp[i][j][k] = true;
            }
        }
        if((j < n && k < len) && s2.charAt(j) == s3.charAt(k)){
            if(solve(i, j+1, k+1, s1,s2,s3)){
                return dp[i][j][k] = true;
            }
        }

        return dp[i][j][k] = false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        len = s3.length();

        dp = new Boolean[m+1][n+1][len+1];

        return solve(0,0,0, s1,s2,s3);
    }
}