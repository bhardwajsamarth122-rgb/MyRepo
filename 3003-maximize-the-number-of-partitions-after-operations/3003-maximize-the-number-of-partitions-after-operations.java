class Solution {
    int n;
    String s;
    Map<String, Integer> map;
    public int solve(int i, int mask, boolean canChange, int k){
        if(i >= n)  return 0;
        String key = "" + i + ","  + mask + "," + canChange;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int idx = s.charAt(i) - 'a';
        int updatedUniqueChar = (mask | (1 << idx));
        int uniqueCount = Integer.bitCount(updatedUniqueChar);
        int result = 0;
        if(uniqueCount > k){
            result = 1 + solve(i+1, 1 << idx, canChange, k);
        }else{
            result = solve(i+1, updatedUniqueChar, canChange, k);
        }

        if(canChange){
            for(int j = 0; j < 26; j++){
                int changeUpdatedUniqueChar = (mask | (1 << j));
                int changeUniqueCount = Integer.bitCount(changeUpdatedUniqueChar);

                if(changeUniqueCount > k){
                    result = Math.max(result, 1 + solve(i+1, 1 << j, false, k));
                }else{
                    result = Math.max(result, solve(i+1, changeUpdatedUniqueChar, false, k));
                }
            }
        }
        map.put(key, result);
        return result;
    }

    public int maxPartitionsAfterOperations(String str, int k) {
        s = "" + str;
        n = s.length();
        map = new HashMap<>();
        return 1 + solve(0, 0, true, k);
    }
}