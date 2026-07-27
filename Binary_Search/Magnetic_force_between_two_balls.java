package Binary_Search;
import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length-1] - position[0];
        int ans = 0;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(CanWePlace(position,m,mid)){
                ans = mid;
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return ans;
    }

    private boolean CanWePlace(int[] basket, int m, int force){
        int count = 1;
        int last = basket[0];
        for(int i=0; i<basket.length; i++){
            if(basket[i]-last>= force){
            count++;
            last = basket[i];
        }
        }
        return count>=m;   
    }
}
