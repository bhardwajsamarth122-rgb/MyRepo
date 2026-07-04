class Solution {
    Integer dp[];
    public int solve(int i, String s, int n){
        if(i >= n){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }
        if(dp[i] != null) return dp[i];

        int ans = 0; 

        for(int j = 0; j < 3; j++){
            if((i + j + 1) <= n){
                String str = s.substring(i, i+j+1);
                if(Integer.parseInt(str) <= 26){
                    ans += solve(i+j+1, s, n);
                }
            }
        }

        return dp[i] = ans;
    }

    public int numDecodings(String s) {
        int n = s.length();
        dp = new Integer[n];
        int ans = 0;

        return solve(0, s, n);
    }
}