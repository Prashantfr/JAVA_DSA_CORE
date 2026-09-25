//problem link : https://takeuforward.org/practice/dsa/generate-binary-strings-without-consecutive-1s
//problem name : Generate Binary Strings Without Consecutive 1s

//Solution with time complexity of O(2^n) and space complexity is O(n).

package Recursion;
import java.util.*;

class Solution {
    public List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        solve(n , "" , ans);
        return ans;
    }

    public void solve(int n , String str , List<String> ans){
        if(str.length() == n){
            ans.add(str);
            return;
        }

        solve(n , str+"0" , ans);

        if(str.length() == 0 || str.charAt(str.length()-1) != '1'){
            solve(n , str+"1" , ans);
        }
    }
}