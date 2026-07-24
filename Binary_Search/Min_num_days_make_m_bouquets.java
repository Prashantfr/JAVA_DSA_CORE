package Binary_Search;
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if((long) m*k>n) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i=0; i<bloomDay.length; i++){
           low = Math.min(low , bloomDay[i]);
           high = Math.max(high , bloomDay[i]);
        }

        int ans = -1;

        while (low <= high){
            int mid = low + (high-low)/2;

            if(possible(bloomDay,m,k,mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

        private boolean possible(int[] bloomDay, int m, int k , int day){
            int cnt = 0;
            int bouquets = 0;
            for(int i=0; i<bloomDay.length; i++){
                if(bloomDay[i]<=day){
                    cnt++;
                }
                else {
                    bouquets += (cnt/k);
                    cnt = 0;
                }
            }
        bouquets += (cnt/k);
        return bouquets >= m;
        
      }
}
