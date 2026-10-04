//Two Sum
//Problem link: https://leetcode.com/problems/two-sum/

//brute solution with time complexity of O(n^2) and space complexity O(1).
/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // The outer loop picks the first number
        for (int i = 0; i < nums.length; i++) {
            
            // The inner loop picks the second number (always starting after the first one)
            for (int j = i + 1; j < nums.length; j++) {
                
                // Check if the pair adds up to the target
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j}; // Return their positions
                }
            }
        }
        
        return new int[] {}; // Safety net
    }
}
*/

//optimal solution with time complexity of O(N) and space complexity O(n).

import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer , Integer> map = new HashMap<>();

           for(int i=0 ; i<nums.length ; i++){

            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }

            else{
                map.put(nums[i],i);
            }

          }
          
           return new int[] {};
     }
}