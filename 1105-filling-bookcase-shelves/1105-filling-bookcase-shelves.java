class Solution {
    int n;
    int sw;
    Integer dp[][];
    public int solve(int i, int width, int height,int[][] books){
        if(i == n){
            return height;
        }
        if(dp[i][width]!= null) return dp[i][width];

        int same = Integer.MAX_VALUE;
        if(books[i][0] + width <= sw){
            same = solve(i+1, books[i][0] + width, Math.max(height, books[i][1]), books);
        }
        int next = height + solve(i+1, books[i][0], books[i][1], books);

        int ans = Math.min(next, same);
        dp[i][width] = ans;
        return ans;
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        n = books.length;
        sw = shelfWidth;
        dp = new Integer[n+1][1001];
        return solve(0, 0, 0, books);
    }
}