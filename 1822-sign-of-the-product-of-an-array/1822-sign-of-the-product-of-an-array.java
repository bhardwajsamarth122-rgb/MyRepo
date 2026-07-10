class Solution {
    public int arraySign(int[] nums) {
        int x = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                x = x * -1;
            }
            if (nums[i] == 0) {
                x = 0;
                return 0;
            }

        }

        return x;
    }
}