//problem link : https://leetcode.com/problems/combination-sum-ii/description/
//problem name : Combination Sum 2

//Solution with time complexity of O(2^n) and space complexity is O(n).

package Recursion;
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        Solve(0 , target , candidates , new ArrayList<>() , ans);
        return ans;
    }

    public void Solve(int index , int target , int[] arr , List<Integer> list , List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i<arr.length ; i++){
            if(i > index && arr[i] == arr[i-1]) continue;

            if(arr[i] > target) break;
            list.add(arr[i]);
            Solve(i+1 , target-arr[i] , arr , list , ans);
            list.remove(list.size() - 1);
        }
    }
}
