class Solution {
    public int minimumCost(int[] nums, int k) {
        int mod = (int) 1e9 + 7;
        
        long ans = 0;
        long operation = 0;
        long resources = k;
        

        for(int val : nums){
            if(resources < val){
                long need = ((long)val - resources + k - 1) / k;
                
                long first = operation + 1;
                long last = operation + need;
                long a = first + last;
                long b = need;

                if(a % 2 == 0){
                    a /= 2;
                }else{
                    b/=2;
                }

                long cost = ( (a % mod) * (b % mod))  % mod;
                ans = (ans + cost) %  mod;

                operation += need;
                resources += need * k;
            }
            resources -= val;
        }

        return (int)ans;
    }
}