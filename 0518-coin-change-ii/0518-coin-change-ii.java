class Solution {
    int n;
    Map<String, Integer> map;
    public int solve(int i, int sum, int amount, int[] coins){
        if(sum == amount){
            return 1;
        }     
        if(sum > amount){
            return 0;
        }
        
        if(i == n){
            return 0;
        }
        String key = "" + i + "," + sum;

        if(map.containsKey(key)){
            return map.get(key);
        }
        
        
        int take = solve(i, sum + coins[i], amount, coins);
        int skip = solve(i + 1, sum, amount, coins);
        map.put(key, take + skip);
        return take + skip;
    }

    public int change(int amount, int[] coins) {
        n = coins.length;
        map = new HashMap<>();
        return solve(0, 0, amount, coins);
    }
}