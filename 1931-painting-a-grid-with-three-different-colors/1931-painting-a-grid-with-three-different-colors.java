class Solution {
    int m;
    int n;
    int mod = (int) 1e9 + 7;
    List<String> colState;
    Integer dp[][];

    public void fill(String curr, List<String> lst, char prev) {
        if (curr.length() == m) {
            lst.add(curr);
            return;
        }
        for (char ch : new char[] { 'R', 'B', 'G' }) {
            if (ch != prev) {
                fill(curr + ch, lst, ch);
            }
        }
    }

    public int solve(int prev, int remain) {
        if (remain == 0) {
            return 1;
        }
        if(dp[prev][remain] != null) return dp[prev][remain];

        long ans = 0;
        String prvs = colState.get(prev);

        for (int i = 0; i < colState.size(); i++) {
            if (prev == i)
                continue;
            boolean ok = true;
            for (int j = 0; j < m; j++) {
                if (prvs.charAt(j) == colState.get(i).charAt(j)) {
                    ok = false;
                    break;
                }
            }
            if (!ok)
                continue;

            ans = (ans + solve(i, remain - 1)) % mod;
        }

        return dp[prev][remain] = (int) ans % mod;
    }

    public int colorTheGrid(int M, int N) {
        m = M;
        n = N;

        colState = new ArrayList<>();
        fill("", colState, '#');

        dp = new Integer[colState.size() + 1][n+1];

        long ans = 0;
        for (int i = 0; i < colState.size(); i++) {
            ans = (ans + solve(i, n - 1)) % mod;
        }

        return (int) ans % mod;
    }
}