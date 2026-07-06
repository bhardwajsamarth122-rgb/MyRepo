class Solution {
    int n;
    Integer[] dp;

    public int solve(int[] arr, int i, int k){
        if(i>= n) return 0;
        if(dp[i] != null){
            return dp[i];
        }

        int res = 0;
        int max_val = Integer.MIN_VALUE;
        for(int j = i; j < n && (j - i + 1) <= k;  j++){
            max_val = Math.max(max_val, arr[j]);
            res = Math.max(res, (max_val * (j-i+1) + solve(arr, j + 1, k)));
        }

        return dp[i] = res;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        dp = new Integer[n];
        return solve(arr, 0, k);
    }
}