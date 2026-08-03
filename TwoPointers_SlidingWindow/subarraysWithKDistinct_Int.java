//problem link:https://leetcode.com/problems/subarrays-with-k-different-integers/
//problem name : Subarrays with K Different Integers

//brute force solution with time complexity of O(n^2) and space complexity O(k).
package TwoPointers_SlidingWindow;

import java.util.HashSet;
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i; j<n; j++){
                set.add(nums[j]);

                if(set.size()==k){
                    count++;
                }
                else if(set.size()>k){
                    break;
                }
            }
        }
        return count;
    }
}
