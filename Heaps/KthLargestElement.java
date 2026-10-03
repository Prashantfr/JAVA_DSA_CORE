//problem link : https://leetcode.com/problems/kth-largest-element-in-an-array/description/
//problem name : Kth Largest Element in an Array

//brute force solution with time complexity of O(nlog n)  and space complexity O(n).
//sorting method

package Heaps;
import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {

       int n = nums.length;

       Arrays.sort(nums);

       return nums[n-k];
       
    }
}
