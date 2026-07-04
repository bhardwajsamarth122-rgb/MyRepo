class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }

        int ans = -1;
        for(int value : set){
            ans = value;
        }

        return ans;
    }
}