class Solution {
    List<List<Integer>> adj;
    Integer[][] dp;

    public int solve(int node, int prnt, int div, int k, int[] coins){
        div = Math.min(div, 14);
        if(dp[node][div] != null) return dp[node][div];
       

        int ans = 0;
        int way1 = (coins[node] /(1 << div)) - k;
        int way2 = coins[node] / ((1 << div) * 2);
        int temp1 =  way1 ;
        int temp2 = way2 ;
        for(int child : adj.get(node)){
            if(child != prnt){
                 temp1 += solve(child, node, div, k, coins);
                temp2 += solve(child, node, div + 1, k, coins);
            }
        }

       ans = Math.max(temp1, temp2);
        
        return dp[node][div] = ans;
    }

    public int maximumPoints(int[][] edges, int[] coins, int k) {
        int n = coins.length;
        adj = new ArrayList<>();
        dp = new Integer[n+1][15];
        for(int i = 0; i <n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[]  e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        return solve(0, -1, 0, k, coins);
    }
}