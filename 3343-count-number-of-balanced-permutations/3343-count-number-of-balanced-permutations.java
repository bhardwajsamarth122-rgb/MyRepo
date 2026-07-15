class Solution {
    int n;
    int totalSum;
    int mod = (int) 1e9 + 7;
    int totalPermutation;
    Integer[][][] dp;

    public int pow(int a, int b) {
        if (b == 0)
            return 1;
        long half = pow(a, b / 2) % mod;
        long result = (half * half) % mod;

        if (b % 2 != 0) {
            result = (result * a) % mod;
        }

        return (int) result % mod;
    }

    public int solve(int digit, int currSum, int evenDigit, int[] freq, int[] fermetFac) {
        if (digit == 10) {
            if (currSum == totalSum / 2 && evenDigit == (n + 1) / 2) {
                return totalPermutation;
            }
            return 0;
        }

        if(dp[digit][currSum][evenDigit] != null) return dp[digit][currSum][evenDigit];

        int total = freq[digit];
        int ans = 0;

        for (int count = 0; count <= total; count++) {
            int eve = count;
            int odd = total - count;

            long div = (int) ((1L * fermetFac[eve] * fermetFac[odd]) % mod);
            long val = solve(digit + 1, currSum + (eve * digit), evenDigit + count, freq, fermetFac);

            ans = (ans + (int) ((1L * div * val) % mod)) % mod;
        }

        return dp[digit][currSum][evenDigit] = ans;
    }

    public int countBalancedPermutations(String num) {
        n = num.length();

        int[] freq = new int[10];
        totalSum = 0;
        for (int i = 0; i < n; i++) {
            int val = num.charAt(i) - '0';
            totalSum += val;
            freq[val]++;
        }

        if (totalSum % 2 != 0)
            return 0;

        dp = new Integer[10][totalSum + 1][n+1];

        int[] fac = new int[n + 1];
        fac[0] = 1;
        fac[1] = 1;

        for (int i = 2; i <= n; i++) {
            fac[i] = (int) ((1L * i * fac[i - 1]) % mod);
        }

        totalPermutation = (int) ((1L * fac[(n + 1) / 2] * fac[n / 2]) % mod);

        int[] fermetFac = new int[n + 1];
        Arrays.fill(fermetFac, 1);

        for (int i = 0; i <= n; i++) {
            fermetFac[i] = pow(fac[i], mod - 2);
        }

        int digit = 0;
        int currSum = 0;
        int evenDigit = 0;

        return solve(digit, currSum, evenDigit, freq, fermetFac);

    }
}