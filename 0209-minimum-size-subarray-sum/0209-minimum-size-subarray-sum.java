class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i = 0; int j = 0;
        int ans = Integer.MAX_VALUE;
        int n = nums.length;

        while(j < n){
            sum += nums[j];

            if(sum >= target){
                ans = Math.min(ans, j - i + 1);
                while(sum >= target){
                    sum -= nums[i];
                    i++;
                    if(sum >= target){
                        ans = Math.min(ans, j - i + 1);
                    }
                }
            }

            j++;
        }

        return (ans == Integer.MAX_VALUE) ? 0 : ans; 
    }
}