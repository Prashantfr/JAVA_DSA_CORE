package Binary_Search;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for(int pile:piles){
            high = Math.max(high,pile);
        }

        while (low < high){
            int mid = low + (high-low)/2;
            int totalhours = 0;

            for(int pile:piles){
                totalhours += (pile+mid-1) / mid;
            }

            if(totalhours>h){
                low = mid+1;
            }

            else {
                high = mid;
            }
        }
        return low;
    }
}
