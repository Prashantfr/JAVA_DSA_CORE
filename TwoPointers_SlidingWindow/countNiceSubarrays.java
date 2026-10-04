//problem link : https://leetcode.com/problems/count-number-of-nice-subarrays/
//problem name : Count Number of Nice Subarrays

package TwoPointers_SlidingWindow;

//brute force solution with time complexity of O(n^2) and space complexity O(1).
/*class Solution {
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
}*/

//optimal solution with time complexity => O(N) and space complexity => O(1).
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private int atMost(int[] nums, int k){
        int n = nums.length;
        int left = 0;
        int count = 0;
        for(int right=0; right<n; right++){
            if(nums[right]%2 != 0){
                k--;
            }
            while(k<0){
                if(nums[left]%2!=0){
                    k++;
                }
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}