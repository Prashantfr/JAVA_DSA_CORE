//problem link : https://takeuforward.org/practice/dsa/count-all-subsequences-with-sum-k
//problem name : Count all subsequences with sum K

//Solution with time complexity of O(2^n) and space complexity is O(n).

package Recursion;

class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return solve(0 , k , nums);
    }

    public int solve(int i , int target , int[] nums){
        if(target == 0) return 1;

        if(i == nums.length || target < 0) return 0;

        int pick = solve(i+1 , target-nums[i] , nums);

        int notPick = solve(i+1 , target , nums);

        return pick + notPick;
    }
}
