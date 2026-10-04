//problem link : https://leetcode.com/problems/combination-sum-ii/description/
//problem name : Combination Sum 2

//Solution with time complexity of O(C(9, k) * k) and space complexity is O(k).

package Recursion;
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Solve(1 , k , n , new ArrayList<>() , ans);
        return ans;
    }

    public void Solve(int start , int k , int target , List<Integer> list , List<List<Integer>> ans){
        if(list.size() == k && target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(list.size() > k || target < 0) return;

        for(int i=start ; i<=9 ; i++){
            list.add(i);
            Solve(i+1 , k , target - i , list , ans);
            list.remove(list.size() - 1);
        }
    }
}