class Solution {
    int n;
    int sw;
    Map<String, Integer> map;
    public int solve(int i, int width, int height,int[][] books){
        if(i == n){
            return height;
        }
        String key = "" + i + "," + width + "," + height;
        if(map.containsKey(key)) return map.get(key);
        int same = Integer.MAX_VALUE;
        if(books[i][0] + width <= sw){
            same = solve(i+1, books[i][0] + width, Math.max(height, books[i][1]), books);
        }
        int next = height + solve(i+1, books[i][0], books[i][1], books);
        int ans = Math.min(next, same);
        map.put(key, ans);
        return ans;
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        n = books.length;
        sw = shelfWidth;
        map = new HashMap<>();
        return solve(0, 0, 0, books);
    }
}