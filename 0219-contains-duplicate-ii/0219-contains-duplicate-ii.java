class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int i = 0; int j = 0;

        while(j < n){
            

            if(Math.abs(i - j) <= k){
                if(set.add(nums[j]) == false) return true;
            }else{
                set.remove(nums[i]);
                i++;
                if(set.add(nums[j]) == false) return true;
            }
            j++;
        }

        return false;

    }
}