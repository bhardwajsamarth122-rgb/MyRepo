class Solution {

    Integer[][][] dp;

    public boolean isPrime(int n){
        if(n == 2) return  true;
        if(n % 2 == 0) return false;

        for(int i = 3; i*i <= n; i+=2){
            if(n % i == 0) return false;
        }
        return true;
    }

    public int solve(int a, int paste, int copy, int  n){
        if(a == n) return 0;

         if (a > n) return (int) 1e9;

        if(dp[a][paste][copy] != null) return dp[a][paste][copy];

        int p = (int) 1e9;
        int c = (int) 1e9;

        if(paste > 0){
            int cp = copy;
            if(copy == 0) cp = copy + 1;
            p = 1 + solve(a+paste, paste, cp, n);
        }

        if(copy == 1){
            c = 1 + solve(a, a, 0, n);
        }

        return dp[a][paste][copy] = Math.min(p, c);
    }

    public int minSteps(int n) {
        if(n == 1) return 0;
        if(isPrime(n)) return n;
        dp = new Integer[n][n  +1][2];
        return solve(1, 0, 1, n);
    }
}