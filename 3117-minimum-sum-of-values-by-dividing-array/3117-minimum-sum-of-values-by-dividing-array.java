class Solution {
    int n;
    int m;
    HashMap<String, Integer> dp = new HashMap<>();

    public int solve(int[] nums, int[] andValues, int i, int j, int andOp){
        if(i >= n){
            if(j >= m) return 0;
            return (int) 1e9;
        }
        if(j >= m){
            return (int) 1e9;
        }
        String key = i + "," + j + "," + andOp;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int including_i = (int) 1e9;
        if((andOp & nums[i]) == andValues[j]){
            including_i = solve(nums, andValues, i+1, j+1, (1 << 18) - 1) + nums[i];
        }
        int excluding_i = solve(nums, andValues, i+1, j, andOp & nums[i]);

        int ans = Math.min(including_i, excluding_i);

        
        dp.put(key, ans);
        return ans;
    }

    public int minimumValueSum(int[] nums, int[] andValues) {
        n = nums.length;
        m = andValues.length;
        int max = Arrays.stream(andValues).max().getAsInt();
        int ans = solve(nums, andValues, 0, 0, (1 << 18) - 1);
        if(ans >= (int) 1e9){
            return -1;
        }
        return ans;
    }
}