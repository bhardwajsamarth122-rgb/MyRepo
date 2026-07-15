class Solution {

    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 1;
        int sumEve = 2;
        if(n == 1) return gcd(sumEve, sumOdd);
        int a = 2;
        int b = 1;
        for(int i = 1; i < n; i++){
            a = (a + 2);
            sumEve += a;
            b =(b + 2);
            sumOdd += b;
        }

        return gcd(sumEve, sumOdd);
    }
}