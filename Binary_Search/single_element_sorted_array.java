//brute approach
//any element which doesnot appear twice is the single element

/* 
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length-1;
        for(int i=0; i<n ; i+=2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[n-1];
    }
}
*/

//optimal solution
//if the mid element is on the even index and the next odd index also contains that the same element , then the single element is on the right side (low = mid+2)
// and if they are not same which means the single element is on the left side (high=mid)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = nums.length-1;

        while(low < high){
            int mid = low + (high-low)/2;

            if(mid%2==1){
                mid--;
            }

            if(nums[mid] == nums[mid+1]){
                low = mid+2;
            }

            else{
                high = mid;
            }
        }
        return nums[low];
    }
}