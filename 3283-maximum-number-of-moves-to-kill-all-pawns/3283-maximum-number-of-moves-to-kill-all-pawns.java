class Solution {
    int[][] minDist;
    int[][] pos;
    Integer[][][] dp;

    record pair(int x, int y){};

    public void bfs(int x, int y, int index){
        int[][] dist = new int[50][50];
        for(int i = 0; i < 50; i++){
            Arrays.fill(dist[i], -1);
        }

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(x, y));
        dist[x][y] = 0;

        int[][] distance = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {2, -1}, {2, 1}, {1, -2}, {1, 2}};

        while(!q.isEmpty()){
            pair p = q.poll();
            int i = p.x();
            int j = p.y();

            for(int[] d  : distance){
                int new_i = i + d[0];
                int new_j = j + d[1];
                if(new_i >= 0 && new_j >= 0 & new_i < 50 && new_j < 50 && dist[new_i][new_j] == -1){
                    dist[new_i][new_j] = 1 + dist[i][j];
                    q.add(new pair(new_i, new_j));
                }
            }
        }

        for(int i = 0; i < pos.length; i++){
            minDist[index][i] = dist[ pos[i][0] ][ pos[i][1] ];
        }
    }

    public int solve(int index, int mask, int alice){
        if(mask == 0)  return 0;
        if(dp[index][mask][alice] != null) return dp[index][mask][alice];

        int res = (alice == 1) ? -1 : (int) 1e10;

        for(int i = 1; i < pos.length; i++){

            if((mask & (1 << i-1)) > 0){
                int mark = minDist[index][i];
                if(alice == 1){
                    res = Math.max(res, mark + solve(i, mask ^ (1 << i-1), 0));
                }else{
                    res = Math.min(res, mark + solve(i, mask ^ (1 << i-1), 1));
                }
            }

        }

        return dp[index][mask][alice] = res;
    }

    public int maxMoves(int kx, int ky, int[][] positions) {
        pos = new int[positions.length + 1][2];
        pos[0][0] = kx;
        pos[0][1] = ky;
        int n = pos.length;

        dp = new Integer[n+1][(1 << n - 1)][2];

        for (int i = 1; i < pos.length; i++) {
            pos[i][0] = positions[i - 1][0];
            pos[i][1] = positions[i - 1][1];
        }

        minDist = new int[pos.length][pos.length];

        for (int i = 0; i < pos.length; i++) {
            int x = pos[i][0];
            int y = pos[i][1];
            bfs(x, y, i);
        }

        return solve(0, (1 << n - 1) - 1, 1);
    }
}