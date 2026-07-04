class Solution {
    int ans;
    boolean[] visited;
    Map<Integer, List<pair>> adj;
    static class pair{
        int to;
        int dist;
        public  pair(int to, int dist){
            this.to = to;
            this.dist = dist;
        }
    }

    public void dfs(int node){
        visited[node] = true;
        for(pair val : adj.get(node)){
            ans = Math.min(ans, val.dist);
            if(adj.containsKey(val.to) && !visited[val.to]){
                 dfs(val.to);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        adj = new HashMap<>();

        for(int arr[] : roads){
            adj.computeIfAbsent(arr[0], k -> new ArrayList<>()).add(new pair(arr[1], arr[2]));
            adj.computeIfAbsent(arr[1], k -> new ArrayList<>()).add(new pair(arr[0], arr[2]));
        }

        ans = Integer.MAX_VALUE;
        visited = new boolean[n+1];
        dfs(1);

        return ans;

    }
}