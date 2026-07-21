//brute force
/*class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for(int i=0; i<nums.length; i++){
            if(nums[i]<min){
                min = nums[i];
            }
        }
        return min;
    }
}
 */


package Binary_Search;

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low < high){
            int mid = low + (high-low)/2;

            if( nums[mid] > nums[high]  ){
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        return nums[low];
    }
}
