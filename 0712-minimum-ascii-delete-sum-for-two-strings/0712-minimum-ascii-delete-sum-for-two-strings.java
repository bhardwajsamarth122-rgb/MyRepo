class Solution {
    int m;
    int n;

    String[][] dp;

    public String lcs(String s1, String s2, int i, int j) {
        if (i >= m || j >= n) {
            return "";
        }
        if (!dp[i][j].equals("@"))
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return s1.charAt(i) + lcs(s1, s2, i + 1, j + 1);
        }

        String ans1 = lcs(s1, s2, i + 1, j);
        String ans2 = lcs(s1, s2, i, j + 1);

        int sum1 = 0;
        for (int k = 0; k < ans1.length(); k++) {
            sum1 += ans1.charAt(k);
        }

        int sum2 = 0;
        for (int k = 0; k < ans2.length(); k++) {
            sum2 += ans2.charAt(k);
        }

        if (sum1 > sum2)
            return dp[i][j] = ans1;
        if (sum2 > sum1)
            return dp[i][j] = ans2;

       
        return dp[i][j] = ans1;

    }

    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        dp = new String[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], "@");
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < m; i++) {
            sum1 += (int) s1.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            sum2 += (int) s2.charAt(i);
        }
        String lcs = lcs(s1, s2, 0, 0);
        int sum3 = 0;
        for (int i = 0; i < lcs.length(); i++) {
            sum3 += (int) lcs.charAt(i);
        }

        return (sum1 + sum2) - (2 * sum3);
    }
}