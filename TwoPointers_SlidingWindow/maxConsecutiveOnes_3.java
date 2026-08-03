//problem link : https://leetcode.com/problems/max-consecutive-ones-iii/
//brute force solution with a time complexity => O(n²) and space complexity => O(1).

package TwoPointers_SlidingWindow;
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        for(int i=0; i<n; i++){
            int zeroCount = 0;
            for(int j=i; j<n; j++){
                if(nums[j]==0){
                    zeroCount++;
                }
                if(zeroCount<=k){
                    int len = j-i+1;
                    maxLen = Math.max(maxLen,len);
                }
                else {
                    break;
                }
            }
        }
        return maxLen;
    }
}