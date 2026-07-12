class Solution {
    Map<Integer, Integer> map;
    Integer[][] dp;

    public int solve(int j, int k, int[] arr){
        if(dp[j][k] != null) return dp[j][k];
        int val = arr[k] - arr[j];

        if(map.containsKey(val) && map.get(val) < j){
            int i = map.get(val);
            return dp[j][k] = solve(i, j, arr) + 1;
        }
        
        return dp[j][k] = 2;
    }

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        dp = new Integer[n+1][n+1];
        map = new HashMap<>();
        for(int i = 0; i< n; i++){
            map.put(arr[i], i);
        }
        int ans = Integer.MIN_VALUE;
        for(int j = 1; j < n; j++){
            for(int k = j+1; k < n; k++){
                int length = solve(j, k, arr);

                if(length >= 3){
                    ans = Math.max(ans, length);
                }
            }

        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}