class Solution {
    Integer[][][] dp;
    public int solve(int i, int currRate, int k, int n, int[] position, int[] time){
        if(i == n-1){
            if (k > 0) {
                return Integer.MAX_VALUE;
            }
            return 0;

        }

        if(dp[i][k][currRate] != null) return dp[i][k][currRate];
        
        int res = Integer.MAX_VALUE;
        int skip = solve(i+1, time[i+1], k, n, position, time);
        if (skip != Integer.MAX_VALUE) {
            int dist = position[i + 1] - position[i];
            res = Math.min(res, dist * currRate + skip);
        }
        
        if(k > 0){
            int mergeOpr = 0;
            int mergeTime = time[i+1];

            for(int j = i+2; j < n && mergeOpr <  k ; j++){
                mergeOpr+=1;
                mergeTime += time[j];

                int merge = solve(j, mergeTime, k - mergeOpr, n, position, time);
                if (merge != Integer.MAX_VALUE){
                    int dist1 = position[j] - position[i];
                    int time2 = currRate * dist1;
                    res = Math.min(res, time2 + merge);
                }
                
            }
        }

        return dp[i][k][currRate] = res;
    }

    public int minTravelTime(int l, int n, int k, int[] position, int[] time) {
        int sum = 0;
        for(int val : time){
            sum += val;
        }

        dp = new Integer[n+1][k+1][sum+1];

        return solve(0, time[0], k, n, position, time);
    }
}