class Solution {
    int tolisten;
    int unique;
    int mod = (int)1e9 + 7;
    int[][] dp;
    public int solve(int listened, int newOne,  int k){
        if(listened == tolisten){
            if(newOne == unique){
                return 1;
            }
            return 0;
        }
        if(dp[listened][newOne] !=  Integer.MIN_VALUE) return dp[listened][newOne];

        int res = 0;
        res = (int)((res + (long) (unique - newOne) * solve(listened + 1, newOne + 1, k)) % mod);
        if(newOne > k){
            res = (int)((res + (long) (newOne - k) * solve(listened + 1, newOne , k))% mod) ;
        }
        

        return dp[listened][newOne] = res % mod;
    }

    public int numMusicPlaylists(int n, int goal, int k) {
        tolisten = goal;
        dp = new int[101][101];
        for(int i = 0; i < 101; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        unique = n;
        return solve(0,0,k);
    }
}