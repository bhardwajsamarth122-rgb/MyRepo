class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = new int[arr.length];
        int idx = 0;
        for(int val : arr){
            temp[idx++] = val;
        }
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int val : temp){
          if (!map.containsKey(val)) {
        map.put(val, rank++);
    }
        }

        int[] ans = new int[arr.length];
        int id = 0;
        for(int val : arr){
            ans[id++] = map.get(val);
        }

        return ans;
    }
}