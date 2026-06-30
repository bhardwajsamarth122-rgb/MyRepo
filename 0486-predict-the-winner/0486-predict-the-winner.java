
class Solution {

    HashMap<String, Boolean> map = new HashMap<>();

    public boolean solve(int[] nums, int i, int j, int chance, int p1, int p2) {

        if (i > j) {
            return p1 >= p2;
        }

        String key = i + "#" + j + "#" + chance + "#" + p1 + "#" + p2;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        boolean check = false;

        if (chance == 0) {

            boolean left = solve(nums, i + 1, j, 1, p1 + nums[i], p2);
            boolean right = solve(nums, i, j - 1, 1, p1 + nums[j], p2);

            check = left || right;

        } else {

            boolean left = solve(nums, i + 1, j, 0, p1, p2 + nums[i]);
            boolean right = solve(nums, i, j - 1, 0, p1, p2 + nums[j]);

            check = left && right;
        }

        map.put(key, check);
        return check;
    }

    public boolean predictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1, 0, 0, 0);
    }
}