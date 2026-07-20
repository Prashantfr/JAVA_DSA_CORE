package Binary_Search;

class Solution {
    public int countOccurrences(int[] arr, int target) {

        int lb = lowerbound(arr, target);
        int ub = upperbound(arr, target);
        int count = ub - lb;
        return count;

    }

        private int lowerbound(int nums[], int x){
            int low = 0;
            int high = nums.length-1;
            int ans = nums.length;

            while(low <= high){
                int mid = low + (high-low)/2;
                if(nums[mid] >= x){
                    ans = mid;
                    high = mid-1;
                } 
                else {
                    low = mid + 1;
                }          
             }
             return ans;
        }

    public int upperbound(int nums[], int x){
        int low = 0;
        int high = nums.length-1;
        int ans = nums.length;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] > x){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}

//brute force 
/*class solution{
public int count_occurance(int nums[] , int target){
int count = 0;
for(int i=0; i<nums.length; i++){
    if(nums[i]==target){
        count++;
    }
  }
  return count;
 }
}*/