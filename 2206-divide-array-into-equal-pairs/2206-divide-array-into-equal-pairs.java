class Solution {
    public boolean divideArray(int[] nums) {
        int[] count = new int[501];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            count[nums[i]]++;
        }

        int pair = nums.length/2;

        int ans = 0;
        for(int i = 0; i < 501; i++){
             ans += count[i] / 2;
        }

        return (ans == pair);
    }
}