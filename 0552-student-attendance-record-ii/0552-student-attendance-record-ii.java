class Solution {
    int mod = (int) 1e9 + 7;
    Integer[][][] dp;

    public int solve(int i, int abs, int lt, int n){
        if(i == n){
            return 1;
        }
        if(dp[i][abs][lt] != null) return dp[i][abs][lt];
        long absent = 0; long late = 0; long present  = 0;
        if(abs > 0){
            absent = (solve(i+1, abs - 1,0, n) % mod);
        }
        if(lt < 2){
            late = (solve(i+1, abs, lt + 1, n) % mod);
        }

        present = (solve(i+1, abs, 0, n) % mod);

        return dp[i][abs][lt] = (int) ((absent + late + present) % mod);
    }

    public int checkRecord(int n) {
        dp = new Integer[n+1][2][3];
        return solve(0, 1, 0, n);
    }
}