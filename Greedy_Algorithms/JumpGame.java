//problem link : https://leetcode.com/problems/jump-game/description/
//problem name : Jump Game

//Solution with time complexity of O(n) and space complexity is O(1).

package Greedy_Algorithms;

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for(int i=0 ; i<nums.length ; i++){
            if(i > maxReach){
                return false;
            }
            maxReach = Math.max(maxReach , i+nums[i]);

            if(maxReach >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}