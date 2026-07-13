class Solution {

    public int giveRange(int num) {
        if (num == 0) return 0;
        
        int maxDigit = 0;
        int minDigit = 9;

        num = Math.abs(num);

        while (num > 0) {
            int digit = num % 10;
            if (digit > maxDigit) {
                maxDigit = digit;
            }
            if (digit < minDigit) {
                minDigit = digit;
            }
            num = num / 10;
        }

        return maxDigit - minDigit;
    }
    
    public int maxDigitRange(int[] nums) {
        int maxRange = -1;
        int sum = 0;

        for (int num : nums) {
            int range = giveRange(num);
            
            if (range > maxRange) {
                maxRange = range;
                sum = num;
            } 
            else if (range == maxRange) {
                sum += num;
            }
        }
        
        return sum;
    }
}