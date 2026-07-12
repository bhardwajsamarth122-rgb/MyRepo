class Solution {

    public int chheckHamming(String s1, String s2){
        int ans  = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                ans+= 1;
            }
        }
        return ans;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int longest = 1;
        int longIdx = 0;

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < i; j++){
                if(groups[i] != groups[j] && words[i].length() == words[j].length() && chheckHamming(words[j], words[i]) == 1){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        parent[i] = j;

                        if(longest < dp[i]){
                            longest = dp[i];
                            longIdx =  i;
                        }
                    }
                }
            }
        }

        List<String> res = new ArrayList<>();
        while(longIdx != -1){
            res.add(words[longIdx]);
            longIdx = parent[longIdx];
        }
        Collections.reverse(res);

        return res;
    }
}