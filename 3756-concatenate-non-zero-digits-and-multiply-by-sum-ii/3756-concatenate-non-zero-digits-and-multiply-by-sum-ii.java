class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int mod = (int) 1e9 + 7;
        int n = s.length();
        int[] sum = new int[n];
        long[] digit = new long[n];  
        int[] pow10 = new int[n + 1];
        pow10[0] = 1;
        for(int i = 1; i<= n; i++){
            pow10[i] = (int)(((long)pow10[i-1] * 10) % mod);
        }  
        int[] count = new int[n];

        for(int i = 0; i < n; i++){
            int val = s.charAt(i) - '0';
            
            // Carry over previous values if not at the start
            if (i > 0) {
                sum[i] = sum[i - 1];
                digit[i] = digit[i - 1];
                count[i] = count[i - 1];
            }
            
            // Process the current digit if it's non-zero
            if (val != 0) {
                sum[i] += val;
                digit[i] = (digit[i] * 10 + val) % mod; // Apply mod at every step
                count[i]++;
            }
        }

        int[] answer = new int[queries.length];
        int j = 0;

        for(int[] q : queries){
            int l = q[0];
            int r = q[1];

            int total = (l != 0) ? sum[r] - sum[l-1] : sum[r];
            long x = digit[r];
            if(l != 0){
               int nonZerosInRange = count[r] - count[l - 1];
                
                // Shift the left prefix by the number of non-zeros, apply modulo
                long leftPart = (digit[l - 1] * pow10[nonZerosInRange]) % mod;
                
                // Subtract left part from the total prefix (add mod before modulo to handle negatives)
                x = (x - leftPart + mod) % mod;
            
            }
            
            long ans = ((long) x * total) % mod;
            answer[j++] =  (int)ans;
        }

        return answer;
    }
}