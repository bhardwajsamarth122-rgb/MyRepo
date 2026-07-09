class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
       
        Integer[] parent = new Integer[n];

        parent[0] = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i-1] <= maxDiff){
                parent[i] = parent[i-1];
                continue;
            }
            parent[i] = i;
        }

        boolean[] ans = new boolean[queries.length];
        int i = 0;
        for(int[] q : queries){
            int u = q[0];
            int v = q[1];
            if(parent[u] == parent[v]){
                ans[i]  = true;
            }
            i++;
        }

        return ans;
    }
}