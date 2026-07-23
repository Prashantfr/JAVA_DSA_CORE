//brute force 
/*
class Solution {
    public int mySqrt(int x) {
        int ans = 0;
        for(int i=0; i<=x; i++){
            if(i*i <= x){
                ans = i;
            }
            else {
                break;
            }
        }
        return ans;
    }
} */

//optimal solution


package Binary_Search;

class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1){
            return x;
        }

        int low = 1;
        int high = x;
        int ans = 0;

        while(low <= high){
            int mid = low + (high-low)/2;

            if((long)mid*mid <= x){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}