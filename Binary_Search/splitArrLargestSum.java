package Binary_Search;

class Solution {
    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        for(int i=0; i<nums.length; i++){
            low = Math.max(nums[i],low);
            high += nums[i];
        }

        int ans = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isPossible(nums,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }
     

        private boolean isPossible(int[] nums, int k, int maxSum){
            int subArrays = 1;
            int sum = 0;

            for(int i=0; i<nums.length; i++){
                if( sum + nums[i] <= maxSum){
                    sum += nums[i];
                }
                else{
                    subArrays++;
                    sum = nums[i];
                }
            }
            return subArrays<=k;
       }
}
