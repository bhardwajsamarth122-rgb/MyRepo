class Solution {

    public boolean solve(int[] nums, int i, int j, int chance, int p1, int p2){
        if(i > j){
            if(p1 >= p2){
                return true;
            }
            return false;
        }

        boolean check = false;
        if(chance == 0){
            boolean f1 = solve(nums, i + 1, j, 1 - chance, p1 + nums[i], p2);
            boolean f2 = solve(nums, i, j - 1, 1 - chance, p1 + nums[j], p2);

            if(f1 || f2){
                check = true;
            }
        }else{
            boolean f1 = solve(nums, i + 1, j, 1 - chance, p1, p2 + nums[i]);
            boolean f2 = solve(nums, i, j - 1, 1 - chance, p1, p2 + nums[j]);

            if(f1 && f2){
                check = true;
            }
        }

        return check;
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        return solve(nums, 0, n-1, 0, 0, 0);
    }
}