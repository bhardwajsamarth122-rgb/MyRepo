class Solution {
    int n;
    Set<String> set;
    Boolean dp[];
    public boolean help(int i, String s){
        if(i >= n) return true;
        if(dp[i] != null) return dp[i];
        for(int j = i; j < n; j++){
            if(set.contains(s.substring(i,j+1))){
                if(help(j+1, s)){
                    return dp[i] = true;
                }
                
            }
        }

        return dp[i] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        set = new HashSet<>();
        for(String i  : wordDict){
            set.add(i);
        }
        dp = new Boolean[n];
        return  help(0, s);
    }
}