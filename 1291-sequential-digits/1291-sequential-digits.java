class Solution {

    public int count(int n){
        int ans = 0;
        while( n > 0){
            n /= 10;
            ans++;
        }
        return ans;
    }

    public int find(int low, List<Integer> list){
        int l = 0;
        int r = list.size() - 1;
        int ans = -1;

        while( l <= r){
            int mid = l + (r - l) / 2;
            if(list.get(mid) >= low){
                ans = mid;
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }

        return ans;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> lst = new ArrayList<>();
        int n = 12;
        long mask = 11;
        int num = n;

        while(num <= (int) 1e9){
            lst.add(num);
            if(num % 10 == 9){
                int cnt = count(num);
                num = n * 10 + (cnt + 1);
                n = num;
                mask = mask * 10 + 1;
            }else{
                num += mask;
            }
        }

        int idx = find(low, lst);
        if (idx == -1) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        for(int i = idx; i < lst.size(); i++){
            if(lst.get(i) <= high){
                result.add(lst.get(i));
            }
        }

        return result;

    }
}