class Solution {
    int mod = (int) 1e9 + 7;
    int[][] direction = new int[][] { { -1, 0 }, { 0, -1 }, { -1, -1 } };
    Map<String,int[]> map;

    public int[] solve(int i, int j, List<String> board) {
        if (i == 0 && j == 0) {
            return new int[] { 0, 1 };
        }
        if (i < 0 || j < 0) {
            return new int[] { 0, 0 };
        }
        if (board.get(i).charAt(j) == 'X') {
            return new int[] { 0, 0 };
        }
        String key = "" + i + "," + j;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int bestScore = Integer.MIN_VALUE;
        int bestPath = 0;

        for (int[] d : direction) {
            int x = i + d[0];
            int y = j + d[1];

            int[] combo = solve(x, y, board);

            if (combo[1] > 0) {
                int score = 0;
                if(board.get(i).charAt(j) != 'S' && board.get(i).charAt(j) != 'E'){
                    score = board.get(i).charAt(j) - '0';
                }
                score = score + combo[0];
                if (score > bestScore) {
                    bestScore = score;
                    bestPath = combo[1];
                }
                else if(score == bestScore){
                    bestPath = (bestPath + combo[1]) % mod;
                }
            }
        }

        if(bestPath == 0){
            map.put(key, new int[]{0, 0});
            return new int[]{0, 0};
        }
        map.put(key, new int[] { bestScore, bestPath });
        return new int[] { bestScore, bestPath };
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        map = new HashMap<>();
        return solve(n - 1, n - 1, board);
    }
}