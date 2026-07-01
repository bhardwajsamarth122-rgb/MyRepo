class Solution {
    int n;
    Boolean[] dp;
    public boolean solve(int j, int[] nums){
        if(j >= n) return dp[j] = true;
        if(dp[j] != null) return dp[j];
        
            if(j+1 < n && nums[j] == nums[j+1]){
                if(solve(j+2, nums)){
                    return dp[j] = true;
                }
            }
            if(j+2 < n && ((nums[j] == nums[j+1] && nums[j+1] == nums[j+2]) || (nums[j+1] - nums[j] == 1 && nums[j+2] - nums[j + 1] == 1))){
                if(solve(j + 3, nums)){
                    return dp[j] = true;
                }
            }
        

        return dp[j] = false;
    }

    public boolean validPartition(int[] nums) {
        n = nums.length;
        dp = new Boolean[n+3];

        return solve(0, nums);
    }
}