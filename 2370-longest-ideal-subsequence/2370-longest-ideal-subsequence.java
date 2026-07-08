class Solution {
    int n;
    Integer[][] dp;
    public int solve(int i, char prev, int k, String s){
        if(i >= n)
            return 0;

        int idx = (prev == '#') ? 26 : prev - 'a';
        if(dp[i][idx] != null) return dp[i][idx];

        int take = 0;
        if(prev == '#' || Math.abs(prev - s.charAt(i)) <= k){
            take = 1 + solve(i+1, s.charAt(i), k, s);
        }
        
        int notTake = solve(i+1, prev, k, s);

       
        

        return dp[i][idx] = Math.max(take, notTake);
    }

    public int longestIdealString(String s, int k) {
        n = s.length();
        dp = new Integer[n+1][27];
        return solve(0, '#', k, s);
    }
}