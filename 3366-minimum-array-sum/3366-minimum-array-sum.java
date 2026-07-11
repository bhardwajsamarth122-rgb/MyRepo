class Solution {
    int n;
    Integer[][][] dp;
    public int solve(int i, int[] nums, int op1, int op2, int k){
        if(i == n){
            return 0;
        }

        if(dp[i][op1][op2] != null) return dp[i][op1][op2];

        int res1 = (int) 1e9;
        int res2 = (int) 1e9;
        int res3 = (int) 1e9;
        int res  = (int) 1e9;

        if(op1 > 0){
            int val = (nums[i] % 2 == 0) ? nums[i] : nums[i] + 1;
            val /= 2;
            res1 = val + solve(i + 1, nums, op1 - 1, op2, k);
        }

        if(op2 > 0 && nums[i] >= k){
            res2 = nums[i] - k + solve(i+1, nums, op1, op2 - 1, k);
        }

        if(op1 > 0 && op2 > 0){
            int val1 = (nums[i] % 2 == 0) ? nums[i] : nums[i] + 1;
            val1 /= 2;
            if(val1 >= k){
                res3 = val1 - k + solve(i+1, nums, op1 - 1, op2 - 1, k);
            }

            if(nums[i] >= k){
                int val2 = nums[i] - k;
                val2 = (val2 + 1) / 2;
                res3 = Math.min(res3, val2 + solve(i+1, nums, op1 - 1, op2 - 1, k));
            }
        }

        res = nums[i] + solve(i+1, nums, op1, op2, k);

        return dp[i][op1][op2] = Math.min( Math.min(res1, res2), Math.min(res3, res) );
    }

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        n = nums.length;
        dp = new Integer[n+1][op1 + 1][op2 + 1];
        return solve(0, nums, op1, op2, k);
    }
}