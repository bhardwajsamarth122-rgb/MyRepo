class Solution {
    int n;
    Set<String> set;
    Integer[] dp;

    public int solve(int st, StringBuilder s){
        if(st >= n){
            return 0;
        }
        if(dp[st] != null) return dp[st];

        int ans = Integer.MAX_VALUE;
        for(int j = st; j < n; j++){
            String temp  = s.substring(st, j+1);
            if(set.contains(temp)){
                ans = Math.min(ans, solve(j + 1,  s));
            }
            else{
                ans = Math.min(ans, temp.length() + solve(j + 1, s));
            }
        }

        return dp[st] = ans;
    }

    public int minExtraChar(String s, String[] dictionary) {
        set = new HashSet<>();
        n = s.length();
        dp = new Integer[n];
        for(String str : dictionary){
            set.add(str);
        }
        StringBuilder str = new StringBuilder(s);
        return solve(0,  str);
    }
}