class Solution {
    Map<String, Integer> map;
    public int solve(int pos, int k, int goDown, int jump){
        if(pos >= k+2){
            return 0;
        }
        String key = "" + pos + ","  + goDown + "," + jump;
        if(map.containsKey(key))
            return map.get(key);
        int ans = 0;
        if(pos == k){
            ans += 1;
        }

        if(pos != 0 && goDown == 1){
            ans += solve(pos - 1, k, 0, jump);
        }

        ans += solve((1 << jump) + pos, k, 1, jump + 1);
        map.put(key, ans);
        return ans;
    }

    public int waysToReachStair(int k) {
        map = new HashMap<>();
        return solve(1, k, 1, 0);
    }
}