class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        for(char ch : new char[]{'a', 'e', 'i', 'o', 'u'}){
            set.add(ch);
        }

        int ans = 0;

        for(int i = 0; i < k; i++){
            char ch = s.charAt(i);
            if( set.contains(ch) ){
                ans++;
            }
        }
        int curr = ans;
        int idx = 0;

        for(int i = k; i < n; i++){
            if(set.contains(s.charAt(idx))){
                ans--;
            }
            idx++;
            if(set.contains(s.charAt(i))){
                ans++;
            }
            curr = Math.max(curr, ans);
        }

        return curr;
    }
}