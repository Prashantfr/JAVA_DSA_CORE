//problem link : https://leetcode.com/problems/subsets/description/
//problem name : Subsets

//Solution with time complexity of O(2^n * n) and Auxiliary space complexity is O(2ⁿ × n).

package Recursion;
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0 , nums , new ArrayList<>() , ans);
        return ans;
    }

    public void solve(int index , int[] nums , List<Integer> list , List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));

        for(int i=index ; i<nums.length ; i++){
            list.add(nums[i]);

            solve(i+1 , nums , list , ans);

            list.remove(list.size()-1);
        }
    }
}
