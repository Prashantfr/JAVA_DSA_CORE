//problem link : https://leetcode.com/problems/jump-game-ii/description/
//problem name : Jump Game II

//Solution with time complexity of O(n) and space complexity is O(1). 

package Greedy_Algorithms;

class Solution {
    public int jump(int[] nums) {
       int jumps = 0;
       int farthest = 0;
       int currentEnd = 0;

       for(int i=0 ; i<nums.length-1 ; i++){
        farthest = Math.max(farthest , i+nums[i]);

       if(i == currentEnd){
        jumps++;
        currentEnd = farthest;
        }
      }
      return jumps;
    }
}
