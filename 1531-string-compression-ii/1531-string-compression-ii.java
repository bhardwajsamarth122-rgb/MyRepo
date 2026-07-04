class Solution {

    int n;
    String s;
    HashMap<String, Integer> dp;

    public int solve(int i, char prev, int freq, int k) {

        if (k < 0) {
            return Integer.MAX_VALUE;
        }

        if (i >= n) {
            return 0;
        }

        String key = i + "," + prev + "," + freq + "," + k;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int delete_i = solve(i + 1, prev, freq, k - 1);

        int keep_i;

        if (prev != s.charAt(i)) {

            keep_i = 1 + solve(
                i + 1,
                s.charAt(i),
                1,
                k
            );

        } else {

            int one_more_addition = 0;

            if (freq == 1 || freq == 9 || freq == 99) {
                one_more_addition = 1;
            }

            keep_i = one_more_addition
                    + solve(i + 1, prev, freq + 1, k);
        }

        int ans = Math.min(delete_i, keep_i);

        dp.put(key, ans);

        return ans;
    }

    public int getLengthOfOptimalCompression(String str, int k) {

        s = str;
        n = s.length();

        dp = new HashMap<>();

        return solve(0, '#', 0, k);
    }
}