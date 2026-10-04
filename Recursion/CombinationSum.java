//problem link : https://leetcode.com/problems/combination-sum/description/
//problem name : Combination Sum

//Solution with time complexity of O(2^t) and space complexity is O(t).

package Recursion;
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0 , candidates , target , new ArrayList<>() , ans);
        return ans;
    }

    public void solve(int i , int[] arr , int target , List<Integer> list , List<List<Integer>> ans){
        if(i == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(arr[i] <= target){
            list.add(arr[i]);
            solve(i , arr , target-arr[i] , list , ans);
            list.remove(list.size()-1);
        }
        solve(i+1 , arr , target , list , ans);
    }
}
