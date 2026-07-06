class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return 1;
        Arrays.sort(intervals, (a, b) ->  {
            if(a[0] == b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int i = 0;
        int j = 1;
        int cnt = 0;
        while(j < n){
            if(intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][1]){
                cnt++;
                j++;
            }
            else{
                i = j;
                j = j+1;
            }
        }

        return n - cnt;
    }
}