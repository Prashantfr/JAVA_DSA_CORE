//brute force 
/*
class Solution {
    public boolean isPerfectSquare(int num) {
        boolean ans = false;
        for(int i=0; i<=num; i++){
            if(i*i== num){
                ans = true;
                break;
            }
        }
        return ans;
    }
}
 */
//general binary search algorithm
//using the long to avoid overflow

package Binary_Search;

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num<1) return false;
        long low = 1;
        long high = num;
        
        while(low<=high){
            long mid = low + (high-low)/2;
            long sqr = mid*mid;

            if(sqr==num){
                return true;
            }
            else if(sqr < num){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return false;
    }
}
