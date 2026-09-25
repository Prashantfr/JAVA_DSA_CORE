//problem link : https://leetcode.com/problems/subsets-ii/description/
//problem name : Subsets 2

//Solution with time complexity of O(2^n) and space complexity is O(n).

package Recursion;
import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        Solve(0 , nums , new ArrayList<>() , ans);
        return ans;
    }

    public void Solve(int index , int[] nums , List<Integer> list , List<List<Integer>> ans){
        
        ans.add(new ArrayList<>(list));

        for(int i = index ; i<nums.length ; i++){
            if(i > index && nums[i] == nums[i-1]) continue;

            list.add(nums[i]);
            Solve(i+1 , nums , list , ans);
            list.remove(list.size() - 1);
        }
    }
}
