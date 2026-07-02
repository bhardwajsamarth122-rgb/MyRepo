class Solution {
    int n;
    HashMap<String, Boolean> dp;

    public boolean solve(long jump, HashMap<Long, Integer> map, int idx, int[] arr, int str){
        if(idx == n-1){
            return true;
        }
        if(idx >= n){
            return false;
        }
        String key = "" + jump + "," + idx + "," + str;

        if(dp.containsKey(key)){
            return dp.get(key);
        }

        if(str - 1 > 0){
            int new_str = str - 1;
            long newjump = jump + new_str;
            int i = map.getOrDefault(newjump, -1);
            if(i != -1){
                if(solve(newjump, map, i, arr, new_str)){
                    dp.put(key, true);
                    return true;
                }
            }
        }
        if(str > 0){
            int new_str = str;
            long newjump = jump + new_str;
            int i = map.getOrDefault(newjump, -1);
            if(i != -1){
                if(solve(newjump, map, i, arr, new_str)){
                    dp.put(key, true);
                    return true;
                }
            }
        }
        if(str + 1 > 0){
            int new_str = str +1;
            long newjump = jump + new_str;
            int i = map.getOrDefault(newjump, -1);
            if(i != -1){
                if(solve(newjump, map, i, arr, new_str)){
                    dp.put(key, true);
                    return true;
                }
            }
        }
        dp.put(key, false);
        return false;
    }

    public boolean canCross(int[] arr) {
        if (arr[1] != 1) return false;

        n = arr.length;
        HashMap<Long, Integer> map = new HashMap<>();
        dp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put((long)arr[i], i);
        }
        return solve(arr[1], map, 1, arr, 1);
    }
}