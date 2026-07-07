class Solution {

    public long reverse(long n){
        long x = 0;
        while(n > 0){
            long temp = n % 10;
            if(temp != 0){
                x = x*10 + temp;
                
            }
            n /= 10;
        }
        return x;
}


    public long sumAndMultiply(int n) {
        long x = 0;
        int sum = 0;
        while(n > 0){
            long temp = n % 10;
            if(temp != 0){
                x = x*10 + temp;
                sum += temp;
            }
            n /= 10;
        }
        x = reverse(x);
        long ans = x * sum;
        return ans;
    }
}