class Solution {
    record pair(int val, int idx) {
    };

    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        PriorityQueue<pair> q = new PriorityQueue<>((a, b) -> Integer.compare(b.val(), a.val()));
        q.add(new pair(dp[0], 0));

        int res = dp[0];

        for (int i = 1; i < n; i++) {

            while (!q.isEmpty() && i - q.peek().idx() > k) {
                q.poll();
            }

            if (q.isEmpty()) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(nums[i], nums[i] + q.peek().val());
            }

            res = Math.max(res, dp[i]);
            q.offer(new pair(dp[i], i));
        }

        return res;
    }
}