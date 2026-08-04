//problem name : Binary Subarrays With Sum
//problem link : https://leetcode.com/problems/binary-subarrays-with-sum/

//brute force solution with time complexity of O(n^2) and space complexity O(1).
package TwoPointers_SlidingWindow;

class Solution {
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
}
