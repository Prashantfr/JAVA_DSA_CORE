package Binary_Search;

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = lowerbound(nums, target);

        if( first == nums.length || nums[first] != target){
            return new int[]{-1,-1};
        }

        int last = upperbound(nums, target) - 1;

        return new int[]{first,last};

    }

        private int lowerbound(int[] nums, int target){
            int low = 0;
            int high = nums.length-1;
            int ans = nums.length;

            while(low <= high){
                int mid = low + (high-low)/2;

                if(nums[mid] >= target){
                    ans = mid;
                    high = mid-1; //go left
                }
                else{
                    low = mid + 1;
                }
            }
            return ans;
        }

        private int upperbound(int[] nums, int target ){
            int low = 0;
            int high = nums.length-1;
            int ans = nums.length;

            while(low <= high){
                int mid = low + (high-low)/2;

                if(nums[mid] > target){
                    ans = mid;
                    high = mid-1;
                }
                else {
                    low = mid + 1;
                }
            }
            return ans;
        }
}


//brute force
/*class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        for(int i=0; i<nums.length; i++){
            if (nums[i] == target){
            if(first == -1){
                first = i;
            }
            last = i;
           }
        }
        return new int[]{first,last};
    }
} */