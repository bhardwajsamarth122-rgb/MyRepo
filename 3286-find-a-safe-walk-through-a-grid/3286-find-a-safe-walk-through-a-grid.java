class Solution {
    record Pair(int i, int j, int h) {
    };

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] best = new int[m][n];
        for (int[] row : best) {
            Arrays.fill(row, -1);
        }

        if (grid.get(0).get(0) == 1 && health - 1 <= 0) {
            return false;
        }

        if (grid.get(0).get(0) == 1)
            health--;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, health));
        best[0][0] = health;

        int[][] direction = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair p = q.poll();
                int i = p.i;
                int j = p.j;
                int h = p.h;

                if (i == m - 1 && j == n - 1) {
                    return true;
                }

                for (int[] d : direction) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x < 0 || y < 0 || x >= m || y >= n) {
                        continue;
                    }

                    int newHealth = h - grid.get(x).get(y);

                    if (newHealth <= 0) {
                        continue;
                    }

                    if (newHealth > best[x][y]) {
                        best[x][y] = newHealth;
                        q.offer(new Pair(x, y, newHealth));
                    }
                }
            }
        }

        return false;
    }
}