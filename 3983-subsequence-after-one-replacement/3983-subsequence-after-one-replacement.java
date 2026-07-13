class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int m = t.length();
        int n = s.length();

        int[] pref = new int[n+1];
        int[] suf = new int[n+1];

        for(int i = 0; i <= n; i++){
            pref[i] = m + 1;
            suf[i] = -2;
        }
        pref[0] = -1;
        suf[n] = m;
        int i = 0; int j = 0;

        while( i < n && j < m ){
            if(s.charAt(i) == t.charAt(j)){
                pref[i+1] = j;
                i++;
            }
            j++;
        }

        i = n-1; j = m-1;

        while( i >= 0 && j >= 0 ){
            if(s.charAt(i) == t.charAt(j)){
                suf[i] = j;
                i--;
            }
            j--;
        }

        for(int idx = 0; idx < n; idx++){
            int left = pref[idx];
            int right = suf[idx+1];

            if(left != m+1 && right != -2 && (right - left ) >= 2){
                return true;
            }
        }

        return false;
    }
}