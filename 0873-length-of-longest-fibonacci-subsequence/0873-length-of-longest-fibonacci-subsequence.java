class Solution {
    Map<Integer, Integer> map;
    int[][] dp;

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        dp = new int[n][n];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
         for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);   // Base length of every pair
        }

        int ans = Integer.MIN_VALUE;
        for (int j = 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int val = arr[k] - arr[j];
                if (map.containsKey(val) && map.get(val) < j) {
                    int i = map.get(val);
                    dp[j][k] = dp[i][j] + 1;

                }
                ans = Math.max(dp[j][k], ans);
            }

        }

        return ans < 3 ? 0 : ans;
    }
}