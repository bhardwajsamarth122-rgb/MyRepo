class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minIdx = -1;
        int maxIdx = -1;
        int culprit = -1;
        int n = nums.length;

        long ans = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == minK){
                minIdx = i;
            }
            if(nums[i] == maxK){
                maxIdx = i;
            }
            if(nums[i] > maxK || nums[i] < minK){
                culprit = i;
            }

            int temp = Math.min(minIdx, maxIdx);
            int val = temp - culprit;
            ans += (val < 0) ? 0 : val;
        }

        return ans;
    }
}