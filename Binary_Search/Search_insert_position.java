//it follows the same concept as the lower bound
// and if the target is not found in the array , it returns the index where it should be inserted i.e. the index where the very first element which is greater than the mid element is stored.


package Binary_Search;

class Solution{
    public int Search_insert_position(int[] arr, int x) {
    int low = 0, high = arr.length - 1;
    int ans = arr.length;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] >= x) {
            ans = mid;
            high = mid - 1; // go left
        } else {
            low = mid + 1;
        }
    }
    return ans;
   }
}
//brute force
/*class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length ; i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return nums.length;
    }
}*/