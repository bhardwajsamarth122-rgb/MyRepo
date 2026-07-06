class Solution {
    String s;

    public int check(int i, int j, int n){
        int count = 0;
        while(i >= 0 && j < n && (s.charAt(i) == s.charAt(j))){
            count++;
            i--;
            j++;
        }

        return count;
    }

    public int countSubstrings(String str) {
        s = "" + str;
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += check(i, i, n);
            ans += check(i, i + 1, n);
        }

        return ans;
    }
}