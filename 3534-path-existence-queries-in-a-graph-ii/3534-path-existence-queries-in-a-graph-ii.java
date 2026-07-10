class Solution {
    record pair(int val, int node){};
    int ro;
    int col;

    int[][] parent;

    public  int binary(pair[] arr, int target){
        int l = 0;
        int r = arr.length - 1;
        int ans = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(arr[mid].val() <= target){
                ans = mid;
                l = mid + 1;
            }
            else{
                r = mid -1;
            }
        }

        return ans;
    }

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        ro = n;
        col = (int) (Math.log(n)/Math.log(2)) + 1;
        parent = new int[ro][col];

        pair[] arr = new pair[n];

        for(int i = 0; i < n; i++){
            arr[i] = new pair(nums[i], i);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.val(), b.val()));

        int[] nodetoidx = new int[n];

        for(int i = 0; i < n; i++){
            int idx = arr[i].node();
            nodetoidx[idx] = i;
        }

        for(int node = 0; node < ro; node++){
            int farthest = binary(arr, arr[node].val() + maxDiff);
            parent[node][0] = farthest;
        }

        for(int j = 1; j < col; j++){
            for(int node = 0; node < ro; node++){ 
                parent[node][j]= parent[ parent[node][j-1] ][j-1];
            }
        }

        int[] ans = new int[queries.length];
        int i = 0;
        for(int[] q : queries){
            int u = q[0];
            int v = q[1];
            int a = nodetoidx[u];
            int b = nodetoidx[v];
            if(a == b){
    ans[i++] = 0;
    continue;
}
            if(a > b){
                int temp = a;
                a = b; 
                b = temp;
            }
            int curr = a;
            int jump = 0;
            for(int j = col - 1; j >= 0; j--){
                if(parent[curr][j] < b){
                    curr = parent[curr][j];
                    jump += (1 << j);
                }
            }

            if(parent[curr][0] >= b){
                ans[i++] = jump + 1;
                continue;
            }
            ans[i++] = -1;

        }

        return ans;
    }
}