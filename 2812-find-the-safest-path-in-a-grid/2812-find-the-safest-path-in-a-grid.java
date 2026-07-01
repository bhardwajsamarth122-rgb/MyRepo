class Solution {
    int n;
    // FIX: Initialize the static array here once, not inside the pair constructor
    static int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    static class pair {
        int row;
        int col;

        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();

        int[][] dist = new int[n][n];
        for(int i = 0;i < n;i++) {Arrays.fill(dist[i], -1);}
        boolean[][] visited = new boolean[n][n];

        Queue<pair> q = new LinkedList<>();
        // BFS to fill the dist array with the minimum distances from the thiefs

        for(int i = 0; i < n; i++){
            for(int j = 0;  j < n ;j++){
                if(grid.get(i).get(j) == 1){
                    q.add(new pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- != 0){
                pair p = q.remove();
                int curr_i = p.row;
                int curr_j = p.col;
                dist[curr_i][curr_j] = level;

                for(int[] dir : direction){
                    int new_i = dir[0] + curr_i;
                    int new_j = dir[1] + curr_j;

                    // FIX: Check visited[new_i][new_j], NOT visited[curr_i][curr_j]
                    if(new_i < 0 || new_i >= n || new_j < 0 || new_j >= n || visited[new_i][new_j]){
                        continue;
                    }
                    q.add(new pair(new_i, new_j));
                    // FIX: Mark the new cell as visited
                    visited[new_i][new_j] = true;
                }
            }
            level++;
        }

        int l = 0;
        int r = n * 2; // FIX: Max possible distance is bounded by grid dimensions
        int res = 0;

        while(l <= r){
            int mid = l + (r - l)/2;
            if(check(dist, mid)){
                res = mid;
                // FIX: Update l to mid + 1 (standard binary search step)
                l = mid + 1;
            } else r = mid - 1;
        }

        return res;
    }

    private boolean check(int[][] dist, int mid) {
        // FIX: If the starting point is already less than mid, path is impossible
        if (dist[0][0] < mid) return false;

        boolean[][] visited = new boolean[n][n];
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            pair p = q.remove();
            int curr_i = p.row;
            int curr_j = p.col;

            if (curr_i == n - 1 && curr_j == n - 1)
                return true;

            for (int[] dir : direction) {
                int new_i = curr_i + dir[0];
                int new_j = curr_j + dir[1];

                // FIX: Check !visited[new_i][new_j], NOT !visited[curr_i][curr_j]
                if (new_i >= 0 && new_i < n && new_j >= 0 && new_j < n && !visited[new_i][new_j]) {
                    if (dist[new_i][new_j] < mid)
                        continue;
                    q.add(new pair(new_i, new_j));
                    visited[new_i][new_j] = true;
                }
            }
        }
        return false;
    }
}