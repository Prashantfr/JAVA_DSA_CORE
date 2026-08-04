//problem link : https://leetcode.com/problems/count-number-of-nice-subarrays/
//problem name : Count Number of Nice Subarrays

package TwoPointers_SlidingWindow;

//brute force solution with time complexity of O(n^2) and space complexity O(1).
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            int oddCount = 0;
            for(int j=i; j<n; j++){
                if(nums[j]%2 != 0){
                    oddCount++;
                }
                if(oddCount == k){
                    count++;
                }
                if(oddCount > k){
                    break;
                }
            }
        }
        return count;
    }
}
