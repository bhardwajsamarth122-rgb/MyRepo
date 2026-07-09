class Solution {
    int n;
    int r;
    Integer[][] dp;
    public int count(int curr, int target){
        int direct =  Math.abs(target - curr);
        int wrapped = Math.abs(r - direct);

        return Math.min(direct, wrapped);
    }

    public int solve(int at12, int keyIdx, String ring, String key){
        if(keyIdx >= n){
            return 0;
        }
        if(dp[at12][keyIdx] != null) return dp[at12][keyIdx];

        int result = Integer.MAX_VALUE;

        for(int i = 0; i < r; i++){
            if(ring.charAt(i) == key.charAt(keyIdx)){
                int step = 1 /* For the Click*/ +  count(at12, i); 
                int totalStep = step + solve(i, keyIdx + 1, ring, key);

                result = Math.min(result, totalStep);
            }
        }

        return dp[at12][keyIdx] = result;
    }

    public int findRotateSteps(String ring, String key) {
        r = ring.length();
        n = key.length();
        dp = new Integer[r+1][n+1];
        return solve(0,0, ring, key);
    }
}