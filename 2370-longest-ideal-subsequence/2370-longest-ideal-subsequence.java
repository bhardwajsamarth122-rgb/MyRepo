class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }
        int[] character = new int[26];
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i< n; i++){
            int idx = s.charAt(i) - 'a';
            for(int j = Math.max(0, idx - k); j <= Math.min(25, idx + k); j++){
                dp[i] = Math.max(dp[i], character[j] + 1);
               
            } 
            character[idx] = dp[i];
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}