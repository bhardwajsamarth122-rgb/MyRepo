class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
        Set<Character> set = new HashSet<>();
        int[] freq = new int[26];
        Arrays.fill(freq, Integer.MIN_VALUE);

        for (int i = 0; i < pat.length(); i++) {
            char ch = pat.charAt(i);
            set.add(ch);
            if (freq[ch - 'a'] == Integer.MIN_VALUE) {
                freq[ch - 'a'] = 0;
            }
            freq[ch - 'a']++;
        }

        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (j < txt.length()) {
            char ch = txt.charAt(j);

            if (set.contains(ch)) {
                freq[ch - 'a']--;
            }

            if (j - i + 1 == pat.length()) {
                boolean flag = true;

                for (int a = 0; a < 26; a++) {
                    if (freq[a] == Integer.MIN_VALUE)
                        continue;
                    if (freq[a] != 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag)
                    ans.add(i);

                if (set.contains(txt.charAt(i))) {
                    freq[txt.charAt(i) - 'a']++;
                }

                i++;
            }
            j++;
        }

        return ans;
    }
}