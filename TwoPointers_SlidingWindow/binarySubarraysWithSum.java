//problem name : Binary Subarrays With Sum
//problem link : https://leetcode.com/problems/binary-subarrays-with-sum/

//brute force solution with time complexity of O(n^2) and space complexity O(1).
package TwoPointers_SlidingWindow;

/*class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                if(sum == goal){
                    count++;
                }
                else if(sum > goal){
                    break;
                }
            }
        }
        return count;
    }
}*/

//optimal solution with time complexity of O(n) and space complexity O(1).
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal){
        return atMost(nums, goal) - atMost(nums, goal-1);
      }

      private int atMost(int[] nums, int goal){
        if(goal<0) return 0;
        
        int n = nums.length;
        int left = 0;
        int count = 0;
        int sum = 0;
        for(int right=0; right<n; right++){
            sum += nums[right];
            while(sum > goal){
                sum -= nums[left];
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}
