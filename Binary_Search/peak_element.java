//brute force 
/*
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if (nums.length == 1 || nums[0]>nums[1]){        //for first element
            return 0;
        }

        for(int i=1; i<n-1; i++){                         //for middle elements
            if(nums[i-1]<nums[i] && nums[i]>nums[i+1]){
                return i;
            }
        }

        if(nums[n-1]>nums[n-2]){                         //for last element
            return n-1;
        }

        return -1;
    }
} */

//optimal solution

package Binary_Search;

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while (low<high){
            int mid = low + (high-low)/2;
             if(nums[mid]<nums[mid+1]){
                low = mid+1;
             }
             else{
                high = mid;
             }
        }
        return low;
    }
}