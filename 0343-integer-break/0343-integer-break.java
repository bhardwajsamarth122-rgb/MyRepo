class Solution {
    Map<Integer, Integer> map;

    public int solve(int n){
        if(n == 1){
            return 1;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int result = n-1;

        for(int i = 1; i <= n-1; i++){
            int prod = i * (Math.max(n-i, solve(n-i)));
            result = Math.max(result, prod);
        }
        map.put(n, result);
        return result;
    }

    public int integerBreak(int n) {
        map = new HashMap<>();
        return solve(n);
    }
}