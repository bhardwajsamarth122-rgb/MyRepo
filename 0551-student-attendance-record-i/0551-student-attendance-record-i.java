class Solution {
    public boolean checkRecord(String s) {
        int late = 0;
        int abs = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char val = s.charAt(i);
            if(val == 'P'){
                late = 0;
            }
            else if(val == 'A'){
                late = 0;
                abs += 1;
            }
            else{
                late += 1;
            }
    
            if(late > 2 || abs > 1){
                return false;
            }
            
        }

        return true;
    }
}