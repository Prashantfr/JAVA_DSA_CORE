//problem link : https://leetcode.com/problems/generate-parentheses/description/
//problem name : Generate Parentheses

//Solution with time complexity of O(4ⁿ / √n) and Auxiliary space complexity is O(n).

package Recursion;
import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        Solve(n , 0 , 0 , "" , ans);
        return ans;
    }

    public void Solve(int n , int open , int close , String str , List<String> ans){
        if(str.length() == 2*n){
            ans.add(str);
            return;
        }

        if(open < n){
            Solve(n, open+1 , close , str+"(" , ans);
        }

        if(close < open){
            Solve(n , open , close+1 , str+")" , ans);
        }
    }
}
