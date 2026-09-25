//problem link : https://takeuforward.org/practice/dsa/check-if-there-exists-a-subsequence-with-sum-k
//problem name : Check if there exists a subsequence with sum K

//Solution with time complexity of O(2^n) and space complexity is O(n).

package Recursion;

class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
         return solve(0 , k , nums);
    }

    public boolean solve(int i , int target , int[] nums){
        if(target == 0) return true;

        if(i == nums.length || target < 0) return false;

        if(solve(i+1 , target-nums[i] , nums)) return true;

        if(solve(i+1 , target , nums)) return true;

        return false;
    }
}
